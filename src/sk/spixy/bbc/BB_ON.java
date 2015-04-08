package sk.spixy.bbc;

import android.app.Activity;
import android.os.Bundle;

public class BB_ON extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		BrightnessControl.SetBrightness(this, true);
		
		finish();
	}
	
}
