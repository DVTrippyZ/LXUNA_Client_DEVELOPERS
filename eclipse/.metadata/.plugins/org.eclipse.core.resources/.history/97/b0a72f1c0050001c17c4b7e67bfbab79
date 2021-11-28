package intent.modules;

import java.util.ArrayList;

import java.util.List;

import java.util.Arrays;
import intent.events.Event;
import intent.settings.Setting;
import net.minecraft.client.Minecraft;

public class Module {

	public String name;
	public boolean toggled;
	public int keyCode;
	public Category category;
	
	public Minecraft mc = Minecraft.getMinecraft();
	public boolean expanded;
	public List<Setting> settings = new ArrayList<Setting>();
	public int index;
	
	public String safe;
	
	
	
	//Y(Yes), N(No), U(Unknown), O(other)
	
	public Module(String name, int key, Category c, String safe) {
		this.name = name;
		this.keyCode = key;
		this.category = c;
		this.safe = safe;
		
	}
	
	
	public void addSettings(Setting... settings) {
	    this.settings.addAll(Arrays.asList(settings));
	}
	
	public boolean isEnabled() {
		return toggled;
		
	}
	
	public int getKey() {
		return keyCode;
	}
	
	public void onEvent(Event e) {
		
	}
	
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
			
		} else {
			onDisable();
		}
	}
	
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public enum Category {
		COMBAT("Combat"),
		MOVEMENT("Movement"),
		PLAYER("Player"),
		RENDER("Render"),
		CHAT("Chat"),
		BYPASS("Bypass");
		
		//Category that the super uses
		
		
		public String name;
		
		Category(String name){
			this.name = name;
		}
	}
}
