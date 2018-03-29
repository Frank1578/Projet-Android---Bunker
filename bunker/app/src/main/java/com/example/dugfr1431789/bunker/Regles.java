package com.example.dugfr1431789.bunker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by DugFr1431789 on 2018-03-21.
 */

public class Regles extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regles);
    }


    public void afficherRessources(View btnRessources){
        startActivity(new Intent(Regles.this, Ressources.class));
    }
}
