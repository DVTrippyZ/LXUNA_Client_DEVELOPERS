package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.event.ClickEvent;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.entity.Entity;

public class AntiBot extends Module{

	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		

	}
	
	
	public AntiBot() {
		super("AntiBot", Keyboard.KEY_NONE, Category.BYPASS, "U");
		
	}
	
	
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				for(Object entity : mc.theWorld.loadedEntityList) {
					if(((Entity)entity).isInvisible() && entity != mc.thePlayer) {
						mc.theWorld.removeEntity((Entity)entity);
					}
					
				
				}
				
			}
		}
	}
	
	
	

}
