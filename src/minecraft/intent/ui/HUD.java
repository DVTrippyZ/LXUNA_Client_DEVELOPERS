package intent.ui;

import intent.Client;
import intent.PrefAndInfo;
import intent.events.listeners.EventRenderGUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import java.util.Collections;
import java.util.Comparator;

import intent.modules.Module;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.EnumChatFormatting;
import intent.modules.movement.AimAssist;
import intent.modules.movement.KeyPressLogs;
import intent.modules.movement.KillAuraGUI;
import intent.modules.movement.RenderPlayerLxuna;
import intent.modules.movement.Scaffold;



public class HUD {
	public Minecraft mc = Minecraft.getMinecraft();
	
	private boolean mePREFXLAXUNA = false;
	AimAssist aim = new AimAssist();
	
	
	
	
	public static class ModuleComparator implements Comparator<Module> {
		@Override
		public int compare(Module arg0, Module arg1) {
			
			if(Minecraft.getMinecraft().fontRendererObj.getStringWidth(arg0.name) > Minecraft.getMinecraft().fontRendererObj.getStringWidth(arg1.name)) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRendererObj.getStringWidth(arg0.name) < Minecraft.getMinecraft().fontRendererObj.getStringWidth(arg1.name)) {
				return 1;
			}
			return 0;
		}
	}
	
	public void draw() {
		FontRenderer fr = mc.fontRendererObj;
		
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		//BG SQ
		//Gui.drawRect(sr.getScaledWidth() - 50 - 4, -3, sr.getScaledWidth(), 40 + 50, 0x10000000);
	//Design SQ
		//Gui.drawRect(sr.getScaledWidth()  - 54, -50, sr.getScaledWidth() - 48, 40 + 50, 0xff7700ff);
		
	Collections.sort(Client.modules, new ModuleComparator());
	int count = 0;
	fr.drawString("LXUNA", 5, 5, 0xffffffff);
	fr.drawString(PrefAndInfo.LXUNAVersion, 40, 5, 0xffffffff);
	int guiPositionLXUNA = sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 68;
	int dashGuiPositionLXUNA = sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 75;
	
	//Modules
	
	
	
	
	
	
	
	
	
	
	if(RenderPlayerLxuna.renderPlayerModelLxuna) {
		GuiInventory.drawEntityOnScreen(170, 55, 25, -20, -10, mc.thePlayer);
	}
	
	
	if(Scaffold.scaffolding) {
		
		if((mc.thePlayer.getHeldItem() != null)) {
		Gui.drawRect(sr.getScaledWidth() - 29 - 250, sr.getScaledHeight() - 4 - 25 - 100, sr.getScaledWidth() - 4 - 210, sr.getScaledHeight() - 4 - 79, 0x80333647);
		fr.drawString(Integer.toString(mc.thePlayer.getHeldItem().stackSize), 208, 153, -1);
		fr.drawString(mc.thePlayer.getHeldItem().getDisplayName(), 208, 133, -1);
		
		}
	}
	
	
	
	if(KillAuraGUI.isAttackingTarget) {
		GuiInventory.drawEntityOnScreen(90 * 3 + 90, 160, 15, -20, -10, KillAuraGUI.fixTarget);
		
		Gui.drawRect(sr.getScaledWidth() - 29 - 109, sr.getScaledHeight() - 4 - 25 - 109, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4 - 79, 0x80333647);
		fr.drawString("Health: " + Integer.toString(KillAuraGUI.targetHealth), 90 * 3 + 100, 150, 0xffffffff);
		Gui.drawRect(sr.getScaledWidth() - 29 - 109, sr.getScaledHeight() - 4 - 25 - 60, sr.getScaledWidth() - 40 + ((KillAuraGUI.targetHealth - 50)), sr.getScaledHeight() - 4 - 79, 0x90723ae0);
		
		
		if(KillAuraGUI.distToTargetLX <= 5) {
			fr.drawString("Distance: " + Integer.toString(KillAuraGUI.distToTargetLX), 90 * 3 + 100, 140, 0xff26e0a5);
			
		} else if(KillAuraGUI.distToTargetLX > 5) {
			
			fr.drawString("Distance: " + Integer.toString(KillAuraGUI.distToTargetLX), 90 * 3 + 100, 140, 0xffe02626);
		}
		
		fr.drawString("Armor: "+Integer.toString(KillAuraGUI.armorOfTARGETLX), 90 * 3 + 100, 130, 0x90723ae0);
		
		
	}
	
	
	if(KeyPressLogs.keyPressLogsLxunaOn) {
		int wAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindForward.getKeyCode()) ? 170 : 50);
		int aAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindLeft.getKeyCode()) ? 170 : 50);
		int sAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindBack.getKeyCode()) ? 170 : 50);
		int dAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindRight.getKeyCode()) ? 170 : 50);
		
		Gui.drawRect(sr.getScaledWidth() - 29 - 29, sr.getScaledHeight() - 4 - 25 - 29, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4 - 29, new Color(119, 52, 235, wAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 29 - 29 - 29, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4 - 29 - 29, sr.getScaledHeight() - 4, new Color(119, 52, 235, aAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 29 - 29, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4, new Color(119, 52, 235, sAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 29, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4, sr.getScaledHeight() - 4, new Color(119, 52, 235, dAlpha).getRGB());
		
		fr.drawString("W", sr.getScaledWidth() - 48, sr.getScaledHeight() - 49, 0xffffffff);
		fr.drawString("A", sr.getScaledWidth() - 77, sr.getScaledHeight() - 20, 0xffffffff);
		fr.drawString("S", sr.getScaledWidth() - 48, sr.getScaledHeight() - 20, 0xffffffff);
		fr.drawString("D", sr.getScaledWidth() - 19, sr.getScaledHeight() - 20, 0xffffffff);
	}
	
	
	//Modules end
	
	
	if(aim.shouldDrawAIMLXUNA) {
		fr.drawString(EnumChatFormatting.DARK_RED + "" + EnumChatFormatting.BOLD + "+", sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 186, 117, 0xffffff00);
	}
	
	fr.drawString("[" +  "FPS" + "]: " + EnumChatFormatting.BOLD + mc.debugFPS, 5, 235, 0xffffffff);
	fr.drawString(EnumChatFormatting.RED + "[" +  "Health" + "]: " + EnumChatFormatting.BOLD + Float.toString(mc.thePlayer.getHealth()).substring(0, Float.toString(mc.thePlayer.getHealth()).length() - 2), 220, 5, 0xffffffff);
	
	for(Module m : Client.modules) {
		if(!m.toggled) {
			continue;
		}
	
		//toggled SQ
		 
//	
//		fr.drawString("_", sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 25, 5 + count*(fr.FONT_HEIGHT + 5), 0xffa600ff);
//		fr.drawString(" |", sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 25, 5 + count*(fr.FONT_HEIGHT + 5), 0xffa600ff);
//		fr.drawString("_", sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 25, -2 + count*(fr.FONT_HEIGHT + 5), 0xffa600ff);
//		fr.drawString("| ", sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 25, 5 + count*(fr.FONT_HEIGHT + 5), 0xffa600ff);
		
		
		
		
		if(!mePREFXLAXUNA) {
			
			
			if(!m.name.equals("[SemiColon] Rude") && !m.name.equals("List")) {
				
				
				
					
					
					int borderCOL = 0xffffffff;
					// good rect Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -8, 0 + count*(fr.FONT_HEIGHT + 5), sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), 0x80723ae0);
					Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -10, count*(fr.FONT_HEIGHT + 5), sr.getScaledWidth() - fr.getStringWidth(m.name) -8, 6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), 0xff723ae0);
					Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -8, 0 + count*(fr.FONT_HEIGHT + 5), sr.getScaledWidth(),fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5) - 7, 0xff723ae0);
					//Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -10,          0 + count*(fr.FONT_HEIGHT + 5) + 17,         sr.getScaledWidth(),         6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), 0xff723ae0);
					//Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -8, 0 + count*(fr.FONT_HEIGHT +10), sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), borderCOL);	
				
				//fr.drawString(EnumChatFormatting.OBFUSCATED + "- ", dashGuiPositionLXUNA, 5 + count*(fr.FONT_HEIGHT + 5), 0xff680094);
				//fr.drawString(EnumChatFormatting.BOLD + m.name, sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 10 + (m.name.length() * 16) , 5 + count*(fr.FONT_HEIGHT + 5), 0xffffffff);
				fr.drawString(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) -4 , 5 + count*(fr.FONT_HEIGHT + 5), -1);
				
				
				
			
			} 
			
			
			
			
		} 
		
		if(!m.name.equals("[SemiColon] Rude") && !m.name.equals("List")) {
		count++;
			}
		
		
		Client.onEvent(new EventRenderGUI());
		}
		
		//15 FLY
		
		
		
		//LXUNAmodulesCOUNTERPRIVATE(count);
	}

	
	
	
	
	private void LXUNAmodulesCOUNTERPRIVATE(int inputNumber) {
		System.out.println(inputNumber);
	}
	
	
	
}
