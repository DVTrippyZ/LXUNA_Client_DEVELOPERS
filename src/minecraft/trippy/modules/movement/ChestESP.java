package trippy.modules.movement;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Color;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;

import net.minecraft.tileentity.*;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class ChestESP extends Module{

	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		

		
	}
	
	
	public ChestESP() {
		super("ChestESP", Keyboard.KEY_NONE, Category.RENDER, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}
	
	
	public void onRender() {
		
		
		
		
		
	}
	

}
