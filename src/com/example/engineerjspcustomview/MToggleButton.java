package com.example.engineerjspcustomview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MToggleButton extends Activity{

	ToggleButton mToggleButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toggle_button);
		mToggleButton = (ToggleButton) findViewById(R.id.mToggleButton);
		mToggleButton.setOnCheckedChangeListener(mListener);
	}
	
	private OnCheckedChangeListener mListener = new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			mToggleButton.setChecked(arg1);
			if(arg1)
				mToggleButton.setBackgroundResource(R.drawable.switchon);
			else
				mToggleButton.setBackgroundResource(R.drawable.switchoff);
		}
	};
}
