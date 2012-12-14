package com.pdfviewer.openthemagazine;

import com.artifex.mupdf.R;
import com.artifex.mupdf.R.id;
import com.artifex.mupdf.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Subscription extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subscribe_webview);
        WebView myWebView = (WebView) findViewById(R.id.wv_sub);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www.openthemagazine.com/subscribe");
        myWebView.getOriginalUrl();
	}

}
