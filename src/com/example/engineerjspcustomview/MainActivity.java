package com.example.engineerjspcustomview;

/**
 * engineer.jsp custom view
 * @author engineer.jsp
 * @date 2015.11.04
 * */
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;
public class MainActivity extends Activity {
	
    ListView mListview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WriterLogcat.WriterLogcatMtehod();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.custom_view));
		mListview = (ListView) findViewById(R.id.mlistview);
		mListview.setAdapter(adapter);
		mListview.setOnItemClickListener(mListener);
	}
	
	private OnItemClickListener mListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
			switch (arg2) {
			case 0:
				openCustomView(MToggleButton.class); 
				break; 
			case 1:
				openCustomView(MSlideSwitchView.class);
				break;
			case 2:
				openCustomView(MRoundProgressBar.class);
				break;	
			case 3:
				openCustomView(HandlerActivity.class);
				break;
			}
		} 
	};
	
	private void openCustomView(Class<?> o){
		startActivity(new Intent(this,o));
	}
}
