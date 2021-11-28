package render;

import org.lwjgl.input.Keyboard;

import net.minecraft.inventory.ContainerChest;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class ChestStealer extends Module{

	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		
//to make a new script copy this one, paste in the same namespace, then go to client and add it.
		
	}
	
	
	public ChestStealer() {
		super("ChestStealer", Keyboard.KEY_NONE, Category.PLAYER, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				
				if (mc.thePlayer.openContainer != null && mc.thePlayer.openContainer instanceof ContainerChest) {
					
					
					ContainerChest container = (ContainerChest) mc.thePlayer.openContainer;
					for (int i = 0; i < container.getLowerChestInventory().getSizeInventory(); i++) {
						if (container.getLowerChestInventory().getStackInSlot(i) != null) {
							
								mc.playerController.windowClick(container.windowId, i, 0, 1, mc.thePlayer);
								
							
						}
					}
				}
				
				
			}
		}
	}

}
