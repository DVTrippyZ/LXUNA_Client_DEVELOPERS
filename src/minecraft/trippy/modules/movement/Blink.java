package trippy.modules.movement;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.world.World;
import trippy.Client;
import trippy.events.Event;
import trippy.events.PacketSendEvent;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Blink extends Module{

	public static boolean ME = false;
	 private EntityOtherPlayerMP playerCopy;
	    private static List<Packet> packetList = new ArrayList<Packet>();
	    //Entity Player SP
	   
	    public void onEnable() {
	    	for(Module m : Client.modules) {
				if(m.name.equals("FreeCam")) {
					m.toggled = false;
				}
			}
	    	
	    	
	    	ME = true;
	        if (this.mc.thePlayer == null) {
	            return;
	        }
	        this.playerCopy = new EntityOtherPlayerMP((World)mc.theWorld, mc.thePlayer.getGameProfile());
	        this.playerCopy.inventory = this.mc.thePlayer.inventory;
	        this.playerCopy.inventoryContainer = this.mc.thePlayer.inventoryContainer;
	        this.playerCopy.setPositionAndRotation(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ, this.mc.thePlayer.rotationYaw, this.mc.thePlayer.rotationPitch);
	        this.playerCopy.rotationYawHead = this.mc.thePlayer.rotationYawHead;
	        this.mc.theWorld.addEntityToWorld(-1, (Entity)this.playerCopy);
	      
	    }

	    
	    public static void add(Packet packet) {
	        //if (event.packet instanceof C0BPacketEntityAction || event.packet instanceof C03PacketPlayer || event.packet instanceof C02PacketUseEntity || event.packet instanceof C0APacketAnimation || event.packet instanceof C08PacketPlayerBlockPlacement) {
	            packetList.add(packet);
	           
	            System.out.println(packet);
	        //}
	    }
	    
	    public static void clear() {
	    	packetList.clear();
	    }

	   
	    public void onDisable() {
	    	ME = false;
	        for (Packet packet : this.packetList) {
	            this.mc.thePlayer.sendQueue.addToSendQueue(packet);
	            System.out.println(packet);
	        }
	        this.packetList.clear();
	        this.mc.theWorld.removeEntityFromWorld(-1);
	    }
	
	
	public Blink() {
		super("Blink", Keyboard.KEY_NONE, Category.PLAYER, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
