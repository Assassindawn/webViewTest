package com.example.webviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//1
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView) this.findViewById(R.id.wv1);

        WebSettings settings = wv.getSettings();
        settings.setSupportMultipleWindows(true);
        settings.setLoadWithOverviewMode(true);
            wv.getSettings().setUseWideViewPort(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
            wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //设置滚动条样式.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //设置滚动条样式
            wv.loadUrl("http://192.168.31.189:8080/web");
            wv.addJavascriptInterface(this, "register_js");
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        }


    }
