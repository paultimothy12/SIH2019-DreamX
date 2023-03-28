package com.example.iotagriculture;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.renderscript.Sampler.Value;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HttpConnectSample extends Activity {
    
	protected static final String Length = null;
	private Button getTextButton;
	private ProgressDialog progressDialog;	
	private Bitmap bitmap = null;
	private String text;
	MainActivity tact;
	// Return Intent extra
    public static String CARD_DATA = "msg";

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.httpconnect);

   	
            new Thread(new Runnable() {

                @Override
                public void run() {                 

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                            	
                            	 Bundle b = getIntent().getExtras();
                            	 String cstat=null;
                            	 
                            	 cstat=(String) b.getCharSequence("cstatus"); 
                            	
                			 Log.d("url","http://iotclouddata.com/wilog/210/getstatus1.php?var1="+cstat);
                				
                             
                            }
                        });
                       
                       
                    
                }
            }).start();
            
    }

	
	private void downloadText(String urlStr) {
		progressDialog = ProgressDialog.show(this, "", "Connecting Server...");
		final String url = urlStr;
		
		new Thread () {
			public void run() {
				int BUFFER_SIZE = 2000;
		        InputStream in = null;
		        Message msg = Message.obtain();
		        msg.what=2;
		        try {
		        	in=openHttpConnection(url);
		            
		          InputStreamReader isr = new InputStreamReader(in);
		            int charRead;
		              text = "";
		              char[] inputBuffer = new char[BUFFER_SIZE];

		                  while ((charRead = isr.read(inputBuffer))>0)
		                  {                    
		                      //---convert the chars to a String---
		                      String readString = 
		                          String.copyValueOf(inputBuffer, 0, charRead);                    
		                      text += readString;
		                      inputBuffer = new char[BUFFER_SIZE];
		                  }
		                 Bundle b = new Bundle();
						    b.putString("text", text);
						    msg.setData(b);
		                 in.close();
	                  
				}catch (Exception e) {
	                e.printStackTrace();
	            }
				messageHandler.sendMessage(msg);
			}
		}.start();
          
	}
	
	private InputStream openHttpConnection(String urlStr) {
		InputStream in = null;
		int resCode = -1;
		
		try {
			URL url = new URL(urlStr);
			URLConnection urlConn = url.openConnection();
			
			
			HttpURLConnection httpConn = (HttpURLConnection)urlConn;
			httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect(); 

            resCode = httpConn.getResponseCode();   
            System.out.print(resCode);
            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();                                 
            }         
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	private Handler messageHandler = new Handler() {
		
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				break;
			case 2:
				//TextView text = (TextView) findViewById(R.id.textview01);
				//text.setText(msg.getData().getString("text"));
				//String CurrentString=msg.getData().getString("text");
				//StringTokenizer tokens = new StringTokenizer(CurrentString, ",");
				//String first = tokens.nextToken();// this will contain "Fruit"
				//String second = tokens.nextToken();
				try{
					 // Create the result Intent and include the MAC address
		            Intent intent = new Intent();
		            intent.putExtra(CARD_DATA, msg.getData().getString("text"));

		            // Set result and finish this Activity
		            setResult(Activity.RESULT_OK, intent);
		            finish();
				//tact.cregno=msg.getData().getString("text");
				}catch(NullPointerException e)
				{
					
				}
				//tact.cstatus=second;
				break;
			}
			progressDialog.dismiss();
		}
	};
}