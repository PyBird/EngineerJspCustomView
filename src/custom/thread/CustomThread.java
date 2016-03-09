package custom.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class CustomThread extends Thread {

	public Handler thread_handler;
	private Handler handler;

	public CustomThread(Handler h) {
		this.handler = h;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();

		thread_handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				switch (msg.what) {
				case 0:

					int j = msg.arg1;
					int k = msg.arg2;
					Calc(j, k);

					break;

				case 1:
					String sendStr = (String) msg.obj;
					if (handler != null) {
						Message msg1 = handler.obtainMessage();
						msg1.what = 1;
						msg1.obj = sendStr;
						handler.sendMessage(msg1);
					}
					break;
				}
			}
		};

		Looper.loop();
	}

	private void Calc(int j, int k) {

		int result = j + k;
		String results = "Thread Calc from Handler test result:" + j + "+" + k
				+ "=" + result;

		Log.v("Engineer-Jsp", results);

		Message msg = thread_handler.obtainMessage();
		msg.what = 1;
		msg.obj = results;
		thread_handler.sendMessage(msg);
	}
}
