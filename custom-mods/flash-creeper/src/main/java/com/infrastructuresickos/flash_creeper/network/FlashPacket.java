package com.infrastructuresickos.flash_creeper.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Sent server→client when a creeper flashes a player.
 * On receipt, rotates the player's view 180° away from the blast origin.
 */
public class FlashPacket {

    private final double x;
    private final double y;
    private final double z;

    public FlashPacket(Vec3 blastPos) {
        this.x = blastPos.x;
        this.y = blastPos.y;
        this.z = blastPos.z;
    }

    public FlashPacket(FriendlyByteBuf buf) {
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
    }

    public void handle(Supplier<NetworkEvent.Context> ctxSupplier) {
        NetworkEvent.Context ctx = ctxSupplier.get();
        ctx.enqueueWork(() -> {
            LocalPlayer player = Minecraft.getInstance().player;
            if (player == null) return;

            // Calculate direction from blast to player, then rotate view to face away
            Vec3 blastPos = new Vec3(x, y, z);
            Vec3 playerPos = player.position();
            Vec3 away = playerPos.subtract(blastPos);

            if (away.lengthSqr() < 1e-6) return; // too close, no direction

            // Convert "away" direction to yaw angle (facing away from blast)
            float yaw = (float) Math.toDegrees(Math.atan2(away.x, away.z));
            player.setYRot(yaw);
            player.yRotO = yaw;
        });
        ctx.setPacketHandled(true);
    }
}
