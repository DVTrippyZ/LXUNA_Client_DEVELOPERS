package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class HypixelFly extends Module{

	
	
	
	
	public void onEnable() {
	
		
		
	}
	
	public void onDisable() {
	
	 
	}
	
	
	public HypixelFly() {
		super("HypixelFly", Keyboard.KEY_NONE, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			    double y;
	            double y1;
	            mc.thePlayer.motionY = 0;
	            if(mc.thePlayer.ticksExisted % 3 == 0) {
	                y = mc.thePlayer.posY - 1.0E-10D;
	                mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, y, mc.thePlayer.posZ, true));
	            }
	            y1 = mc.thePlayer.posY + 1.0E-10D;
	            mc.thePlayer.setPosition(mc.thePlayer.posX, y1, mc.thePlayer.posZ);
			}
		}
	}

}
