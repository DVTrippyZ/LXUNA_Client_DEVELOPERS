package trippy.modules.movement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;
import trippy.utility.Timer;
import net.minecraft.network.play.client.C03PacketPlayer;

public class KillAuraGUI extends Module {

	public Timer timer = new Timer();
	public static int targetHealth = 0;
	public static boolean isAttackingTarget = false;
	public static EntityLivingBase fixTarget = null;
	public static int distToTargetLX;
	public static int armorOfTARGETLX;
	public static String targetName_ = " ";
	public static String targetWin_ = " ";
	public void onEnable() {
		
		//mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.42, mc.thePlayer.posZ, mc.thePlayer.onGround));
		
		
		
		
	}
	
	public void onDisable() {
		
		isAttackingTarget = false;
		
		
	}
	
	
	public KillAuraGUI() {
		super("TargetStats", Keyboard.KEY_NONE, Category.RENDER, "Y");
		toggled = true;
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			
				List<EntityLivingBase> targets = (List<EntityLivingBase>) mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
				
				targets = targets.stream().filter(entity-> entity.getDistanceToEntity(mc.thePlayer) < 6 && entity != mc.thePlayer).collect(Collectors.toList());
				
				targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));
				
				
				if(!targets.isEmpty()) {
					EntityLivingBase target = targets.get(0);
					
					if(timer.hasTimeElapsed(300 / 10, true)) {
						
						targetHealth = (int)target.getHealth();
						isAttackingTarget = true;
						fixTarget = targets.get(0);
						armorOfTARGETLX = target.getTotalArmorValue();
						
						distToTargetLX = (int)target.getDistanceToEntity(mc.thePlayer);
						targetName_ = target.getDisplayName().getFormattedText();
						
						if((int)target.getHealth() >= mc.thePlayer.getHealth()) {
							targetWin_ = "Loosing...";
						} else {
							targetWin_ = "Winning!";
						}
						
						
					}
				}else {
					isAttackingTarget = false;
				}
			}
		}
	}
	
	
	


}
