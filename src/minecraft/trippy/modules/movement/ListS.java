package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class ListS extends Module{

	
	
	//mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(null));
	
	public void onEnable() {
		
		int count = 0;
		
		for(Module m: Client.modules) {
			mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(m.name));
			
			count++;
		}
		
	}
	
	public void onDisable() {
		
		
		
		for(Module m : Client.modules) {
			System.out.println(m.name);
		}
		

		
	}
	
	
	public ListS() {
		super("List", Keyboard.KEY_APOSTROPHE, Category.CHAT, "O");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
