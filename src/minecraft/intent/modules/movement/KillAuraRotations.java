package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.EnumChatFormatting;

public class KillAuraRotations extends Module{

	
	
	
	public static boolean Rotate2 = true;
	
	
	public void onEnable() {
		Rotate2 = true;
	
		
		
	}
	
	public void onDisable() {
		Rotate2 = false;
		
	}
	
	
	public KillAuraRotations() {
		super("KillAuraRotate", Keyboard.KEY_NONE, Category.OPTIONS, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				
			}
		}
	}
	
	
	
	

}
