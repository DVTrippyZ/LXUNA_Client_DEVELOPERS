package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.material.Material;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Elytra extends Module{

	
	
	
	
	public void onEnable() {
		
		
			
		} 
			
		
		
	
	
	public void onDisable() {
//		double oldY = mc.thePlayer.motionY;
//		float oldJ = mc.thePlayer.jumpMovementFactor;
		mc.thePlayer.motionY = 0;
		mc.thePlayer.jumpMovementFactor = 0;
		
	}
	
	
	public Elytra() {
		super("Elytra", Keyboard.KEY_Z, Category.MOVEMENT, "N");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.motionY < 0.0d && mc.thePlayer.isAirBorne && !mc.thePlayer.isInWater() && !mc.thePlayer.isOnLadder() && !mc.thePlayer.isInsideOfMaterial(Material.lava)) {
					mc.thePlayer.motionY = -.127d;
					mc.thePlayer.jumpMovementFactor *= 2.12337f;
					
			}
				
				
		}
	}
	}
}


