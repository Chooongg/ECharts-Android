package com.chooongg.kotlinecharts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var webView:WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.web_view)

        webView.settings.allowFileAccess = true
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/echarts.html")
        webView.webViewClient = object:WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webView.loadUrl("javascript:setOption(${
                  "{\n" +
                          "  xAxis: {\n" +
                          "    type: 'category',\n" +
                          "    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']\n" +
                          "  },\n" +
                          "  grid:{\n" +
                          "    left: 50\n" +
                          "  },\n" +
                          "  yAxis: {\n" +
                          "    type: 'value'\n" +
                          "  },\n" +
                          "  series: [\n" +
                          "    {\n" +
                          "      data: [820, 932, 901, 934, 1290, 1330, 1320],\n" +
                          "      type: 'line',\n" +
                          "      smooth: true\n" +
                          "    }\n" +
                          "  ]\n" +
                          "}"
                })")
            }
        }
    }
}