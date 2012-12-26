package com.pdfviewer.openthemagazine;

import java.io.File;

import com.artifex.mupdf.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

public class SplashActivity extends Activity {
	Boolean b;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        File appDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.pdfviewer.openthemagazine/files");
		if(!appDir.isDirectory()){
			appDir.mkdirs();
		}
        Thread start_splash = new Thread(){
        	public void run(){
        		try{
        			sleep(1000);
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
