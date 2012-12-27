package com.pdfviewer.openthemagazine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.artifex.mupdf.R;

public class SigninDialog extends Activity implements OnClickListener{
	Button bSignin, bCancel;
	ImageButton close_signin_dialog;
	EditText etuname, etpass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_signin);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		bSignin = (Button) findViewById(R.id.bsignin);
		bCancel = (Button) findViewById(R.id.bcancel);
		close_signin_dialog = (ImageButton) findViewById(R.id.close_signin_dialog);
		etuname = (EditText) findViewById(R.id.etusername);
		etpass = (EditText) findViewById(R.id.etpassword);
		setClickListener();
	}

	private void setClickListener() {
		// TODO Auto-generated method stub
		bSignin.setOnClickListener(this);
		bCancel.setOnClickListener(this);
		close_signin_dialog.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int cust = v.getId();
		if (cust == bSignin.getId()) {
			Toast.makeText(getApplicationContext(),"Sign in Button clicked", Toast.LENGTH_SHORT).show();
		}
		if (cust == bCancel.getId()) {
			Toast.makeText(getApplicationContext(),"Cancel Button clicked", Toast.LENGTH_SHORT).show();
			finish();
		}
		if (cust == close_signin_dialog.getId()) {
			Toast.makeText(getApplicationContext(),"Close Button clicked", Toast.LENGTH_SHORT).show();
			finish();
		}
	}
	
}
