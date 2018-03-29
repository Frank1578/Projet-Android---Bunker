package com.example.dugfr1431789.bunker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void afficherRules(View btnEntrez){
        startActivity(new Intent(MainActivity.this, Regles.class));
    }

    //1. diviser nbre ress actuelle avec le total.

    //<progressbar

}
