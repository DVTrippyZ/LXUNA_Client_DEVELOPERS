package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class HillRun extends Module{


	private float WalkSpeed = 0.9f;
	private float hightOfStep = 1.0f;
	private float defaultHightOfStep = 0.5f;
	
	
	
	public void onEnable() {
		
		mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.42, mc.thePlayer.posZ, mc.thePlayer.onGround));
		mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.75, mc.thePlayer.posZ, mc.thePlayer.onGround));
		mc.thePlayer.stepHeight = hightOfStep;
		
		
		
	}
	
	public void onDisable() {
		
		mc.thePlayer.stepHeight = defaultHightOfStep;
		
	}
	
	
	public HillRun() {
		super("HillRun", Keyboard.KEY_L, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
