package render;

import java.util.List;

import org.lwjgl.input.Keyboard;

import intent.Client;
import intent.events.Event;
import intent.events.listeners.EventKey;
import intent.events.listeners.EventRenderGUI;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.EnumChatFormatting;

public class TabGUI extends Module{
	public boolean isShortCut = false;
	
	public int currentTab, moduleIndex;
	public boolean expanded;
	int count;
	public boolean thisTheme = false;
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		
		
	}
	
	
	public TabGUI() {
		super("TabGUI", Keyboard.KEY_COMMA, Category.RENDER, "Y");
		toggled = true;
		
	}
	
	public void onEvent(Event e) {
		
		if(e instanceof EventRenderGUI) {
			FontRenderer fr = mc.fontRendererObj;
			
			
				if(thisTheme) {
					Gui.drawRect(5, 30, 70, 30 + Module.Category.values().length*16 + 2, 0xff000000);
				} else {
			 
				Gui.drawRect(5, 30, 70, 30 + Module.Category.values().length*16 + 2, 0xff333647);
				//Gui.drawRect(5, 31, 70, 30 + Module.Category.values().length*16 + 7, 0x90000000);
				}
				//Indicator White Rect
				Gui.drawRect(7, 33 + currentTab * 16, 7 + 61, 33 + currentTab * 16 + 12, 0xff8835db);
				
			
			
			//Gui.drawRect(7,  33 + currentTab * 16, 8, 33 + currentTab * 16 + 12 + 7, 0xffffffff);
			
			count = 0;
			for(Category c : Module.Category.values()) {
				fr.drawString(c.name, 11, 35 + count*16, -1);
				
				count++;
			}
			
			if(expanded) {
			List<Module> modules = Client.getModulesByCategory(Module.Category.values()[currentTab]);
			
			//EXPANDED VIEW
			//Expanded
			
			
			if(thisTheme) {
				Gui.drawRect(70, 31, 70 + 68, 30 + modules.size() *16 + 2, 0xff000000);
				Gui.drawRect(72, 33 + moduleIndex * 16, (7 + 61 + 68), 33 + moduleIndex * 16 + 12, 0xff8835db);
				
				
				
			} else {
				//BG
				Gui.drawRect(70, 31, 70 + 68, 30 + modules.size() *16 + 2, 0xff333647);
			}
			
			
			//Outline
			
			Gui.drawRect(140, 31, 70 + 68, 30 + modules.size() *16 + 2, 0xff8835db);
			Gui.drawRect(70, modules.size() *16 + 30, 70 + 68, 30 + modules.size() *16 + 2, 0xff8835db);
			
			//Outline end
			
			//Indicator White Rect
			
			
			//cyan 00FFFF
			//fr.drawString(modules.get(moduleIndex).name.substring(4), 5 + 70, moduleIndex * 16 + 35, 0xff00FFFF);
			
			count = 0;
			for(Module m : modules) {
				if(!isShortCut) {
					
					
					
					
					if(m.toggled) {
						
						
						
						
						
						fr.drawString(m.name, 5 + 70, 35 + count*16, 0xffFFC0CB);
					} else{
						fr.drawString(m.name, 5 + 70, 35 + count*16, -1);
					}
					
				} else {
					if(m.toggled) {
						fr.drawString(EnumChatFormatting.GREEN + m.name, 5 + 70, 35 + count*16, -1);
					} else {
						fr.drawString(m.name, 5 + 70, 35 + count*16, -1);
					}
					
				}
				
				
				count++;
			}
			
			
			if(thisTheme) {
				
			} else {
				fr.drawString(modules.get(moduleIndex).name, 5 + 70, moduleIndex * 16 + 35, 0xff8832FF);
			}
			//Text Highlight
			
		}
			
			
		}
		
		if(e instanceof EventKey) {
			int code = ((EventKey)e).code;
			
			List<Module> modules = Client.getModulesByCategory(Module.Category.values()[currentTab]);
			
			if(code == Keyboard.KEY_UP) {
				
				if(expanded) {
					if(moduleIndex <= 0) {
						moduleIndex = modules.size() - 1;
					} else 
						moduleIndex--;
				} else {
					if(currentTab <= 0) {
						currentTab = Module.Category.values().length - 1;
					} else {
						currentTab--;
					}
				}
				
				
			}
			
			
			if(code == Keyboard.KEY_DOWN) {
				
				if(expanded) {
					if(moduleIndex >= modules.size() - 1) {
						moduleIndex = 0;
					}else 
						moduleIndex++;
				} else {
					if(currentTab >= Module.Category.values().length - 1) {
						currentTab = 0;
					}else {
						currentTab++;
					}
				}
				
				
				
					}
			
			
			
			
			if(code == Keyboard.KEY_LEFT) {
				count = 0;
				moduleIndex = 0;
				expanded = false;
			}
			
			if(code == Keyboard.KEY_RIGHT) {
				
				if(expanded) {
					
					modules.get(moduleIndex).toggle();
					
				} else {
					
					expanded = true;
				}
			}
			
			if(code == Keyboard.KEY_BACK) {
				if(expanded) {
					modules.get(moduleIndex).toggle();
				}
				
			
				
			}
			
			
		}
	}
	
	

}






/*


if the module has a expanded function to return true {

	expand it expand2
	show toggles
}








*/
