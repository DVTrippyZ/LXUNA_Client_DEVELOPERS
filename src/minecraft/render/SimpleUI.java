package render;

import org.lwjgl.input.Keyboard;

import trippy.modules.Module;
import trippy.modules.Module.Category;

public class SimpleUI extends Module{

	public static boolean simple = true;
	public void onEnable() {
		
		simple = true;
		
	}
	
	public void onDisable() {
		
		simple = false;
	}
	
	
	public SimpleUI() {
		super("SimpleUI", Keyboard.KEY_NONE, Category.RENDER, "Y");
		toggled = true;
	}
	
	
}
