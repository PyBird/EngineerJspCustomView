package com.example.engineerjspcustomview;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.os.Environment;
import android.util.Log;

public class WriterLogcat {
	static final String TAG = "WriterLogcat";
	public static void WriterLogcatMtehod(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				 try  
				    { 
					 // pid=`ps | grep logcat | awk '{print $2}'` && kill $pid
				    	String shell = "logcat";
				        Process process = Runtime.getRuntime().exec(shell);  
				        InputStream inputStream = process.getInputStream();  
				          
				        boolean sdCardExist = Environment.getExternalStorageState().equals(  
				                android.os.Environment.MEDIA_MOUNTED);  
				        File dir = null;  
				        Log.v(TAG, ""+sdCardExist);
				        if (sdCardExist)  
				        {  
				            dir = new File(Environment.getExternalStorageDirectory().toString()  
				                    + File.separator + "logcatwyx.txt");  
				            if (!dir.exists())  
				            {  
				                dir.createNewFile();  
				            }  
				        }  
				        byte[] buffer = new byte[1024];  
				        int bytesLeft = 5 * 1024 * 1024; // Or whatever  
				        try  
				        {  
				            FileOutputStream fos = new FileOutputStream(dir);  
				            try  
				            {  
				                while (bytesLeft > 0)  
				                {  
				                    int read = inputStream.read(buffer, 0, Math.min(bytesLeft,  
				                            buffer.length));  
				                    if (read == -1)  
				                    {  
				                        throw new EOFException("Unexpected end of data");  
				                    }  
				                    fos.write(buffer, 0, read);  
				                    bytesLeft -= read;  
				                }  
				            } finally  
				            {  
				                fos.close(); // Or use Guava's  
				                             // Closeables.closeQuietly,  
				                // or try-with-resources in Java 7  
				            }  
				        } finally  
				        {  
				            inputStream.close();  
				        }  
//				        String logcat = convertStreamToString(inputStream);  
//				        outputFile2SdTest(logcat, "logwyx.txt");  
//				        Log.v(TAG, "LOGCAT = ok" );  
				    } catch (IOException e)  
				    {  
				        e.printStackTrace();  
				    }  
			}
		}).start();
}
}