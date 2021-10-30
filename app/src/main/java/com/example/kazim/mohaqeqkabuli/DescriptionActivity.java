package com.example.kazim.mohaqeqkabuli;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DescriptionActivity extends AppCompatActivity {

    private Context context;
    private Bundle extras;
    private WebView webView;
    private WebSettings webSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        context=DescriptionActivity.this;

        webView=(WebView)findViewById(R.id.simpleWebView);

        extras=getIntent().getExtras();
        if (!extras.equals(null)){

            String data=extras.getString("titles");

            String url="file:///android_asset/"+data+".html";
            webView.loadUrl(url);
            webView.setBackgroundResource(R.drawable.background);
            webView.setBackgroundColor(0x00000000);

            webSettings=webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setDefaultTextEncodingName("utf-8");
            try{
                webSettings.setDefaultFontSize(SettingsActivity.seekbar.getProgress());
            }catch (Exception e){
                e.printStackTrace();
            }
            webSettings.setJavaScriptEnabled(true);

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishActivity(1);
    }
}
