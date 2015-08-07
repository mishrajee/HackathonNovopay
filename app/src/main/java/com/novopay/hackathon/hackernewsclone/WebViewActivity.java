package com.novopay.hackathon.hackernewsclone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by chinmaykrishna on 07/08/15.
 */

public class WebViewActivity extends ActionBarActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        myWebView = (WebView) findViewById(R.id.webview);
        //myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www.bloomberg.com/news/features/2015-08-06/google-s-6-billion-miscalculation-on-the-eu?cmpid=BBD080615_BIZ");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
