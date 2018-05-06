package com.example.dugfr1431789.bunker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by DugFr1431789 on 2018-03-26.
 */
public class Ressources extends Activity {
//    private static final int REQUEST_CODE = 1;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ressources);
        Intent intent = getIntent();
        String nomBunker = intent.getStringExtra("nomBunker");
        String nbreSurvivant = String.valueOf(DataBaseHelper.getInstance(context).selectNbreSurvivant());
//        String nomBunkerInText = String.valueOf(DataBaseHelper.getInstance(context).selectNomBunker());
        DataBaseHelper.getInstance(context).insertInfo(nbreSurvivant);
        TextView viewNomBunker = (TextView)findViewById(R.id.nomBunker);
        TextView viewSurvivant = (TextView)findViewById(R.id.nbreSurvivant);
        viewNomBunker.setText(nomBunker);
        viewSurvivant.setText(nbreSurvivant);
        affichageRessources();
    }

    public void affichageRessources(){
        int getEau, getElect, getNourr;

        getEau = DataBaseHelper.getInstance(context).selectIdEau();
        getElect = DataBaseHelper.getInstance(context).selectIdElect();
        getNourr = DataBaseHelper.getInstance(context).selectIdNourr();
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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == REQUEST_CODE){
//            if(resultCode == RESULT_OK){
//                String Eau = data.getStringExtra("Eau");
//                String Elect = data.getStringExtra("Elect");
//                String Nourr = data.getStringExtra("Nourr");
//                int getEau = Integer.valueOf(Eau);
//                int getElect = Integer.valueOf(Elect);
//                int getNourr = Integer.valueOf(Nourr);
//                String eauPourc = String.valueOf((int)(getEau/450.0*100));
//                String electPourc = String.valueOf((int)(getElect/450.0*100));
//                String nourrPourc= String.valueOf((int)(getNourr/450.0*100));
//                LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEau);
//                LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectricite);
//                LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourriture);
//                LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(getEau, LinearLayout.LayoutParams.MATCH_PARENT);
//                LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(getElect, LinearLayout.LayoutParams.MATCH_PARENT);
//                LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(getNourr, LinearLayout.LayoutParams.MATCH_PARENT);
//                widthEau.setLayoutParams(paramsEau);
//                widthElect.setLayoutParams(paramsElect);
//                widthNourr.setLayoutParams(paramsNourr);
//                changeTextViewRess(eauPourc, electPourc, nourrPourc);
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    public void changeTextViewRess(String eau, String elect, String nourr){
//        int eaup;
//        int electp;
//        int nourrp;
//
//        eaup = Integer.valueOf(eau);
//        electp= Integer.valueOf(elect);
//        nourrp = Integer.valueOf(nourr);
//
//        if((eaup > 100 || electp > 100 || nourrp > 100)){
//            if(eaup > 100){
//                eaup = 100;
//            }
//            else if(electp > 100){
//                electp = 100;
//            }
//            else{
//                nourrp = 100;
//            }
//        }
//        else if((eaup < 0 || electp < 0 || nourrp < 0)){
//            if(eaup < 0){
//                eaup = 0;
//            }
//            else if(electp < 0){
//                electp = 0;
//            }
//            else{
//                nourrp = 0;
//            }
//        }
        TextView txtEauPourcent = (TextView) findViewById(R.id.pourcentEau);
        TextView txtElectPourcent = (TextView)findViewById(R.id.pourcentElect);
        TextView txtNourrPourcent = (TextView)findViewById(R.id.pourcentNourr);
        txtEauPourcent.setText(eau + '%');
        txtElectPourcent.setText(elect + '%');
        txtNourrPourcent.setText(nourr + '%');
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menuressources, popup.getMenu());
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.Activites:
                Intent intent1 = new Intent(this, activites.class);
                startActivity(intent1);
//                startActivityForResult(intent1, REQUEST_CODE);
//                intent1.putExtra("EauRes", String.valueOf(getEau));
//                intent1.putExtra("ElectRes", String.valueOf(getElect));
//                intent1.putExtra("NourrRes", String.valueOf(getNourr));
//                setResult(Activity.RESULT_OK,intent1);
//                finish();
                return  true;
            case R.id.Accueil:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                return  true;
            default:
                return false;
        }
    }
}
