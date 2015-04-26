package sk.spixy.bbc;

import android.content.Context;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

public class BrightnessControl
{
	private final static String BUTTON_BRIGHTNESS = "button_brightness";
	private final static String BUTTON_BACKLIGHT_TIMEOUT = "button_backlight_timeout";
	
	public static void SetBrightness(Context ctx, int level)
	{
		if (level < 0) level = 0;
		else if (level > 255) level = 255;
		
		Settings.System.putInt(ctx.getContentResolver(), BUTTON_BRIGHTNESS, level);
	}
	
	public static void SetBrightness(Context ctx, boolean value)
	{
		int i_value = value ? 255 : 0;
		
		SetBrightness(ctx, i_value);
	}
	
	public static int GetBrightness(Context ctx) throws SettingNotFoundException
	{	
		return Settings.System.getInt(ctx.getContentResolver(), BUTTON_BRIGHTNESS);
	}
	
	public static void SetTimeout(Context ctx, int ms)
	{
		if (ms < 0) ms = 0;		
		
		Settings.System.putInt(ctx.getContentResolver(), BUTTON_BACKLIGHT_TIMEOUT, ms);
	}
	
	public static int GetTimeout(Context ctx) throws SettingNotFoundException
	{		
		return Settings.System.getInt(ctx.getContentResolver(), BUTTON_BACKLIGHT_TIMEOUT);
	}
	
}
