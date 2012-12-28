package com.pdfviewer.openthemagazine;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
	WebServiceCall wsCall;
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
			String data = "";
			try {
				data = URLEncoder.encode("method", "UTF-8")+"="+URLEncoder.encode("user.login", "UTF-8");
				data += "&" + URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode("arijit_at_open" , "UTF-8");
				data += "&" + URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode("arijit_at_open" , "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			data += "&" + URLEncoder.encode("sessid", "UTF-8")+"="+URLEncoder.encode(getSessionId(context) , "UTF-8");
			try {
				wsCall = new WebServiceCall(data);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception");
				e.printStackTrace();
			}
			
			System.out.println("Calling web service");
			boolean threadStatus = wsCall.isThreadSucceeded();
			if (threadStatus) {
				Toast.makeText(getApplicationContext(),"Thread succeed", Toast.LENGTH_SHORT).show();
			}
			else{
				System.out.println("WS failed");
			}
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
