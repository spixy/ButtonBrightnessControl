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
		
		if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.KITKAT)
		{
			Settings.System.putInt(ctx.getContentResolver(), BUTTON_BRIGHTNESS, level);
		}
		else
		{
			Settings.Secure.putInt(ctx.getContentResolver(), BUTTON_BRIGHTNESS, level);
		}
	}
	
	public static void SetBrightness(Context ctx, boolean value)
	{
		int i_value = value ? 255 : 0;
		
		SetBrightness(ctx, i_value);
	}
	
	public static int GetBrightness(Context ctx) throws SettingNotFoundException
	{
		if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.KITKAT)
		{
			return Settings.System.getInt(ctx.getContentResolver(), BUTTON_BRIGHTNESS);
		}
		else
		{
			return Settings.Secure.getInt(ctx.getContentResolver(), BUTTON_BRIGHTNESS);
		}

	}
	
	public static void SetTimeout(Context ctx, int ms)
	{
		if (ms < 0) ms = 0;		
		
		if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.KITKAT)
		{
			Settings.System.putInt(ctx.getContentResolver(), BUTTON_BACKLIGHT_TIMEOUT, ms);
		}
		else
		{
			Settings.Secure.putInt(ctx.getContentResolver(), BUTTON_BACKLIGHT_TIMEOUT, ms);
		}
	}
	
	public static int GetTimeout(Context ctx) throws SettingNotFoundException
	{		
		if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.KITKAT)
		{
			return Settings.System.getInt(ctx.getContentResolver(), BUTTON_BACKLIGHT_TIMEOUT);
		}
		else
		{
			return Settings.Secure.getInt(ctx.getContentResolver(), BUTTON_BACKLIGHT_TIMEOUT);
		}
	}
	
}
