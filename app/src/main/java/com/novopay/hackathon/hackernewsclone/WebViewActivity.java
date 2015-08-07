package com.novopay.hackathon.hackernewsclone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;

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
        myWebView.loadUrl("http://www.bloomberg.com/news/features/2015-08-06/google-s-6-billion-miscalculation-on-the-eu?cmpid=BBD080615_BIZ");
    }
}
