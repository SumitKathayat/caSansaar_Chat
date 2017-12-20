package com.nextstyle.ICAI.casansaar;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Created by Admin on 12/13/2017.
 */

public class casansaar extends Application{
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        Picasso.Builder bulider=new Picasso.Builder(this);
        bulider.downloader((new OkHttpDownloader(this,Integer.MAX_VALUE)));
        Picasso built=bulider.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }
}
