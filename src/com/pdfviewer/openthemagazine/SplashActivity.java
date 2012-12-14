package com.pdfviewer.openthemagazine;

import com.artifex.mupdf.R;
import com.artifex.mupdf.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread start_splash = new Thread(){
        	public void run(){
        		try{
        			sleep(4000);
        			finish();
        		}
        		catch(InterruptedException e){
        			e.printStackTrace();
        		}
        		finally{
        			//Intent start_main_activity = new Intent("cx.hell.android.pdfviewpro.CHOOSEFILEACTIVITY");
        			//Intent start_main_activity = new Intent("android.intent.action.FRONTSCREEN");
        			Intent start_main_activity = new Intent("android.intent.action.FRONTSCREEN");
        			
        			startActivity(start_main_activity);
        		}
        	}
        };
        start_splash.start();
    }
}
