package com.example.engineerjspcustomview;

import custom.thread.CustomThread;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HandlerActivity extends Activity {

	private TextView handler_text, thread_text;
	private Button start_working;
	private CustomThread mThread;
	private int id = 0;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:// show handler status
				switch (msg.arg1) {

				case 0:
					handler_text.setText("Handler require Thread calc :1+1");
					HandRequireThreadCalc(1, 1);
					break;

				case 1:
					handler_text.setText("Handler require Thread calc :1+2");
					HandRequireThreadCalc(1, 2);
					break;

				case 2:
					handler_text.setText("Handler require Thread calc :1+3");
					HandRequireThreadCalc(1, 3);
					break;

				case 3:
					handler_text.setText("Handler require Thread calc :1+4");
					HandRequireThreadCalc(1, 4);
					break;
				}
				break;

			case 1:// show thread status
				thread_text.setText((String) msg.obj);
				isLossFoucse = true;
				setBtnLossFoucse();
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handler_activity);
		initView();
		mThread = new CustomThread(mHandler);
		mThread.start();
	}

	private boolean isLossFoucse = true;

	private void initView() {
		handler_text = (TextView) findViewById(R.id.show_handler_status);
		thread_text = (TextView) findViewById(R.id.show_thread_status);
		start_working = (Button) findViewById(R.id.start_working);
		start_working.setOnClickListener(mListener);
	}

	private void setBtnLossFoucse() {
		Log.v("Engineer-Jsp", "setBtnLossFoucse() Enabled:" + isLossFoucse);
		start_working.setEnabled(isLossFoucse);
	}

	private void HandRequireThreadCalc(int j, int k) {
		Message msg = mThread.thread_handler.obtainMessage();
		msg.what = 0;
		msg.arg1 = j;
		msg.arg2 = k;
		mThread.thread_handler.sendMessage(msg);
	}

	private OnClickListener mListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {

			switch (id) {
			case 0:
				mHandler.obtainMessage(0, 0, 0).sendToTarget();
				id++;
				isLossFoucse = false;
				setBtnLossFoucse();
				break;
			case 1:
				mHandler.obtainMessage(0, 1, 0).sendToTarget();
				id++;
				isLossFoucse = false;
				setBtnLossFoucse();
				break;
			case 2:
				mHandler.obtainMessage(0, 2, 0).sendToTarget();
				id++;
				isLossFoucse = false;
				setBtnLossFoucse();
				break;
			case 3:
				mHandler.obtainMessage(0, 3, 0).sendToTarget();
				id++;
				if (id >= 3) {
					id = 0;
				}
				isLossFoucse = false;
				setBtnLossFoucse();
				break;
			}
		}
	};
}
