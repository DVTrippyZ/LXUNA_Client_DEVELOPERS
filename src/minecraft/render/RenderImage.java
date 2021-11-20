package render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class RenderImage {

	
	public static void render(String path, int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight) {
		 Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(path));
  	   Gui.drawModalRectWithCustomSizedTexture(x, y, u, v, width, height, textureWidth, textureHeight);
	}
	
	public static void renderSingle(String path, int x, int y, int width, int height, float textureWidth, float textureHeight) {
		 Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(path));
 	   Gui.drawModalRectWithCustomSizedTexture(x, y, 1, 1, width, height, textureWidth, textureHeight);
	}
	
	/*
	 * 
	 * x y u v width height textureWidth textureHeight 
	 */
}
