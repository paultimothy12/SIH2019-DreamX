package com.example.iotagriculture;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.view.View.OnClickListener;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

public class RegisterActivity extends ActionBarActivity{
    
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String field1 = "field1key";
    public static final String field2 = "field2key";
    public static final String field3 = "field3key";
    public static final String field4 = "field4key";
    
    int flagA=0;
    int flagB=0; 
    int flagC=0;
    public boolean exitflag= false;
    EditText et1,et2,et3,et4,et5;   
    
    Button submit1;
   
  
    int tstatus=0;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
	//	tact=this;
		sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
		
		submit1 = (Button) findViewById(R.id.button);
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		et3 = (EditText) findViewById(R.id.editText3);
		et4 = (EditText) findViewById(R.id.editText4);
		
		 submit1.setOnClickListener(new View.OnClickListener() {
	           @Override
	           public void onClick(View v) {
	        	savedata();
       			Intent a=new Intent(RegisterActivity.this,LoginActivity.class);	                
	            startActivity(a);	
	    
	           }
	        });
        
   	
	}
	
	public void savedata()
	{
		 String e1 = et1.getText().toString();
         String e2 = et2.getText().toString();
         String e3 = et3.getText().toString();
         String e4 = et4.getText().toString();
        
         editor.putString(field1, e1);
         editor.putString(field2, e2);
         editor.putString(field3, e3);
         editor.putString(field4, e4);
         
	}
	
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
    /**
     * Handle the results from the voice recognition activity.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {     
    }

	
   
}