package com.example.dugfr1431789.bunker;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by DugFr1431789 on 2018-04-05.
 */

public class activites extends Activity {

    protected Button btnEau;
    protected  Button btnElectricite;
    protected Button btnNourriture;
    protected  Button btnSupervision;
    protected Button btnRavitaillement;
    String msg;
    int cptEau = 150;
    int cptElect = 150;
    int cptNourr = 150;
    int cptBarre = 0;
    Random rndMsg = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activites);
        gererBouton();
    }

    public void afficherRessourcesinactivites(View btnRessources){
        Intent intent = new Intent(this, Ressources.class);
        intent.putExtra("Eau", String.valueOf(cptEau));
        intent.putExtra("Elect", String.valueOf(cptElect));
        intent.putExtra("Nourr", String.valueOf(cptNourr));
        setResult(Activity.RESULT_OK,intent);
        finish();
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
                    msg = "Vous avez cliqué sur l'aqueduc.";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
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
//                msg = "Vous avez cliqué sur la supervision.";
//                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });

        btnRavitaillement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberRandom = rndMsg.nextInt(6);

                LinearLayout barreProtection = (LinearLayout) findViewById(R.id.linearProtectionBlack);
                LinearLayout.LayoutParams paramsProtection = (LinearLayout.LayoutParams)barreProtection.getLayoutParams();

                switch(numberRandom){
                    case 0:
                        LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
                        LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(cptEau += 50, LinearLayout.LayoutParams.MATCH_PARENT);
                        widthEau.setLayoutParams(paramsEau);
                        msg = "Un groupe de survivant à trouvé des bidons d'eau! +50 eau.";
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
                        LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(cptElect += 50, LinearLayout.LayoutParams.MATCH_PARENT);
                        widthElect.setLayoutParams(paramsElect);
                        msg = "Des survivants on trouvés des outils qui permettront d'améliorer l'efficacité de la génératrice. +50 électricité.";
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
                        LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(cptNourr += 50, LinearLayout.LayoutParams.MATCH_PARENT);
                        widthNourr.setLayoutParams(paramsNourr);
                        msg = "Des vivres fût trouvés par des survivants. +50 nourriture.";
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        paramsProtection.setMargins(cptBarre += 20, 0, 0, 0);
                        barreProtection.setLayoutParams(paramsProtection);
                        msg = "Des monstres on été tués dans le périmètre de sécurité. +20 protection.";
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        paramsProtection.setMargins(cptBarre -= 20, 0, 0, 0);
                        barreProtection.setLayoutParams(paramsProtection);
                        msg = "Le bunker s'est fait attaquer par des mutants. -20 protection.";
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        paramsProtection.setMargins(cptBarre -= 5, 0, 0, 0);
                        barreProtection.setLayoutParams(paramsProtection);
                        msg = "Un aventurier s'est blessé en cours de chemin et à du être laisser pour mort.";
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }


//                if(numberRandom == 0){
//                    LinearLayout widthEau = (LinearLayout) findViewById(R.id.linearEauAct);
//                    LinearLayout.LayoutParams paramsEau = new LinearLayout.LayoutParams(cptEau += 50, LinearLayout.LayoutParams.MATCH_PARENT);
//                    widthEau.setLayoutParams(paramsEau);
//                    msg = "Un groupe de survivant à trouvé des bidons d'eau! +50 eau.";
//                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
//                }
//                else if(numberRandom == 1){
//                    LinearLayout widthElect = (LinearLayout) findViewById(R.id.linearElectriciteAct);
//                    LinearLayout.LayoutParams paramsElect = new LinearLayout.LayoutParams(cptElect += 50, LinearLayout.LayoutParams.MATCH_PARENT);
//                    widthElect.setLayoutParams(paramsElect);
//                    msg = "Des survivants on trouvés des outils qui permettront d'améliorer l'efficacité de la génératrice. +50 électricité.";
//                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
//                }
//                else{
//                    LinearLayout widthNourr = (LinearLayout) findViewById(R.id.linearNourritureAct);
//                    LinearLayout.LayoutParams paramsNourr = new LinearLayout.LayoutParams(cptNourr += 50, LinearLayout.LayoutParams.MATCH_PARENT);
//                    widthNourr.setLayoutParams(paramsNourr);
//                    msg = "Des vivres fût trouvés par des survivants. +50 nourritures.";
//                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
//                }
            }
        });
    }

    public void verificationNiveauWidth(){
        if((cptEau == 0 || cptElect == 0 || cptNourr == 0)){
            if(cptEau == 0){
                msg = "Votre niveau d'eau est à 0! Les habitants vont mourrir de soif.";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnElectricite.setEnabled(false);
                btnNourriture.setEnabled(false);
            }
            if (cptElect == 0){
                msg = "Le niveau d'électricité est nulle! Vous devez générer du courant";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnEau.setEnabled(false);
                btnNourriture.setEnabled(false);
            }
            if(cptNourr == 0){
                msg = "La réserve de nourriture est vide! Les habitants doivent se nourrir pour survivre.";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                btnEau.setEnabled(false);
                btnElectricite.setEnabled(false);
            }
        }
        else{
            btnEau.setEnabled(true);
            btnElectricite.setEnabled(true);
            btnNourriture.setEnabled(true);
        }
    }
}


