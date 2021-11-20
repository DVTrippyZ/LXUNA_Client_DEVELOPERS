package render;

import java.awt.Color;

public class LxunaColor {

	public static int getPurple() {
		return 0xff8835db;
	}
	
	public static int getPurpleDark() {
		return 0xff723ae0;
	}
	public static int getGrey() {
		return 0xff333647;
	}
	
	public static int getPink() {
		return 0xffFFC0CB;
	}
	
	
	
	public static int getRainbow(float seconds, float saturation, float brightness) {
		   float hue = (System.currentTimeMillis() * (int)(seconds * 1000)) / (float)(seconds * 100);
		   int color = Color.HSBtoRGB(hue, saturation, brightness);
		   return color;
	}
		                                                  
		public static int getRainbow(float seconds, float saturation, float brightness, long index) {
		   float hue = ((System.currentTimeMillis () + index) * (int)(seconds * 1000)) / (float) (seconds * 1000);
		   int color = Color.HSBtoRGB(hue, saturation, brightness);
		   return color;
				
	
}
		
		
		public static int startRainbow(float seconds) {
			
			float hue = (System.currentTimeMillis() % (int)(seconds * 1000)) / (float)(seconds * 1000);
			int color = Color.HSBtoRGB(hue, 1, 1);
					                                                               
			return color;
		}
}
