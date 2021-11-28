package render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import intent.modules.Module.Category;
import net.minecraft.block.Block;

public class Xray extends Module {

	public static boolean xray_ = false;
	private float gammaSetting_ = 0f;
	
	public static ArrayList<Block> xrayBlocks = new ArrayList(); 



	
	public Xray() {
		super("Xray", Keyboard.KEY_NONE, Category.RENDER, "U");
	}

	
	
	
	
	public void onEnable() {
		gammaSetting_ = mc.gameSettings.gammaSetting;
		mc.renderGlobal.loadRenderers();
		mc.gameSettings.gammaSetting = 100f;
		addBlocks();
		xray_ = true;
		
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = gammaSetting_;
		mc.renderGlobal.loadRenderers();
		xray_ = false;
	}
	
	
	
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}
	
	public static boolean isXrayBlock(Block b) {
	if(xrayBlocks.contains(b)) {
		return true;
	}
	
	return false;
	
}
	
	
	public static void addBlocks() {
		xrayBlocks.add(Block.getBlockFromName("coal_ore"));
		xrayBlocks.add(Block.getBlockFromName("iron_ore"));
		xrayBlocks.add(Block.getBlockFromName("gold_ore"));
		xrayBlocks.add(Block.getBlockFromName("redstone_ore"));
		xrayBlocks.add(Block.getBlockById(74));
		xrayBlocks.add(Block.getBlockFromName("lapis_ore"));
		xrayBlocks.add(Block.getBlockFromName("diamond_ore"));
		xrayBlocks.add(Block.getBlockFromName("emerald_ore"));
		xrayBlocks.add(Block.getBlockFromName("quartz_ore"));
		xrayBlocks.add(Block.getBlockFromName("clay"));
		xrayBlocks.add(Block.getBlockFromName("glowstone"));
		xrayBlocks.add(Block.getBlockById(8));
		xrayBlocks.add(Block.getBlockById(9));
		xrayBlocks.add(Block.getBlockById(10));
		xrayBlocks.add(Block.getBlockById(11));
		xrayBlocks.add(Block.getBlockFromName("crafting_table"));
		xrayBlocks.add(Block.getBlockById(61));
		xrayBlocks.add(Block.getBlockById(62));
		xrayBlocks.add(Block.getBlockFromName("torch"));
		xrayBlocks.add(Block.getBlockFromName("ladder"));
		xrayBlocks.add(Block.getBlockFromName("tnt"));
		xrayBlocks.add(Block.getBlockFromName("coal_block"));
		xrayBlocks.add(Block.getBlockFromName("iron_block"));
		xrayBlocks.add(Block.getBlockFromName("gold_block"));
		xrayBlocks.add(Block.getBlockFromName("diamond_block"));
		xrayBlocks.add(Block.getBlockFromName("emerald_block"));
		xrayBlocks.add(Block.getBlockFromName("redstone_block"));
		xrayBlocks.add(Block.getBlockFromName("lapis_block"));
		xrayBlocks.add(Block.getBlockFromName("fire"));
		xrayBlocks.add(Block.getBlockFromName("mossy_cobblestone"));
		xrayBlocks.add(Block.getBlockFromName("mob_spawner"));
		xrayBlocks.add(Block.getBlockFromName("end_portal_frame"));
		xrayBlocks.add(Block.getBlockFromName("enchanting_table"));
		xrayBlocks.add(Block.getBlockFromName("bookshelf"));
		xrayBlocks.add(Block.getBlockFromName("command_block"));
	}

}
