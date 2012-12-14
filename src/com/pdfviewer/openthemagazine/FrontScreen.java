package com.pdfviewer.openthemagazine;


import com.artifex.mupdf.ChoosePDFActivity;
import com.artifex.mupdf.R;
import com.artifex.mupdf.R.id;
import com.artifex.mupdf.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class FrontScreen extends Activity implements OnClickListener {
	ImageButton ibOpenFile, ibSubscribe, ibLibrary;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.front_screen);
		initialize();
	}
	private void initialize() {
		// TODO Auto-generated method stub
		ibOpenFile = (ImageButton) findViewById(R.id.openFile);
		ibSubscribe = (ImageButton) findViewById(R.id.subscribe);
		ibLibrary = (ImageButton) findViewById(R.id.ibLibrary);
		ibOpenFile.setOnClickListener(this);
		ibSubscribe.setOnClickListener(this);
		ibLibrary.setOnClickListener(this);
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == ibOpenFile.getId()){
			Intent start_main_activity = new Intent("android.intent.action.CHOOSEPDFACTIVITY");
			startActivity(start_main_activity);
		}
		if(v.getId() == ibSubscribe.getId()){
			startActivity(new Intent(this, Subscription.class));
		}
		if(v.getId() == ibLibrary.getId()){
			startActivity(new Intent(this, ChoosePDFActivity.class));
		}
	}

}
