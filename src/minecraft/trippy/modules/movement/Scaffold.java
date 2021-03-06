package trippy.modules.movement;

import java.util.Timer;
import java.util.TimerTask;

import org.lwjgl.input.Keyboard;

import net.minecraft.event.ClickEvent;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;

public class Scaffold extends Module{

	
	private static boolean cooldown = false;
	public static boolean scaffolding = false;
	
	public void onEnable() {
		
		scaffolding = true;
		
	}
	
	public void onDisable() {
		scaffolding = false;
		unCrouch();
	}
	
	
	public Scaffold() {
		super("Scaffold", Keyboard.KEY_P, Category.PLAYER, "U");
		
	}
	
	
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				
				
				BlockPos playerBlock = new BlockPos(mc.thePlayer.posX, mc.thePlayer.getEntityBoundingBox().minY, mc.thePlayer.posZ);
				
				
				
				if(mc.theWorld.isAirBlock(playerBlock.add(0, -1, 0))) {
				
					
					if(isValidBlock(playerBlock.add(0, -2, 0))) {
						place(playerBlock, EnumFacing.DOWN);
					}if(mc.theWorld.isAirBlock(playerBlock.add(0, -1, 0))) {
							if(isValidBlock(playerBlock.add(0, -2, 0))) {
								place(playerBlock.add(0, -1, 6), EnumFacing.UP);
								}else if(isValidBlock(playerBlock.add(-1, -1, 0))) {
								place(playerBlock.add(0, -1, 0), EnumFacing.EAST);
								}else if(isValidBlock(playerBlock.add(1, -1, 0))) { 
								place(playerBlock.add(0, -1, 0), EnumFacing.WEST);
								}else if(isValidBlock(playerBlock.add(0, -1, -1))) {
								place(playerBlock.add(0, -1, 0), EnumFacing.SOUTH);
								}else if(isValidBlock(playerBlock.add(0, -1, 1))) {
								place(playerBlock.add(0, -1, 0), EnumFacing. NORTH);
								}else if(isValidBlock (playerBlock.add(1, -1, 1))) {
								if(isValidBlock(playerBlock.add(0, -1, 1))) {
								place(playerBlock.add(0, -1, 1), EnumFacing.NORTH);
								}
								place(playerBlock.add(1, -1, 1), EnumFacing.EAST);
								}
								}

				}
				
			}
		}
	}
	
	
	private boolean isValidBlock(BlockPos pos) {
		Block b = mc.theWorld.getBlockState(pos).getBlock();
		return(!(b instanceof BlockLiquid)) && (b.getMaterial() != Material.air);
	}
	
	private void place(BlockPos pos, EnumFacing face) {
		cooldown = true;
		if(face == EnumFacing.UP) {
			pos = pos.add(0, -1, 0);
		} else if(face == EnumFacing.NORTH) {
			pos = pos.add(0, 0, 1);
		} else if(face == EnumFacing.EAST) {
			pos = pos.add(-1, 0, 0);
		}else if(face == EnumFacing.SOUTH) {
			pos = pos.add(0, 0, -1);
		}else if(face == EnumFacing.WEST) {
			pos = pos.add(1, 0, 0);
		}
		
		
		if((mc.thePlayer.getHeldItem() != null) && mc.thePlayer.getHeldItem().getItem() instanceof ItemBlock) {
			if(mc.gameSettings.keyBindSneak.pressed) {
				mc.gameSettings.keyBindSneak.pressed = false;
			}
			
			mc.thePlayer.swingItem();
			mc.playerController.func_178890_a(mc.thePlayer, mc.theWorld, mc.thePlayer.getHeldItem(), pos, face, new Vec3(0.5D, 0.5D, 0.5D));
		} else {
			
			mc.gameSettings.keyBindSneak.pressed = true;
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	unCrouch();
			            }
			        }, 
			        2000 
			);
		  
			
			
		}
		
	}
	
	
	
	private void unCrouch() {
		if(mc.gameSettings.keyBindSneak.pressed) {
			mc.gameSettings.keyBindSneak.pressed = false;
		}
	}
	
	
	

}
