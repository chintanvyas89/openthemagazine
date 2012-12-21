package com.pdfviewer.openthemagazine;

import com.artifex.mupdf.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Subscription extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subscribe_webview);
		WebView myWebView = (WebView) findViewById(R.id.wv_sub);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO Auto-generated method stub
				if (url.equals("http://www.openthemagazine.com/subscribe")) {
					Toast.makeText(getBaseContext(), url, Toast.LENGTH_SHORT)
							.show();
					//finish();
					startActivity(new Intent(Subscription.this, com.artifex.mupdf.ChooseMagazine.class));
				}
				super.onPageStarted(view, url, favicon);
			}
		});
		myWebView.loadUrl("http://www.openthemagazine.com/subscribe");
		myWebView.getOriginalUrl();
	}
}
