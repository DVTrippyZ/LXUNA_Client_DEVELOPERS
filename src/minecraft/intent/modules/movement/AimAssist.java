package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.EnumChatFormatting;

public class AimAssist extends Module{

	
	private float oldS;
	private float newS = 0.1f;
	public static boolean shouldDrawAIMLXUNA = false;
	
	
	public void onEnable() {
		
		oldS = mc.gameSettings.mouseSensitivity;
		
		
	}
	
	public void onDisable() {
		mc.gameSettings.mouseSensitivity = oldS;
		shouldDrawAIMLXUNA = false;
	}
	
	
	public AimAssist() {
		super("AimAssist", Keyboard.KEY_R, Category.COMBAT, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				if(mc.objectMouseOver.entityHit != null) {
					mc.gameSettings.mouseSensitivity = newS;
					shouldDrawAIMLXUNA = true;
					
				} else {
					mc.gameSettings.mouseSensitivity = oldS;
					shouldDrawAIMLXUNA = false;
				}
			}
		}
	}

}
