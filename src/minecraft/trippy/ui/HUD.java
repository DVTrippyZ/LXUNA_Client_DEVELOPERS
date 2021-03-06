package trippy.ui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import java.util.Collections;
import java.util.Comparator;

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
import render.LxunaColor;
import render.RenderImage;
import render.SimpleUI;
import trippy.Client;
import trippy.PrefAndInfo;
import trippy.events.listeners.EventRenderGUI;
import trippy.modules.Module;
import trippy.modules.movement.AimAssist;
import trippy.modules.movement.KeyPressLogs;
import trippy.modules.movement.KillAuraGUI;
import trippy.modules.movement.RenderPlayerLxuna;
import trippy.modules.movement.Scaffold;



public class HUD {
	public Minecraft mc = Minecraft.getMinecraft();
	
	private boolean mePREFXLAXUNA = false;
	AimAssist aim = new AimAssist();
	
	public static String errMessage = null;
	
	
	
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
		LxunaOutput p = new LxunaOutput();
		
		FontRenderer fr = mc.fontRendererObj;
		
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		//BG SQ
		//Gui.drawRect(sr.getScaledWidth() - 50 - 4, -3, sr.getScaledWidth(), 40 + 50, 0x10000000);
	//Design SQ
		//Gui.drawRect(sr.getScaledWidth()  - 54, -50, sr.getScaledWidth() - 48, 40 + 50, 0xff7700ff);
		
	Collections.sort(Client.modules, new ModuleComparator());
	int count = 0;
	fr.drawString("LXUNA", 5, 5, 0x10ffff00);
	int hLXUNA = 27;
	int wLXUNA = hLXUNA + 20;
	fr.drawString("COLOR FOR IMAGE?", 500, 500, 0xffffff);
	RenderImage.render("img/logoNoBG.png", 298, 229, 1, 1, 40, wLXUNA / 2, wLXUNA, hLXUNA);
	
	int hLXUNA_ = 30;
	int wLXUNA_ = hLXUNA + 105;
	
	RenderImage.renderSingle("img/title.png", 0, 0, 130, wLXUNA_ / 4, wLXUNA_ - 10, hLXUNA_);
	fr.drawString(PrefAndInfo.LXUNAVersion, 40, 5, 0x10ffffff);
	int guiPositionLXUNA = sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 68;
	int dashGuiPositionLXUNA = sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 75;
	
	//Modules
	
	
	Gui.drawRect(0, 280 - 47, 500, 280, 0x50000000);
	
	
	
	
	
	
	
	if(RenderPlayerLxuna.renderPlayerModelLxuna) {
		GuiInventory.drawEntityOnScreen(170, 55, 25, -20, -10, mc.thePlayer);
	}
	
	
	if(Scaffold.scaffolding) {
		int scaffoldDiv = 3;
		
		if((mc.thePlayer.getHeldItem() != null)) {
		Gui.drawRect((sr.getScaledWidth() - 29 - 250) / scaffoldDiv - 5, sr.getScaledHeight() - 4 - 25 - 100, (sr.getScaledWidth() - 4 - 210 + mc.thePlayer.getHeldItem().getDisplayName().length()) / scaffoldDiv + 50, sr.getScaledHeight() - 4 - 79, 0x80333647);
		fr.drawString(Integer.toString(mc.thePlayer.getHeldItem().stackSize), 208 / scaffoldDiv, 153, -1);
		fr.drawString(mc.thePlayer.getHeldItem().getDisplayName(), 208 / scaffoldDiv, 133, LxunaColor.startRainbow(5.8f));
		
		
		
		}
	}
	
	
	
