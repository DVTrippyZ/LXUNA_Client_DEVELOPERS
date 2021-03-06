package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;
import trippy.settings.BooleanSetting;

public class HypixelFly extends Module{
	
	double y;
	double x;
	double z;
	
	public BooleanSetting b = new BooleanSetting("LiveClone", false);
	public static boolean pak = false;
	private EntityOtherPlayerMP oldPlayer;
	
	
	public void onEnable() {
		
		this.addSettings(b);
		y = mc.thePlayer.posY;
		x = mc.thePlayer.posX;
		z = mc.thePlayer.posZ;
		pak = true;
		oldPlayer = new EntityOtherPlayerMP(mc.theWorld, mc.thePlayer.getGameProfile());

		oldPlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ);

		oldPlayer.rotationYawHead = mc.thePlayer.rotationYawHead;
		oldPlayer.clonePlayer(mc.thePlayer, true);
		oldPlayer.copyLocationAndAnglesFrom(mc.thePlayer);
		oldPlayer.rotationYaw = mc.thePlayer.rotationYaw;

		mc.theWorld.addEntityToWorld(-123, oldPlayer);

		super.onEnable();
	}
	
	public void onDisable() {
		mc.theWorld.removeEntityFromWorld(-123);
		pak = false;
		
	}
	
	
	public HypixelFly() {
		super("LxunaFly", Keyboard.KEY_NONE, Category.PLAYER, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			    double y;
	            double y1;
	            mc.thePlayer.motionY = 0;
	            if(mc.thePlayer.ticksExisted % 3 == 0) {
	                y = mc.thePlayer.posY - 1.0E-10D;
	                mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, y, mc.thePlayer.posZ, true));
	            }
	            y1 = mc.thePlayer.posY + 1.0E-10D;
	            mc.thePlayer.setPosition(mc.thePlayer.posX, y1, mc.thePlayer.posZ);
			}

				
				moveClone();
				
				
				if (oldPlayer == null) {
					return;
				}
				
				if(b.isEnabled()) {
					copyMovement();
				}
				
			}
	}

	
	
	private void copyMovement() {
		
		oldPlayer.rotationYawHead = mc.thePlayer.rotationYawHead;
		oldPlayer.rotationYaw = mc.thePlayer.rotationYaw;
		
	}
	
	private void moveClone() {
		oldPlayer.rotationYawHead = mc.thePlayer.rotationYawHead;
		oldPlayer.rotationYaw = mc.thePlayer.rotationYaw;
		
		oldPlayer.setPosition(mc.thePlayer.posX -3, mc.thePlayer.posY, mc.thePlayer.posZ - 4);
		
		
	}
	
	

	
	

}
