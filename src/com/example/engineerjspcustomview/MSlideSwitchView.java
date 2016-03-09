package com.example.engineerjspcustomview;

import custom.view.SlideSwitchView;
import custom.view.SlideSwitchView.OnSwitchChangedListener;
import android.app.Activity;
import android.os.Bundle;

public class MSlideSwitchView extends Activity{

	SlideSwitchView mSlideSwitchView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_switch_view);
        mSlideSwitchView = (SlideSwitchView) findViewById(R.id.mSlideSwitchView);
        mSlideSwitchView.setOnChangeListener(mListener);
	}
	
	private OnSwitchChangedListener mListener = new OnSwitchChangedListener() {
		@Override
		public void onSwitchChange(SlideSwitchView switchView, boolean isChecked) {
			
			
		}
	};
}
