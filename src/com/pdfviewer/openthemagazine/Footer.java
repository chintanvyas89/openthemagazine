package com.pdfviewer.openthemagazine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.artifex.mupdf.R;

public class Footer extends Activity implements OnClickListener {
	Button blibrary, bstore, bcontents, bcover, bsettings, binfo, bsignin;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.footer);
		initialize();
	}
/**
 * Create button handler for footer xml buttons.
 */
	private void initialize() {
		// TODO Auto-generated method stub
		blibrary = (Button) findViewById(R.id.library);
		bstore = (Button) findViewById(R.id.store);
		bcontents = (Button) findViewById(R.id.contents);
		bcover = (Button) findViewById(R.id.cover);
		bsettings = (Button) findViewById(R.id.settings);
		binfo = (Button) findViewById(R.id.info);
		bsignin = (Button) findViewById(R.id.button_signin);
		setClickListener();
	}

/**
 * Set Click listner for each button.
 */
	private void setClickListener() {
		// TODO Auto-generated method stub
		blibrary.setOnClickListener(this);
		bstore.setOnClickListener(this);
		bcontents.setOnClickListener(this);
		bcover.setOnClickListener(this);
		bsettings.setOnClickListener(this);
		binfo.setOnClickListener(this);
		bsignin.setOnClickListener(this);
	}

	@Override
	/**
	 * This method is called when any button from footer is clicked.
	 */
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int cust = v.getId();
		if (cust == blibrary.getId()) {
			Toast.makeText(getApplicationContext(),"Library Button clicked", Toast.LENGTH_SHORT).show();
		}
		if (cust == bstore.getId()) {
			Toast.makeText(getApplicationContext(),"Store Button clicked", Toast.LENGTH_SHORT).show();
		}
		if (cust == bcontents.getId()) {
			Toast.makeText(getApplicationContext(),"Contents Button clicked", Toast.LENGTH_SHORT).show();
		}
		if (cust == bcover.getId()) {
			Toast.makeText(getApplicationContext(),"Cover Button clicked", Toast.LENGTH_SHORT).show();
		}
		if (cust == bsettings.getId()) {
			Toast.makeText(getApplicationContext(),"Settings Button clicked", Toast.LENGTH_SHORT).show();
		}
		if (cust == binfo.getId()) {
			Toast.makeText(getApplicationContext(),"Info Button clicked", Toast.LENGTH_SHORT).show();
		}
		if (cust == bsignin.getId()) {
			//Toast.makeText(getApplicationContext(),"Info Button clicked", Toast.LENGTH_SHORT).show();
			startActivity(new Intent("android.intent.action.SIGNINDIALOG"));
		}
	}
}
