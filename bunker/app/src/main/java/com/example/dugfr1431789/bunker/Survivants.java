package com.example.dugfr1431789.bunker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by DugFr1431789 on 2018-05-06.
 */

public class Survivants extends Activity{
    private ListView lstSurvivor;
    private adapterSurvivant adapter;
    public static Context context;
    private List<UnSurvivant> listItemSurvivant = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survivants);
        lstSurvivor = (ListView)findViewById(R.id.lstSurvivant);

        listItemSurvivant = DataBaseHelper.getInstance(context).selectSurvivants();
        displaySurvivors();
        gererListe();
    }

    public List<UnSurvivant> getListItemSurvivant() {
        return listItemSurvivant;
    }

    public void setListItemSurvivant(List<UnSurvivant> listItemSurvivant) {
        this.listItemSurvivant = listItemSurvivant;
    }

    public void displaySurvivors()
    {
        adapter = new adapterSurvivant(getApplicationContext(), getListItemSurvivant());

        lstSurvivor.setAdapter(adapter);
    }

    public void genererUnSurvivant(){
        Random rnd = new Random();
        UnSurvivant survivor;
        int randomPren = rnd.nextInt(25);
        int randomMetier = rnd.nextInt(5);
        int randomForce = rnd.nextInt(11);
        int randomIntel = rnd.nextInt(11);
        String prenomGenerer, metierGenerer;
        String[] prenoms = new String[]{
                "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
                "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
                "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
                "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
                "Yann", "Zoé"
        };
        String[] metier = new String[]{
                "Cultivateur", "Protecteur", "Ravitailleur", "Électricien", "Opérateur"
        };
        prenomGenerer = prenoms[randomPren];
        metierGenerer = metier[randomMetier];
        survivor = (new UnSurvivant(prenomGenerer, metierGenerer, String.valueOf(randomForce), String.valueOf(randomIntel)));
        DataBaseHelper.getInstance(context).insertSurvivant(survivor.nomS, survivor.metierS, survivor.forceS, survivor.intelS);
        listItemSurvivant.add(survivor);
    }

    public void supprimerSurvivant(){
        Random rndNumber = new Random();
        int rnd = rndNumber.nextInt(Math.max(0, listItemSurvivant.size()));
        DataBaseHelper.getInstance(getApplicationContext()).deleteSurvivant(listItemSurvivant.remove(rnd));
    }
    public void genererSurv(View v) {
        genererUnSurvivant();
        displaySurvivors();
    }

    public void deleteSurvivantAct(View v){
        if(listItemSurvivant.size() == 0){
            Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG);
        }else{
            supprimerSurvivant();
            displaySurvivors();
        }
    }

    public void gererListe(){
        lstSurvivor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView extrName = (TextView)view.findViewById(R.id.name);
                TextView extrJob = (TextView)view.findViewById(R.id.job);
                TextView extrForce = (TextView)view.findViewById(R.id.strenght);
                TextView extrIntel = (TextView)view.findViewById(R.id.intel);

                String nameText = extrName.getText().toString();
                String jobText = extrJob.getText().toString();
                String forceText = extrForce.getText().toString();
                String intelText = extrIntel.getText().toString();

                TextView txtNomSurv = (TextView) findViewById(R.id.nomSurv);
                TextView txtMetier = (TextView) findViewById(R.id.metierSurv);
                TextView txtForce = (TextView) findViewById(R.id.forceSurv);
                TextView txtIntel = (TextView) findViewById(R.id.intelSurv);

                txtNomSurv.setText(nameText);
                txtMetier.setText(jobText);
                txtForce.setText(forceText);
                txtIntel.setText(intelText);

                int intelHumeur = Integer.valueOf(intelText.toString());
                ImageView imgHumeur = (ImageView) findViewById(R.id.humeurSurv);

                if(intelHumeur >= 0 && intelHumeur < 4){
                    imgHumeur.setBackgroundResource(R.drawable.smileyvert);
                }
                else if(intelHumeur >= 4 && intelHumeur < 7){
                    imgHumeur.setBackgroundResource(R.drawable.smileyneutre);
                }
                else if (intelHumeur >= 7){
                    imgHumeur.setBackgroundResource(R.drawable.smileytriste);
                }
            }
        });
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menusurvivants, popup.getMenu());
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
            case R.id.Regles:
                Intent intent3 = new Intent(this, Regles.class);
                startActivity(intent3);
                return true;
            case R.id.Ressources:
                Intent intent4 = new Intent(this, Ressources.class);
                startActivity(intent4);
                return true;
            default:
                return false;
        }
    }
}
