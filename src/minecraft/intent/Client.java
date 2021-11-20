package intent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import intent.events.Event;
import intent.events.listeners.EventKey;
import intent.modules.Module;

import intent.modules.Module.Category;

import intent.modules.movement.*;
import intent.ui.HUD;
import render.Bright;
import render.ChestStealer;
import render.SimpleUI;
import render.TabGUI;
//import render.Xray;
//import render.XrayUtils;

public class Client {

	
	public static String name = "LXUNA Client";
	public static String version = "1";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();
	
	public static void startup() {
		System.out.println("Starting " + name + " v" + version);
		Display.setTitle(name + " v" + version);
		//XrayUtils.initXRayBlocks();
		modules.add(new Fly());
		modules.add(new FastWalk());
		modules.add(new Bright());
		modules.add(new Fall());
		modules.add(new HillRun());
		modules.add(new KillAura());
		modules.add(new Elytra());
		modules.add(new SpeedPlace());
		modules.add(new Reach());
		modules.add(new HighJump());
		modules.add(new Bhop());
		modules.add(new JetPack());
		modules.add(new Tarantula());
		modules.add(new SpeedHack());
		modules.add(new Rude());
		modules.add(new ListS());
		modules.add(new Dolphin());
		modules.add(new AirJump());
		modules.add(new AntiKB());
		modules.add(new Criticals());
		modules.add(new CriticalAura());
		//modules.add(new EnabledAll());
		modules.add(new AimAssist());
		modules.add(new TabGUI());
		modules.add(new HypixelFly());
		modules.add(new AntiBot());
		modules.add(new AntiEntity());
		modules.add(new RenderPlayerLxuna());
		modules.add(new KeyPressLogs());
		modules.add(new AutoArmor());
		
		modules.add(new KillAuraGUI());
		modules.add(new Scaffold());
		modules.add(new NameChanger());
		modules.add(new SimpleUI());
		modules.add(new ChestStealer());
		
		//Adding the script you made
		
		
		//this adds the new file you made
		//To get rid of file remove the modules.add statement
	
		
	}
	
	
	public static CopyOnWriteArrayList<Module> getModules(){
		return modules;
	}
	
	
	public static void onEvent(Event e) {
		for(Module m : modules) {
			if(!m.toggled) {
				continue;
				
			}
			m.onEvent(e);
		}
	}
	
	public static void keyPress(int key) {
		
		Client.onEvent(new EventKey(key));
		for(Module m : modules) {
			if(m.getKey() == key) {
				m.toggle();
			}
		}
	}
	
	public static List<Module> getModulesByCategory(Category c){
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Client.modules) {
			if(m.category == c) {
				modules.add(m);
				
			}
			
			
		}
		return modules;
		
	}
}
