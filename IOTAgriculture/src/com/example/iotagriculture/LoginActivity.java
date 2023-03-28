package com.example.iotagriculture;


import android.support.v7.app.ActionBarActivity;
	import java.util.List;
	import java.util.Locale;
	import java.util.RandomAccess;
	import android.os.Bundle;
	import android.app.Activity;
import android.app.ProgressDialog;
	import android.content.ContentProvider;
	import android.content.Intent;
	import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
	import android.view.Menu;
	import android.view.View;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.Toast;
	import android.view.View;
import android.view.View.OnClickListener;
	 
	public class LoginActivity extends ActionBarActivity {
	 
		   TextToSpeech t2;
	       EditText edt;
	       EditText edt1;
	       ProgressDialog pd;
	       Button btn1,btn2;
	       LoginActivity mact;
	       @Override
		public void onCreate(Bundle savedInstanceState) {
	              super.onCreate(savedInstanceState);
	              setContentView(R.layout.login);
	              btn1 = (Button) findViewById(R.id.btnlogin);
	              btn2 = (Button) findViewById(R.id.Button01);
	              edt=(EditText)findViewById(R.id.editText1);
	              edt1=(EditText)findViewById(R.id.editText2);     
	              mact=this;
	              addListenerOnButton();
	              btn2.setOnClickListener(new OnClickListener() {

	  	   			@Override
	  	   			public void onClick(View arg0) {
	  	   				           
	  	               
	  	                Intent a=new Intent(mact,RegisterActivity.class);
	  	               
	  	                startActivity(a);
	  	                
	  	               
	  	                }
	  	   		});
	              
	        		btn1.setOnClickListener(new OnClickListener() {

	    	   			@Override
	    	   			public void onClick(View arg0) {
	    	   				           
	    	                String uname=edt.getText().toString();
	    	                String pass=edt1.getText().toString();
	                    	
	    	                if(uname.equals("admin") && pass.equals("admin"))
	    	                {                
	    	               
	    	                Toast.makeText(mact,"Login Successfully",Toast.LENGTH_LONG).show();
	    	                edt.setText("");
	    	                edt1.setText("");
	    	                Intent a=new Intent(mact,MainActivity.class);
	    	                a.putExtra("uname",uname);
	    	                startActivity(a);
	    	                pd.dismiss();
	    	               
	    	                }
	    	                else
	    	                {
	    	                   Toast.makeText(mact,"Enter Valid username and password",Toast.LENGTH_LONG).show();
	    	                   pd.dismiss();
	    	                }
	    	               
	    	   			}

	    	   		});
	       }
	 
	       @Override
	       public boolean onCreateOptionsMenu(Menu menu) {
	              // Inflate the menu; this adds items to the action bar if it is present.
	             // getMenuInflater().inflate(R.menu.main, menu);
	              return true;
	       }
	       
	       public void addListenerOnButton() {
	    	   
	 
	   		
	   		
	   	}
	      
    
	/* public void onPause()
  {
      if(tsp !=null){
         tsp.stop();
         tsp.shutdown();
      }
      super.onPause();
   }*/
	      
	 
	}

