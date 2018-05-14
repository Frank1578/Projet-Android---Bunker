package com.example.dugfr1431789.bunker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

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

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menuregles, popup.getMenu());
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
            case R.id.Activites:
                Intent intent2 = new Intent(this, activites.class);
                startActivity(intent2);
                return  true;
            case R.id.Accueil:
                Intent intent3 = new Intent(this, MainActivity.class);
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
}
