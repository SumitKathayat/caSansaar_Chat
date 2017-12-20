package com.nextstyle.ICAI.casansaar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class CPE extends Fragment {
    WebView cpe;
    public CPE() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cpe, container, false);
        cpe=view.findViewById(R.id.Web_VIew);
        cpe.getSettings().setJavaScriptEnabled(true);
        cpe.getSettings().setUserAgentString("Desktop");
        cpe.setVerticalScrollBarEnabled(true);
        cpe.setHorizontalScrollBarEnabled(true);
        cpe.loadUrl("https://cpeapp.icai.org/member/login");
        cpe.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url)
            {
        /* This call inject JavaScript into the page which just finished loading. */
                cpe.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });
        return view;
    }
        @Override
        public void onViewCreated (View view, @Nullable Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);
        }

}
