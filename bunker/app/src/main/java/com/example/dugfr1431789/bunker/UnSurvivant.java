package com.example.dugfr1431789.bunker;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DugFr1431789 on 2018-05-06.
 */

public class UnSurvivant {
    String nomS, metierS, forceS, intelS;

    public UnSurvivant(){
        super();
    }

    public UnSurvivant(String nom, String metier, String force, String intel){
        super();
        nomS = nom;
        metierS = metier;
        forceS = force;
        intelS = intel;
    }
    public String getNomS() {return nomS;   }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public String getMetierS() {
        return metierS;
    }

    public void setMetierS(String metierS) {
        this.metierS = metierS;
    }

    public String getForceS() {
        return forceS;
    }

    public void setForceS(String forceS) {
        this.forceS = forceS;
    }

    public String getIntelS() {
        return intelS;
    }

    public void setIntelS(String intelS) {
        this.intelS = intelS;
    }


    @Override
    public String toString(){
        return nomS + metierS + forceS + intelS;
    }
}
