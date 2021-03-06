package trippy.modules.bypass;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class BRLNS extends Module{

	
	public static List<String> allowedModules = new ArrayList<String>();
	public static List<String> bannedModules = new ArrayList<String>();
	public static boolean config = false;
	
	//TODO add enable after disable module list
	public BRLNS() {
		super("play.brlns.net", Keyboard.KEY_NONE, Category.CONFIG, "Y");
		
		
	}

	@Override 
	public void onDisable() {
		config = false;
	}
	
	
	@Override
	public void onEnable() {
		addItems();
		config = true;
	
		
		
		for(Module m : Client.modules) {
			
			for(String s : allowedModules) {
			
			if(m.name.equals(s)) {
				
				System.out.println(s);
				m.toggled = true;
			} 
		
		
		
		
		
		
		
	}
			
			
			
			
			
		}
	}
	
	public void addItems() {
		
		a("play.brlns.net");
		a("TabGUI");
		a("SimpleUI");
		a("KeyPress");
		a("AntiKB");
		
		//Banned part
		
		b("TargetStats");
		
		
	}
	
	private void b(String b) {
		bannedModules.add(b);
	} 
	
	private void a(String a) {
		allowedModules.add(a);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				for(Module m : Client.modules) {
					
						for(String b : bannedModules) {
						
						if(m.name.equals(b)) {
							
							
							m.toggled = false;
							m.onDisable();
						}
						}
					
					
					
					
					
					
					
				}
			}
		}
	}
	
}
