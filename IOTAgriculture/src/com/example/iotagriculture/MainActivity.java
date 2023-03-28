package com.example.iotagriculture;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	 MainActivity tact;
	 public boolean exitflag= false;
	 private static final int REQUEST_CONNECT_DEVICE = 1;
	
	 public String alertmsg=null;
	 String datas = null;
	 SharedPreferences sharedpreferences;
	 public static final String mypreference = "mypref";
	 public static final String field1 = "field1key";
	 public static final String field2 = "field2key";
	 public static final String field3 = "field3key";
	 public static final String field4 = "field4key";
	 String value;
	 
	 ProgressDialog pd;
	 Button b1;
	 EditText et1,et2,et3,et4;
	 TextView search,tv1,tv2,tv3,tv4;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tact=this;
		//addListenerOnButton();
		et1=(EditText) findViewById(R.id.entry1);
		et2=(EditText) findViewById(R.id.entry2);
		et3=(EditText) findViewById(R.id.entry3);
		et4=(EditText) findViewById(R.id.entry4);
		tv1=(TextView) findViewById(R.id.tv1);
		tv2=(TextView) findViewById(R.id.tv2);
		tv3=(TextView) findViewById(R.id.tv3);
		tv4=(TextView) findViewById(R.id.tv4);
		
		sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
		
        if (sharedpreferences.contains(field1)) {
            tv1.setText(sharedpreferences.getString(field1, ""));
        }
        if (sharedpreferences.contains(field2)) {
            tv2.setText(sharedpreferences.getString(field2, ""));
        }
        if (sharedpreferences.contains(field3)) {
            tv3.setText(sharedpreferences.getString(field3, ""));
        }
        if (sharedpreferences.contains(field4)) {
            tv4.setText(sharedpreferences.getString(field4, ""));
        }
    
		
		

	}
	
	 private void receivedata() {
	 		
	 		//HttpConnectSample httpConnectSample = new HttpConnectSample();
	 		
	 		// TODO Auto-generated method stub
	 		Intent serverIntent = new Intent(MainActivity.this, HttpConnectSample.class);
	 		Bundle b= new Bundle();
			//	 b.putString("name", name.getText().toString());
	 		cstatus="*#";
				b.putString("cstatus", cstatus);
				
				serverIntent.putExtras(b);
	 		startActivityForResult(serverIntent);
	
	 	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
	  	 String address = data.getExtras();
    	 //Toast.makeText(getApplicationContext(), address, Toast.LENGTH_SHORT).show();
    	 
    	 if(address != null && !address.isEmpty())
    	 {
    		 //Toast.makeText(getApplicationContext(), "Inside", Toast.LENGTH_SHORT).show();
        	  
    		 String[] datas = address.split(",");
    		 
    		 String v1=datas[0];
    		 //String v2=datas[1];
    		 int e1=Integer.parseInt(v1);
    		 if(e1<350)
    		 {
    			 et1.setText(v1);
    			
    		 }
    		 if(e1>400)
    		 {
    			 et1.setText(v1);
    			
    		 }
    		 
    		 et2.setText(datas[1]);
  
    	 }
		}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void onPause()
	  {
	    // exitflag=true;
	      super.onPause();
	   }
	
}


