package com.example.dugfr1431789.bunker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void afficherRules(View btnEntrez){
        EditText txtBunker = (EditText)findViewById(R.id.bunkerName);
        String nomBunker = txtBunker.getText().toString();
        Intent intent = new Intent(this, Ressources.class);
        intent.putExtra("nomBunker", nomBunker);
        startActivity(intent);
    }
}

//ajout dun bouton menu
//commencement de la bd
//thread ressources