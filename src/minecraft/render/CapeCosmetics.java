package render;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.renderer.entity.layers.LayerCape;
import trippy.modules.Module;

public class CapeCosmetics extends Module{

	public CapeCosmetics() {
		super("Cape", Keyboard.KEY_NONE, Category.RENDER, "Y");
		
	}
	
	public void onEnable() {
		LayerCape.on__ = true;
	}
	
	
	public void onDisable() {
		LayerCape.on__ = false;
	}
	

}
