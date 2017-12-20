package com.nextstyle.ICAI.casansaar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Intent newIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView about=findViewById(R.id.AboutId);
        CardView motto=findViewById(R.id.MottoId);
        CardView committee=findViewById(R.id.CommitteeId);
        CardView wicasa=findViewById(R.id.WicasaId);
        CardView directory=findViewById(R.id.ContactID);
        CardView Gallery =findViewById(R.id.GalleryID);
        CardView CPE=findViewById(R.id.CPEId);
        CardView Events=findViewById(R.id.EventsId);
        CardView contacts=findViewById(R.id.ContactUsID);
        CardView exit=findViewById(R.id.ExitId);

        newIntent=new Intent(MainActivity.this,Main2Activity.class);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","0");
                startActivity(newIntent);
            }
        });

        motto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","1");
                startActivity(newIntent);
            }
        });

        committee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","2");
                startActivity(newIntent);
            }
        });

        wicasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","3");
                startActivity(newIntent);
            }
        });
        directory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","4");
                startActivity(newIntent);
            }
        });

        CPE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","5");
                startActivity(newIntent);
            }
        });

        Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","6");
                startActivity(newIntent);
            }
        });

        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","7");
                startActivity(newIntent);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("id","8");
                startActivity(newIntent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
