package trippy.modules.movement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;
import trippy.settings.BooleanSetting;
import trippy.utility.Timer;
import net.minecraft.network.play.client.C03PacketPlayer;

public class CriticalAura extends Module {

	public Timer timer = new Timer();
	public BooleanSetting rotations = new BooleanSetting("Rotations", false);
	
	
	
	public void onEnable() {
		
		//mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.42, mc.thePlayer.posZ, mc.thePlayer.onGround));
		
		
		
		
	}
	
	public void onDisable() {
		
		
		
	}
	
	
	public CriticalAura() {
		
		
		super("CriticalAura", Keyboard.KEY_EQUALS, Category.COMBAT, "U");
		this.addSettings(rotations);
		
		
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			
				List<EntityLivingBase> targets = (List<EntityLivingBase>) mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
				
				targets = targets.stream().filter(entity-> entity.getDistanceToEntity(mc.thePlayer) < 5 && entity != mc.thePlayer).collect(Collectors.toList());
				
				targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));
				
				
				if(!targets.isEmpty()) {
					EntityLivingBase target = targets.get(0);
					
					if(timer.hasTimeElapsed(1000 / 10, true)) {
						mc.thePlayer.swingItem();
						if(mc.thePlayer.onGround) {
							mc.thePlayer.addVelocity(0, 0.2, 0);
							mc.thePlayer.fallDistance = 0.2F;
							mc.thePlayer.onGround = false;
							
						}
						mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(target, Action.ATTACK));
						
						if(rotations.isEnabled()) {
							mc.thePlayer.rotationYaw = getRotations2(target)[0];
							mc.thePlayer.rotationPitch = getRotations2(target)[1];
						}
					}
				}
			}
		}
	}
	
	
	public float[] getRotations2 (Entity e) {
		double deltaX = e.posX + (e. posX - e.lastTickPosX) - mc.thePlayer.posX,
		deltay = e.posY - 3.5 + e.getEyeHeight() - mc. thePlayer.posY + mc. thePlayer.getEyeHeight(),
		deltaz = e.posZ + (e.posZ - e.lastTickPosZ) - mc. thePlayer.posZ,
		distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaz, 2));
		float yaw = (float) Math. toDegrees(-Math.atan(deltaX / deltaz)),
		pitch = (float) -Math. toDegrees(Math.atan(deltay / distance));
		if(deltaX < 0 && deltaz < 0) {
		yaw = (float) (90 + Math. toDegrees (Math.atan(deltaz / deltaX)));
		}else if(deltaX > 0 && deltaz < 0) {
		yaw = (float) (-90 + Math. toDegrees(Math.atan(deltaz / deltaX)));
		}
		return new float[] { yaw, pitch } ;
		
		}

}
