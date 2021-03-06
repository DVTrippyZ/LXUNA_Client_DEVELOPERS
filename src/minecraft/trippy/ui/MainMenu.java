package trippy.ui;

import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.util.ResourceLocation;
import trippy.alt.AltManager;
import trippy.alt.GuiAltManager;

public class MainMenu extends GuiScreen {

	
	private boolean hovered = false;
	
	public MainMenu() {
		
	}
	
	public void initGui() {
		//Runs once the main menu is about to be loaded
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		
		mc.getTextureManager().bindTexture(new ResourceLocation("img/Main.png"));
		
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		this.drawGradientRect(0, height - 100, width, height, 0x00000000, 0xff000000);
		this.drawString(fontRendererObj, "Developers: dvtrippy, Chummy", 7, 230, -1);
		this.drawString(fontRendererObj, "Designer: Papa Quil -", 360, 230, -1);
		String[] buttons = { "Singleplayer", "Multiplayer", "Settings", "AltManager" };
		int count = 0;
		for(String name: buttons) {
			
			int x = width - 400;
			
			int y = (height/buttons.length) * count + 30;
			
			int fixedY = height - 120;
			
			
			this.drawCenteredString(mc.fontRendererObj, name, (width/buttons.length) * count + 50, fixedY, -1);
			
			if(mouseX >= x && mouseY >= mouseY && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT) {
				
				switch (name) {
				case "Singleplayer	":
				
					hovered = true;
					System.out.println(hovered);
					
					break;
				case "Multiplayer		":
					
					break;
				case "Settings		":
					
					break;
					
				case "Quit		":
					
					break;
					
				}
			
			}
			count++;
			
		}
	}
				
			
			
		
		

	public void mouseClicked(int mouseX, int mouseY, int button) {
		
		String[] buttons = { "Singleplayer", "Multiplayer", "Settings", "AltManager" }; 
		int count = 0;
		for(String name: buttons) {
			
			int x = (width/buttons.length) * count + 50;
			
			int y = height - 20;
			
			
			
			if(mouseX >= x && mouseY >= mouseY && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT) {
				
				switch (name) {
				case "Singleplayer":
					mc.displayGuiScreen(new GuiSelectWorld(this));
					break;
				case "Multiplayer":
					mc.displayGuiScreen(new GuiMultiplayer(this));
					break;
				case "Settings":
					mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
					break;
					
				case "AltManager":
					mc.displayGuiScreen(new GuiAltManager());
					break;
					
				}
			
			}
			count++;
			
		}
		
	}
	
	public void onGuiClosed() {
		
	}
}
