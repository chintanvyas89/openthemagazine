package com.pdfviewer.openthemagazine;

import java.io.File;

import com.artifex.mupdf.ChooseMagazine;
import com.artifex.mupdf.MuPDFActivity;
import com.artifex.mupdf.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class FrontScreen extends Activity implements OnClickListener {
	ImageButton ibOpenFile, ibSubscribe, ibLibrary, ibList, grid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.front_screen);
		initialize();
		setButtonBackground();
	}

	private void setButtonBackground() {
		// TODO Auto-generated method stub
		String pathName = "/mnt/sdcard/Download/toc-cover-winter-travel.jpg";
		Bitmap bmp = BitmapFactory.decodeFile(pathName);
		ibOpenFile.setImageBitmap(bmp);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		ibOpenFile = (ImageButton) findViewById(R.id.openFile);
		ibSubscribe = (ImageButton) findViewById(R.id.subscribe);
		ibLibrary = (ImageButton) findViewById(R.id.ibLibrary);
		ibList = (ImageButton) findViewById(R.id.ibList);
		grid = (ImageButton) findViewById(R.id.ibGrid);
		ibOpenFile.setOnClickListener(this);
		ibSubscribe.setOnClickListener(this);
		ibLibrary.setOnClickListener(this);
		ibList.setOnClickListener(this);
		grid.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int cust = v.getId();
		if (cust == ibOpenFile.getId()) {
			File f = new File(
					"/mnt/sdcard/Download/Final PDF FOR WEB 26th NOV 12.pdf");
			Uri uri = Uri.parse(f.getAbsolutePath());
			Intent intent = new Intent(this, MuPDFActivity.class);
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(uri);
			startActivity(intent);
			/*
			 * Intent start_main_activity = new
			 * Intent("android.intent.action.CHOOSEPDFACTIVITY");
			 * startActivity(start_main_activity);
			 */
		}
		if (cust == ibSubscribe.getId()) {
			startActivity(new Intent(this, Subscription.class));
		}
		if (cust == ibLibrary.getId()) {
			// startActivity(new Intent(this, ChoosePDFActivity.class));
			Intent start_main_activity = new Intent(
					"android.intent.action.CHOOSEPDFACTIVITY");
			startActivity(start_main_activity);
		}
		if (cust == ibList.getId()) {
			// Intent i = new Intent("android.intent.action.CHOOSEMAGAZINE");
			// startActivity(i);
			startActivity(new Intent("android.intent.action.CHOOSEMAGAZINE"));
			// startActivity(new Intent(this,
			// com.artifex.mupdf.ChooseMagazine.class));
		}
		if (cust == grid.getId()) {
			Log.v("cbv", "here");
			startActivity(new Intent("android.intent.action.GRIDMAGAZINESACTIVITY"));
		}
	}
}
