package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.Client;
import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;

public class KeyPressLogs extends Module{

	
	public static boolean keyPressLogsLxunaOn = true;
	
	
	public void onEnable() {
		
		keyPressLogsLxunaOn = true;
		
		
	}
	
	public void onDisable() {
		
		keyPressLogsLxunaOn = false;
		
	}
	
	
	public KeyPressLogs() {
		super("KeyPress", Keyboard.KEY_NONE, Category.RENDER, "O");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
