package sk.spixy.bbc;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity
{
	private TextView tv2;
	private TextView tv3;
	
	private void Load()
	{
		try
		{
			boolean value = ( BrightnessControl.GetBrightness(this) == 0) ? false : true;
			
			Switch sw1 = (Switch) findViewById(R.id.switch1);
			sw1.setChecked(value);
		}
		catch (Exception e)
		{
			Log.e("Load Screen Brigtness", "Cannot load data");
		}
		
		try
		{
			int ms = BrightnessControl.GetTimeout(this);
			int progress = Utils.GetProgress(ms);
			
			SeekBar bar = (SeekBar) findViewById(R.id.seekBar1);
			bar.setProgress(progress);
			
			if (ms == 0)
			{
				tv2.setText(R.string.infinity);
				tv3.setText("");
			}
			else if (ms < 3000)
			{
				tv3.setText(ms + " ");
			}
    		else
    		{
    			tv2.setText(R.string.s);
    			tv3.setText(ms/1000 + " ");
    		}
		}
		catch (Exception e)
		{
			Log.e("Load Screen Timeout", "Cannot load data");
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv2 = (TextView) findViewById(R.id.textView2);
		tv3 = (TextView) findViewById(R.id.textView3);
		
		Load();
		
		final Context ctx = this;
		
		SeekBar bar = (SeekBar) findViewById(R.id.seekBar1);
		
		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int ms = 0;
			
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				ms = Utils.GetMS(progress);
        			
        		if (ms == 0)
        		{
        			tv2.setText(R.string.infinity);
        			tv3.setText("");
        		}
        		else if (ms < 3000)
        		{
        			tv2.setText(R.string.ms);
        			tv3.setText(ms + " ");
        		}
        		else
        		{
        			tv2.setText(R.string.s);
        			tv3.setText(ms/1000 + " ");
        		}
			}

			public void onStartTrackingTouch(SeekBar seekBar) {}

			public void onStopTrackingTouch(SeekBar seekBar)
			{
        		BrightnessControl.SetTimeout(ctx, ms);
			}
		});
	}
	
	public void onBrightnessToggleClicked(View view)
	{
		boolean value = ((Switch) view).isChecked();

		BrightnessControl.SetBrightness(this, value);
	}
	
	public void onLauncherToggleClicked(View view)
	{
		PackageManager p = getPackageManager();
		p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
	}
}