	if(KillAuraGUI.isAttackingTarget) {
		int div = 4;
		GuiInventory.drawEntityOnScreen(((90 * 3 + 90) / div) + 5, 145, 15, -20, -10, KillAuraGUI.fixTarget);
		
		Gui.drawRect((sr.getScaledWidth() - 29 - 109) / div, sr.getScaledHeight() - 4 - 25 - 109, ((sr.getScaledWidth() - 4 - 29) / div + 50) + KillAuraGUI.targetName_.length() * 3, sr.getScaledHeight() - 4 - 79 - 20, 0x80333647);
		fr.drawString(Integer.toString(KillAuraGUI.targetHealth), ((90 * 3 + 100) / div) + 15, 130, 0xffffffff);
	
		fr.drawString(KillAuraGUI.targetName_, ((90 * 3 + 100) / div) + 10 + 5 + 5 + 5 + 5 + 5, 120, LxunaColor.startRainbow(5.8f));
		
		if(KillAuraGUI.targetWin_.equals("Winning!")) {
			fr.drawString(EnumChatFormatting.DARK_GREEN + KillAuraGUI.targetWin_, ((90 * 3 + 100) / div) + 10 + 5 + 5 + 5, 140, -1);
		} else {
			fr.drawString(EnumChatFormatting.RED + KillAuraGUI.targetWin_, ((90 * 3 + 100) / div) + 10 + 5 + 5 + 5, 140, -1);
		}
		
		
		
		if(KillAuraGUI.distToTargetLX <= 5) {
			fr.drawString(Integer.toString(KillAuraGUI.distToTargetLX), ((90 * 3 + 100) / div) + 15, 120, 0xff26e0a5);
			
		} 
		
		fr.drawString(Integer.toString(KillAuraGUI.armorOfTARGETLX), ((90 * 3 + 100) / div) + 10 + 5, 140, 0x90723ae0);
		
		
	}
	
	
	if(KeyPressLogs.keyPressLogsLxunaOn) {
		int wAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindForward.getKeyCode()) ? 170 : 50);
		int aAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindLeft.getKeyCode()) ? 170 : 50);
		int sAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindBack.getKeyCode()) ? 170 : 50);
		int dAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindRight.getKeyCode()) ? 170 : 50);
		
	/*
	 * 	w a s d
	 */
		int top = 24;
		int left = 0;
		int right = 0;
		int bottom = -12;
		
		int top_ = -1;
		int left_ = 0;
		int right_ = 0;
		int bottom_ = 0;
		
		int top__ = 0;
		int left__ = 0;
		int right__ = 0;
		int bottom__ = 0;
		
		int top____ = 0;
		int left____ = -20;
		int right____ = 15;
		int bottom____ = 0;
		
		
		
		Gui.drawRect(sr.getScaledWidth() - 230 - 230 + 8 + left, sr.getScaledHeight() - 4 - 25 - 29 - 9 + top, sr.getScaledWidth() - 4 - 230 - 200 + right, sr.getScaledHeight() - 4 - 29 - 15 + bottom, new Color(119, 52, 235, wAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 230 - 230 + 8 + left_, sr.getScaledHeight() - 4 - 25 - 29 + 35 + top_, sr.getScaledWidth() - 4 - 230 - 200 + right_, sr.getScaledHeight() - 4 - 29 - 8 + bottom_, new Color(119, 52, 235, sAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 230 - 230 - 10 + 8 - 10 + left__, sr.getScaledHeight() - 4 - 25 + 8 - 20 + top__, sr.getScaledWidth() - 4 - 230 - 220 + right__, sr.getScaledHeight() - 4 - 20 + bottom__, new Color(119, 52, 235, aAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 230 - 230 - 10 + 8 - 10 + 60 + left____, sr.getScaledHeight() - 4 - 25 + 8 - 20 + top____, sr.getScaledWidth() - 4 - 230 - 220 + 25 + right____, sr.getScaledHeight() - 4 - 20 + bottom____, new Color(119, 52, 235, dAlpha).getRGB());
		//Gui.drawRect(sr.getScaledWidth() - 230 - 230 + 8, sr.getScaledHeight() - 4 - 25 + 8, sr.getScaledWidth() - 4 - 230, sr.getScaledHeight() - 4, new Color(119, 52, 235, sAlpha).getRGB());
		//Gui.drawRect(sr.getScaledWidth() - 230 - 230 + 8, sr.getScaledHeight() - 4 - 25 + 8, sr.getScaledWidth() - 4, sr.getScaledHeight() - 4, new Color(119, 52, 235, dAlpha).getRGB());
		
		
	}
	
	
	//Modules end
	
	
	if(aim.shouldDrawAIMLXUNA) {
		fr.drawString(EnumChatFormatting.DARK_RED + "" + EnumChatFormatting.BOLD + "+", sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 186, 117, 0xffffff00);
	}
	
	if(!SimpleUI.simple) {
		fr.drawString("[" +  "FPS" + "]: " + EnumChatFormatting.BOLD + mc.debugFPS, 5, 235, 0xffffffff);
		fr.drawString("Health" + ": " + EnumChatFormatting.BOLD + Float.toString(mc.thePlayer.getHealth()).substring(0, Float.toString(mc.thePlayer.getHealth()).length() - 2), 80, 235, 0xffffffff);
	}
	
	
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
					
					//Tag//Border Of text
					//Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -10, count*(fr.FONT_HEIGHT + 5), sr.getScaledWidth() - fr.getStringWidth(m.name) -8, 6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), 0xff723ae0);
					//Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -8, 0 + count*(fr.FONT_HEIGHT + 5), sr.getScaledWidth(),fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5) - 7, LxunaColor.getPurpleDark());
					
					
					
					
					//Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -10,          0 + count*(fr.FONT_HEIGHT + 5) + 17,         sr.getScaledWidth(),         6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), 0xff723ae0);
					//Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) -8, 0 + count*(fr.FONT_HEIGHT +10), sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), borderCOL);	
				
				//fr.drawString(EnumChatFormatting.OBFUSCATED + "- ", dashGuiPositionLXUNA, 5 + count*(fr.FONT_HEIGHT + 5), 0xff680094);
				//fr.drawString(EnumChatFormatting.BOLD + m.name, sr.getScaledWidth() - fr.getStringWidth("LXUNA") - 10 + (m.name.length() * 16) , 5 + count*(fr.FONT_HEIGHT + 5), 0xffffffff);
				fr.drawString(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) -4 , 5 + count*(fr.FONT_HEIGHT + 5), LxunaColor.startRainbow(5));
				
				
				
			
			} 
			
			
			
		} 
		
		
		
		if(!m.name.equals("[SemiColon] Rude") && !m.name.equals("List")) {
		count++;
			}
		
		
		Client.onEvent(new EventRenderGUI());
		}
		
		//15 FLY
		
		
		
		//LXUNAmodulesCOUNTERPRIVATE(count);
	//Custom Err messages
	if(errMessage != null) {
		p.renderOutput(errMessage);
	}
	
	}

	
	
	
	
	private void LXUNAmodulesCOUNTERPRIVATE(int inputNumber) {
		System.out.println(inputNumber);
	}
	
	
	
}
