package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.Client;
import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NameChanger extends Module{

	public static boolean toggled_1 = false;
	public static String name_1 = "Chummy";
	
	
	public void onEnable() {
		toggled_1 = true;
		
		
	}
	
	public void onDisable() {
		
		toggled_1 = false;
		
	}
	
	
	public NameChanger() {
		super("NameChanger", Keyboard.KEY_NONE, Category.PLAYER, "U");
		
	}
	
	public static String getName_1() {
		return name_1;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				
				
				
			}
		}
	}

}
