package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Tp extends Module{
	 private EntityOtherPlayerMP playerCopy;
	public Tp() {
		super("FreeCam", Keyboard.KEY_NONE, Category.PLAYER, "U");
		
	}
	
	@Override
	public void onEnable(){
		Blink.ME = true;
		for(Module m : Client.modules) {
			if(m.name.equals("Blink")) {
				m.toggled = false;
			}
		}
		
		
		 this.playerCopy = new EntityOtherPlayerMP((World)mc.theWorld, mc.thePlayer.getGameProfile());
	        this.playerCopy.inventory = this.mc.thePlayer.inventory;
	        this.playerCopy.inventoryContainer = this.mc.thePlayer.inventoryContainer;
	        this.playerCopy.setPositionAndRotation(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ, this.mc.thePlayer.rotationYaw, this.mc.thePlayer.rotationPitch);
	        this.playerCopy.rotationYawHead = this.mc.thePlayer.rotationYawHead;
	        this.mc.theWorld.addEntityToWorld(-1, (Entity)this.playerCopy);
		
		
	}
	
	
	@Override
	public void onDisable(){
		Blink.ME = false;
		mc.thePlayer.capabilities.isFlying = false;
		this.mc.theWorld.removeEntityFromWorld(-1);
		Blink.clear();
	}
	
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.thePlayer.capabilities.isFlying = true;
			}
		}
	}

}
