package trippy.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.EnumChatFormatting;

public class LxunaOutput {
	public Minecraft mc = Minecraft.getMinecraft();
	
	public void renderOutput(String output) {
		FontRenderer fr = mc.fontRendererObj;
		
		fr.drawString(EnumChatFormatting.GREEN + output, 80 * 4 + 40, 235, -1);
	}
}
