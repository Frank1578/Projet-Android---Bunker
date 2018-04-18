package com.example.dugfr1431789.bunker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by DugFr1431789 on 2018-03-26.
 */

public class Ressources extends Activity {
    private static final int REQUEST_CODE = 1;
    NumberFormat formatter = new DecimalFormat("#0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ressources);
        String nomBunker = getIntent().getStringExtra("nomBunker");
        TextView viewNomBunker = (TextView)findViewById(R.id.nomBunker);
        viewNomBunker.setText(nomBunker);
    }

    public void afficherActivites(View btnRessources){
        Intent intent = new Intent(this, activites.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String Eau = data.getStringExtra("Eau");
                String Elect = data.getStringExtra("Elect");
                String Nourr = data.getStringExtra("Nourr");
                int getEau = Integer.valueOf(Eau);
                int getElect = Integer.valueOf(Elect);
                int getNourr = Integer.valueOf(Nourr);
                String eauPourc = String.valueOf((int)(getEau/450.0*100));
                String electPourc = String.valueOf((int)(getElect/450.0*100));
                String nourrPourc= String.valueOf((int)(getNourr/450.0*100));
                LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEau);
                LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectricite);
                LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourriture);
                LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(getEau, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(getElect, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(getNourr, LinearLayout.LayoutParams.MATCH_PARENT);
                widthEau.setLayoutParams(paramsEau);
                widthElect.setLayoutParams(paramsElect);
                widthNourr.setLayoutParams(paramsNourr);
                changeTextViewRess(eauPourc, electPourc, nourrPourc);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void changeTextViewRess(String eau, String elect, String nourr){
        TextView txtEauPourcent = (TextView) findViewById(R.id.pourcentEau);
        TextView txtElectPourcent = (TextView)findViewById(R.id.pourcentElect);
        TextView txtNourrPourcent = (TextView)findViewById(R.id.pourcentNourr);
        txtEauPourcent.setText(eau + '%');
        txtElectPourcent.setText(elect + '%');
        txtNourrPourcent.setText(nourr + '%');
    }
}
