package render;

import java.util.List;

import org.lwjgl.input.Keyboard;

import java.awt.Color;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.EnumChatFormatting;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventKey;
import trippy.events.listeners.EventRenderGUI;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;
import trippy.modules.bypass.BRLNS;
import trippy.settings.BooleanSetting;
import trippy.settings.Setting;

public class TabGUI extends Module{
	public boolean isShortCut = false;
	
	public int currentTab, moduleIndex, settingIndex;
	public boolean expanded;
	int count;
	public boolean thisTheme = false;
	private int animationManager;
	public static int aM = 0;
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
				//Temp Tag ? 1
				
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
					
					//tag1
					
					if(count == moduleIndex && m.expanded && m.settings.size() > 0) {
						
						
					    Gui.drawRect(70 + 68, 30, 70 + 68 + 68 + 20, 30 + m.settings.size() * 16 + 1,  LxunaColor.getGrey());
					    Gui.drawRect(70 + 68, 33 + m.index * 16, 7 + 61 + 68 + 68 + 20, 33 + m.index * 16 + 12, LxunaColor.getPurple());
					    int index = 0;
					    for (Setting setting : m.settings) {
					    	Module module_2_UP = modules.get(moduleIndex);
					    	Setting setting_2_UP = module_2_UP.settings.get(module_2_UP.index); 
							
							if(setting instanceof BooleanSetting) {
								
								BooleanSetting booleanSetting_Var = ((BooleanSetting) setting);
								fr.drawString(setting.name + ": " + (booleanSetting_Var.isEnabled() ? "On" : "Off"), 73 * 2, 35 + index*16, 0xffffffff);
								
								
								//Border
								Gui.drawRect((103 * 2) + 20, 30, ((70 + 68) * 2) - 67 + 20, 30 + m.settings.size() *16 + 2, LxunaColor.startRainbow(8));
								Gui.drawRect((70 * 2) - 2, m.settings.size() *16 + 30, ((70 + 68) * 2) - 48, 30 + m.settings.size() *16 + 2, LxunaColor.startRainbow(8));
								
							}
					    	
					    	
					      
					        index++;
					}
					  
				}
					
					
					if(m.toggled) {
						
						
						
						
						if(!modules.get(moduleIndex).name.equals(m.name)) {
							//TODO Config Tag
							if(BRLNS.config) {
								for(String ss : BRLNS.bannedModules) {
									if(!m.name.equals(ss)) {
										fr.drawString(m.name, 5 + 70, 35 + count*16, LxunaColor.getPink());
									}
								}
							} else {
								fr.drawString(m.name, 5 + 70, 35 + count*16, LxunaColor.getPink());
							}
						
							
						
						}
					} else{
						if(!modules.get(moduleIndex).name.equals(m.name)) {
							
							if(BRLNS.config) {
							for(String s : BRLNS.bannedModules) {
								
								if(!m.name.equals(s)) {
									fr.drawString(m.name, 5 + 70, 35 + count*16, -1);
								} else {
									fr.drawString(EnumChatFormatting.RED + m.name, 5 + 70, 35 + count*16, -1);
								}
							}
							
							
							
						} else {
							fr.drawString(m.name, 5 + 70, 35 + count*16, -1);
							
						}
						
						//Temp tag ? 3 : White
					}
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
				//Temp tag ? 2
				
					
			
					
					
					
					fr.drawString(modules.get(moduleIndex).name, 5 + 70 + aM, moduleIndex * 16 + 35, 0xff8832FF);
				
				
				
				
			}
			//Text Highlight and animation
			
		}
			
			
		}
		
		if(e instanceof EventKey) {
			int code = ((EventKey)e).code;
			
			List<Module> modules = Client.getModulesByCategory(Module.Category.values()[currentTab]);
			
			if(code == Keyboard.KEY_UP) {
				aM = 0;
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	int speed = 1;
				            	int divisibleBy = 500;
				            	if(!(aM > 5)) {
				            		
				            		for(int zz = 0; zz < 5000; zz++) {
				            			if(zz% divisibleBy == 0) {
				            				aM+=speed;
				            			}
				            		}
				            		
				            	}
				            	
				            	
				            }
				            
				            
				        }, 
				        100
				);
				if(expanded) {
					
					Module module = modules.get(moduleIndex);
					if(expanded && !modules.isEmpty() && modules.get(moduleIndex).expanded && module.settings.size() > 0) {
						
						if(module.index <= module.settings.size() - 1) {
						    module.index = 0; 
						} else {
							module.index--;
						}
					}
					
					
					
					
				else if(moduleIndex <= 0) {
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
				aM = 0;
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	int speed = 1;
				            	int divisibleBy = 500;
				            	if(!(aM > 5)) {
				            		
				            		for(int zz = 0; zz < 5000; zz++) {
				            			if(zz% divisibleBy == 0) {
				            				aM+=speed;
				            			}
				            		}
				            		
				            	}
				            	
				            	
				            }
				            
				            
				        }, 
				        100
				);
				
				if(expanded) {
					Module module = modules.get(moduleIndex);
					if(expanded && !modules.isEmpty() && modules.get(moduleIndex).expanded && module.settings.size() > 0) {    
						
						
						if(module.index >= module.settings.size() - 1) {
						    module.index = 0; 
						} else {
							module.index++;
						}
					}
					
					
					
					else if(moduleIndex >= modules.size() - 1) {
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
//				count = 0;
				
				
				if(expanded && modules.get(moduleIndex).expanded) {
					modules.get(moduleIndex).expanded = false;
					
					
					expanded = true;
				} else {
				if(!modules.get(moduleIndex).expanded) {
				expanded = false;
				moduleIndex = 0;
					}
				}
			}
			
			//tag2
			
			if(code == Keyboard.KEY_RIGHT) {
				
				if(expanded) {
					Module module = modules.get(moduleIndex);
					if(!module.expanded && module.settings.size() > 0) {
					module.expanded = true;
					}
					
				} else {
					
					Module module_var_5_ = modules.get(moduleIndex);
					
					if(!module_var_5_.expanded) {
						expanded = true;
					}
					
				
					
					//TAG?1
				}
			}
			
			
			if(code == Keyboard.KEY_RETURN) {
				Module module = modules.get(moduleIndex);
				if(expanded && !module.expanded) {
					
					modules.get(moduleIndex).toggle();
					
					
					
				} else if (module.expanded) { 
					Setting setting = module.settings.get(module.index); 
					
					if(setting instanceof BooleanSetting) {
						((BooleanSetting)setting).toggle();
						
						
					}

					
					
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



 NOW watch vid




*/
