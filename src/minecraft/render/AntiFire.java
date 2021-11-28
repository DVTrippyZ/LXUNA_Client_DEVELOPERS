package render;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class AntiFire extends Module{

	
	public AntiFire() {
		super("AntiFire", Keyboard.KEY_NONE, Category.PLAYER, "U");
	}
	
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				
				
				if (!mc.thePlayer.capabilities.isCreativeMode && mc.thePlayer.onGround && mc.thePlayer.isBurning()) {
					for (int i = 0; i < 100; i++) {
						mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
					}
				}
				
				
			}
		}
	}
}
