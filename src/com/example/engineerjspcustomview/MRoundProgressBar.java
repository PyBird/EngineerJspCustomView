package com.example.engineerjspcustomview;

import java.util.Timer;
import java.util.TimerTask;

import custom.view.RoundProgressBar;
import android.app.Activity;
import android.os.Bundle;

public class MRoundProgressBar extends Activity{

	private RoundProgressBar mRoundProgressBar;
	private int progress = 0;
	private Timer mTimer;
	private TimerTask mTimerTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roundprogress_bar);
		mRoundProgressBar = (RoundProgressBar) findViewById(R.id.roundProgressBar);
		mTimer = new Timer();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mRoundProgressBar.setMax(100);
		updateProgressBar();
	}

	private void updateProgressBar() {
		if (mTimerTask != null) {
			mTimerTask.cancel();
		}
		mTimerTask = new TimerTask() {
			@Override
			public void run() {
				mRoundProgressBar.setProgress(progress++);
				if (progress == 50) {
					mTimerTask.cancel();
					progress = 0;
					return;
				}
			}
		};
		mTimer.scheduleAtFixedRate(mTimerTask, 0, 25);
	}
}
