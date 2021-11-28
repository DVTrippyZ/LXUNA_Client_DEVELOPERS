package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.event.ClickEvent;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;
import net.minecraft.entity.Entity;

public class AntiEntity extends Module{

	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		

	}
	
	
	public AntiEntity() {
		super("AntiEntity", Keyboard.KEY_NONE, Category.BYPASS, "U");
		
	}
	
	
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				for(Object entity : mc.theWorld.loadedEntityList) {
					
					if(entity != mc.thePlayer) {
						mc.theWorld.removeEntity((Entity)entity);
					}
				}
				
			}
		}
	}
	
	
	

}
