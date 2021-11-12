package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.Client;
import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;

public class TestScript extends Module{

	
	
	
	
	public void onEnable() {
		
		//runs when you enable the script
		System.out.println("Started");
		
		
	}
	
	public void onDisable() {
		
		//runs when you disable the script
		System.out.println("Disabled");
	}
	
	
	public TestScript() {
		super("Example", Keyboard.KEY_TAB, Category.OPTIONS, "O");
		
		//name that you want to display in the tabGUI
		//hotkey
		//Category that the TabGUI uses for sorting
		//Is safe indicator that will be used later on for people to know if the hack is bannable
		//Y = safe, N = not safe, O = Other, U = unknown
		
	}
	
	
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				System.out.println("Running");
				//Code in here runs every frame
				
				
			}
		}
	}

}
