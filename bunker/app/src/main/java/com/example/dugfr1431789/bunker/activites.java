package com.example.dugfr1431789.bunker;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;
import java.util.Random;

import static com.example.dugfr1431789.bunker.DataBaseHelper.getInstance;
import static com.example.dugfr1431789.bunker.DataBaseHelper.sInstance;

/**
 * Created by DugFr1431789 on 2018-04-05.
 */

public class activites extends Activity {
//    private static final int REQUEST_CODE1 = 1;
    protected Button btnEau;
    protected  Button btnElectricite;
    protected Button btnNourriture;
    protected  Button btnSupervision;
    protected Button btnRavitaillement;
    public Context context = this;
    String msg;
    int cptEau = DataBaseHelper.getInstance(context).selectIdEau();
    int cptElect = DataBaseHelper.getInstance(context).selectIdElect();
    int cptNourr = DataBaseHelper.getInstance(context).selectIdNourr();
    int cptBarre = DataBaseHelper.getInstance(context).selectIdBarre();
    int survivant = DataBaseHelper.getInstance(context).selectNbreSurvivant();
    int minRessource = 0;
    int maxRessource = 450;
    Random rndMsg = new Random();
    Random rndNumber = new Random();
    Random rndEvent = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activites);
        affichageRessourcesAct();
        gererBouton();
    }
    public void affichageRessourcesAct(){
        int getEau, getElect, getNourr, getBarre;

        getEau = DataBaseHelper.getInstance(context).selectIdEau();
        getElect = DataBaseHelper.getInstance(context).selectIdElect();
        getNourr = DataBaseHelper.getInstance(context).selectIdNourr();
        getBarre = DataBaseHelper.getInstance(context).selectIdBarre();
        LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
        LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
        LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
        LinearLayout barreProtection = (LinearLayout) findViewById(R.id.linearProtectionBlack);
        LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(getEau, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(getElect, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(getNourr, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams paramsProtection = (LinearLayout.LayoutParams)barreProtection.getLayoutParams();
        paramsProtection.setMargins(getBarre, 0, 0, 0);
        widthEau.setLayoutParams(paramsEau);
        widthElect.setLayoutParams(paramsElect);
        widthNourr.setLayoutParams(paramsNourr);
        barreProtection.setLayoutParams(paramsProtection);
    }

    public void gererBouton(){
        btnEau = (Button)findViewById(R.id.btnAqueduc);
        btnElectricite = (Button) findViewById(R.id.btnGeneratrice);
        btnNourriture = (Button) findViewById(R.id.btnNourriture);
        btnSupervision = (Button) findViewById(R.id.btnSupervision);
        btnRavitaillement = (Button) findViewById(R.id.btnRavitaillement);

        btnEau.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
                LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
                LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
                LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(cptEau += 20, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(cptElect -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(cptNourr -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                verificationNiveauWidth();
                widthEau.setLayoutParams(paramsEau);
                widthElect.setLayoutParams(paramsElect);
                widthNourr.setLayoutParams(paramsNourr);
//                    Log.i("selecteau", String.valueOf(DataBaseHelper.getInstance(context).selectIdEau()));
//                    Log.i("selectelect", String.valueOf(DataBaseHelper.getInstance(context).selectIdElect()));
//                    Log.i("selectnourr", String.valueOf(DataBaseHelper.getInstance(context).selectIdNourr()));
//                    msg = "Vous avez cliqué sur l'aqueduc.";
//                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }
            });

        btnElectricite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
                LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
                LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
                LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(cptElect += 20, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(cptEau -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(cptNourr -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                verificationNiveauWidth();
                widthElect.setLayoutParams(paramsElect);
                widthEau.setLayoutParams(paramsEau);
                widthNourr.setLayoutParams(paramsNourr);
//                msg = "Vous avez cliqué sur la génératrice.";
//                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });

        btnNourriture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
                LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
                LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
                LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(cptNourr += 20, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(cptEau -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(cptElect -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                verificationNiveauWidth();
                widthNourr.setLayoutParams(paramsNourr);
                widthEau.setLayoutParams(paramsEau);
                widthElect.setLayoutParams(paramsElect);
//                    msg = "Vous avez cliqué pour s'occuper du jardin.";
//                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });

        btnSupervision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
                LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
                LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
                LinearLayout barreProtection = (LinearLayout) findViewById(R.id.linearProtectionBlack);
                LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(cptNourr -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(cptEau -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(cptElect -= 5, LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout.LayoutParams paramsProtection = (LinearLayout.LayoutParams)barreProtection.getLayoutParams();
                paramsProtection.setMargins(cptBarre += 5, 0, 0, 0);
                verificationNiveauWidth();
                widthNourr.setLayoutParams(paramsNourr);
                widthEau.setLayoutParams(paramsEau);
                widthElect.setLayoutParams(paramsElect);
                barreProtection.setLayoutParams(paramsProtection);
                Log.i("selectbarre", String.valueOf(DataBaseHelper.getInstance(context).selectIdBarre()));
//                msg = "Vous avez cliqué sur la supervision.";
//                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });

        btnRavitaillement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberRandom = rndMsg.nextInt(7);
                int numberRandomRessource = rndNumber.nextInt(30);
                int numberEvent = rndEvent.nextInt(5);
                Survivants survivor = new Survivants();

                LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
                LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
                LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
                LinearLayout barreProtection = (LinearLayout) findViewById(R.id.linearProtectionBlack);
                LinearLayout.LayoutParams paramsProtection = (LinearLayout.LayoutParams)barreProtection.getLayoutParams();

                switch(numberRandom){
                    case 0:
                        if(numberEvent == 1){
                            LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(cptEau -= 20, LinearLayout.LayoutParams.MATCH_PARENT);
                            widthEau.setLayoutParams(paramsEau);
                            verificationNiveauWidth();
                            msg = "Une fuite dans la tuyauterie est présente, un perte d'eau considérable s'est produite. -20 eau.";
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        }else {
                            LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(cptEau += 50, LinearLayout.LayoutParams.MATCH_PARENT);
                            widthEau.setLayoutParams(paramsEau);
                            verificationNiveauWidth();
                            msg = "Un groupe de survivant à trouvé des bidons d'eau! +50 eau.";
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 1:
                        if(numberEvent == 1){
                            LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(cptElect -= 20, LinearLayout.LayoutParams.MATCH_PARENT);
                            widthElect.setLayoutParams(paramsElect);
                            survivant -= 1;
                            verificationNiveauWidth();
                            DataBaseHelper.getInstance(context).insertInfo(String.valueOf(survivant));
                            msg = "La génératrice a disjoncté, une perte de courant s'est produite et a couté la vie à l'opérateur. -20 electrécité et -1 survivant.";
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        }else {
                            LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(cptElect += 50, LinearLayout.LayoutParams.MATCH_PARENT);
                            widthElect.setLayoutParams(paramsElect);
                            verificationNiveauWidth();
                            msg = "Des survivants on trouvés des outils qui permettront d'améliorer l'efficacité de la génératrice. +50 électricité.";
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 2:
                        if(numberEvent == 1){
                            LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(cptNourr -= 20, LinearLayout.LayoutParams.MATCH_PARENT);
                            widthNourr.setLayoutParams(paramsNourr);
                            verificationNiveauWidth();
                            msg = "De la nourriture périmée à été trouvé dans le stockage. -20 nourriture.";
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        }
                        else {
                            LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(cptNourr += 50, LinearLayout.LayoutParams.MATCH_PARENT);
                            widthNourr.setLayoutParams(paramsNourr);
                            verificationNiveauWidth();
                            msg = "Des vives fut trouvés par des survivants. +50 nourriture.";
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 3:
                        paramsProtection.setMargins(cptBarre += 20, 0, 0, 0);
                        barreProtection.setLayoutParams(paramsProtection);
                        msg = "Des monstres on été tués dans le périmètre de sécurité. +20 protection.";
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                            if(cptBarre <= 3){
                                cptBarre = 3;
                                LinearLayout.LayoutParams paramsNourrN = new LinearLayout.LayoutParams(cptNourr -= numberRandomRessource, LinearLayout.LayoutParams.MATCH_PARENT);
                                LinearLayout.LayoutParams paramsEauN = new LinearLayout.LayoutParams(cptEau -= numberRandomRessource, LinearLayout.LayoutParams.MATCH_PARENT);
                                LinearLayout.LayoutParams paramsElectN = new LinearLayout.LayoutParams(cptElect -= numberRandomRessource, LinearLayout.LayoutParams.MATCH_PARENT);
                                widthNourr.setLayoutParams(paramsNourrN);
                                widthEau.setLayoutParams(paramsEauN);
                                widthElect.setLayoutParams(paramsElectN);
                                msg = "La protection du bunker est au niveau 0! Vous êtes en danger.";
                                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                            }
                            else{
                                paramsProtection.setMargins(cptBarre -= 20, 0, 0, 0);
                                barreProtection.setLayoutParams(paramsProtection);
                                DataBaseHelper.getInstance(context).insertIntoActivites(cptEau, cptElect, cptNourr, cptBarre);
                                msg = "Le bunker s'est fait attaquer par des mutants. -20 protection.";
                                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                            }
                        break;
                    case 5:
                        if(cptBarre <= 3){
                            cptBarre = 3;
                            LinearLayout.LayoutParams paramsNourrN = new LinearLayout.LayoutParams(cptNourr -= numberRandomRessource, LinearLayout.LayoutParams.MATCH_PARENT);
                            LinearLayout.LayoutParams paramsEauN = new LinearLayout.LayoutParams(cptEau -= numberRandomRessource, LinearLayout.LayoutParams.MATCH_PARENT);
                            LinearLayout.LayoutParams paramsElectN = new LinearLayout.LayoutParams(cptElect -= numberRandomRessource, LinearLayout.LayoutParams.MATCH_PARENT);
                            widthNourr.setLayoutParams(paramsNourrN);
                            widthEau.setLayoutParams(paramsEauN);
                            widthElect.setLayoutParams(paramsElectN);
                            msg = "La protection du bunker est au niveau 0! Vous êtes en danger.";
                            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        }
                        else {
                            survivant -= 1;
                            survivor.supprimerSurvivant();
                            paramsProtection.setMargins(cptBarre -= 5, 0, 0, 0);
                            barreProtection.setLayoutParams(paramsProtection);
                            DataBaseHelper.getInstance(context).insertInfo(String.valueOf(survivant));
                            DataBaseHelper.getInstance(context).insertIntoActivites(cptEau, cptElect, cptNourr, cptBarre);
                            msg = "Un aventurier s'est blessé en cours de chemin et à du être laisser pour mort. -5 protection et -1 survivant.";
                            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 6:
                        for(int i =0; i < 3; i++){
                            survivor.genererUnSurvivant();
                        }
                        survivant += 3;
                        DataBaseHelper.getInstance(context).insertInfo(String.valueOf(survivant));
                        msg = "Des survivants fût trouver au cours d'une recherche à l'extérieur. +3 survivants.";
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void verificationNiveauWidth(){
        if((cptEau < minRessource || cptElect < minRessource || cptNourr < minRessource)){
            if(cptEau < minRessource){
                cptEau = minRessource;
                msg = "Votre niveau d'eau est à 0! Les habitants vont mourrir de soif.";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnElectricite.setEnabled(false);
                btnNourriture.setEnabled(false);
                btnSupervision.setEnabled(false);
            }
            else if (cptElect < minRessource){
                cptElect = minRessource;
                msg = "Le niveau d'électricité est nulle! Vous devez générer du courant.";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnEau.setEnabled(false);
                btnNourriture.setEnabled(false);
                btnSupervision.setEnabled(false);
            }
            else {
                cptNourr = minRessource;
                msg = "La réserve de nourriture est vide! Les habitants doivent se nourrir pour survivre.";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnEau.setEnabled(false);
                btnElectricite.setEnabled(false);
                btnSupervision.setEnabled(false);
            }
        }
        else{
            DataBaseHelper.getInstance(context).insertIntoActivites(cptEau, cptElect, cptNourr, cptBarre);
            btnEau.setEnabled(true);
            btnElectricite.setEnabled(true);
            btnNourriture.setEnabled(true);
            btnSupervision.setEnabled(true);
        }

        if((cptEau > maxRessource || cptElect > maxRessource || cptNourr > maxRessource || cptBarre > maxRessource)){
            if(cptEau > maxRessource){
                cptEau = maxRessource;
                msg = "Votre niveau d'eau est au maximum! Vous n'avez plus assez de stockage.";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnEau.setEnabled(false);
            }
            else if (cptElect > maxRessource){
                cptElect = maxRessource;
                msg = "Le niveau d'électricité est au maximum!";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnElectricite.setEnabled(false);
            }
            else if (cptNourr > maxRessource){
                cptNourr = maxRessource;
                msg = "La réserve de nourriture est au maximum!";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnNourriture.setEnabled(false);
            }
            else{
                cptBarre = maxRessource;
                msg = "Vous ne pouvez pas vous protèger davantage!";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnSupervision.setEnabled(false);
            }
        }
        else{
            DataBaseHelper.getInstance(context).insertIntoActivites(cptEau, cptElect, cptNourr, cptBarre);
            btnEau.setEnabled(true);
            btnElectricite.setEnabled(true);
            btnNourriture.setEnabled(true);
        }
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menuoption, popup.getMenu());
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.Ressources:
//              startActivityForResult(intent, REQUEST_CODE1);
                Intent intent = new Intent(this, Ressources.class);
//                intent.putExtra("Eau", String.valueOf(cptEau));
//                intent.putExtra("Elect", String.valueOf(cptElect));
//                intent.putExtra("Nourr", String.valueOf(cptNourr));
//                setResult(Activity.RESULT_OK,intent);
//                finish();
                startActivity(intent);
                return  true;
            case R.id.Accueil:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                return  true;
            case R.id.Regles:
                Intent intent3 = new Intent(this, Regles.class);
                startActivity(intent3);
                return true;
            case R.id.Survivants:
                Intent intent4 = new Intent(this, Survivants.class);
                startActivity(intent4);
                return true;
            default:
                return false;
        }
    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        if(requestCode == REQUEST_CODE1){
//            if(resultCode == RESULT_OK){
//                String Eau = data.getStringExtra("EauRes");
//                String Elect = data.getStringExtra("ElectRes");
//                String Nourr = data.getStringExtra("NourrRes");
//                int eau = Integer.valueOf(Eau);
//                int elect = Integer.valueOf(Elect);
//                int nourr = Integer.valueOf(Nourr);
//                LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
//                LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
//                LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
//                LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(eau, LinearLayout.LayoutParams.MATCH_PARENT);
//                LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(elect, LinearLayout.LayoutParams.MATCH_PARENT);
//                LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(nourr, LinearLayout.LayoutParams.MATCH_PARENT);
//                widthEau.setLayoutParams(paramsEau);
//                widthElect.setLayoutParams(paramsElect);
//                widthNourr.setLayoutParams(paramsNourr);
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}


