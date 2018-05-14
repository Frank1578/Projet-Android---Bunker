package com.example.dugfr1431789.bunker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DugFr1431789 on 2018-05-01.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLES_RESSOURCES = "tblRessources";
    public static final String ressourcesEau = "resEau";
    public static final String ressourcesElect = "resElect";
    public static final String ressourcesNourr = "resNourr";
    public static final String ressourcesBarre = "resBarre";

    public static final String TABLES_BUNKERINFO = "tblInfos";
    public static final String nbreSurvivant = "nbreSurv";

    public static final String TABLES_SURVIVANTS = "tblSurvivants";
    public static final String nomSurvivant = "nomSurv";
    public static final String metierSurvivant = "metierSurv";
    public static final String forceSurvivant = "forceSurv";
    public static final String intelSurvivant = "intelSurv";

    private SQLiteDatabase dbBunker;
    public static DataBaseHelper sInstance = null;

    public static synchronized DataBaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DataBaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public DataBaseHelper(Context context) {
        super(context, "dbBunker,", null, 1);
        dbBunker = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLES_RESSOURCES + "("
                + ressourcesEau + " REAL,"
                + ressourcesElect + " REAL,"
                + ressourcesNourr + " REAL,"
                + ressourcesBarre + " REAL);");

        db.execSQL("CREATE TABLE " + TABLES_BUNKERINFO + "("
                + nbreSurvivant + " REAL);");

        db.execSQL("CREATE TABLE " + TABLES_SURVIVANTS + "("
                + nomSurvivant + " TEXT,"
                + metierSurvivant + " TEXT,"
                + forceSurvivant + " TEXT,"
                + intelSurvivant + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertIntoActivites(int dataEau, int dataElect, int dataNourr, int dataBarre){
        dbBunker.execSQL("INSERT INTO " + TABLES_RESSOURCES + " VALUES(" + dataEau + "," + dataElect + "," + dataNourr + "," + dataBarre + ");");
    }

    public void insertInfo(String dataSurvivant){
        dbBunker.execSQL("INSERT INTO " + TABLES_BUNKERINFO + " VALUES(" + dataSurvivant + ");");
    }

    public void insertSurvivant(String nom, String metier, String force, String intel){
        dbBunker.execSQL("INSERT INTO " + TABLES_SURVIVANTS + " VALUES(" + "\'" + nom + "\'" + "," + "\'" + metier + "\'" + "," + "\'" + force + "\'" + "," + "\'" + intel + "\'" + ");");
    }



    public int selectIdEau(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + ressourcesEau + " FROM " + TABLES_RESSOURCES, null);

        int info = 0;
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getInt(cursor.getColumnIndex(ressourcesEau));
            }while(cursor.moveToNext());
        }
        return info;
    }

    public int selectIdElect(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + ressourcesElect + " FROM " + TABLES_RESSOURCES, null);

        int info = 0;
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getInt(cursor.getColumnIndex(ressourcesElect));
            }while(cursor.moveToNext());
        }
        return info;
    }

    public int selectIdNourr(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + ressourcesNourr + " FROM " + TABLES_RESSOURCES, null);

        int info = 0;
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getInt(cursor.getColumnIndex(ressourcesNourr));
            }while(cursor.moveToNext());
        }
        return info;
    }

    public int selectIdBarre(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + ressourcesBarre + " FROM " + TABLES_RESSOURCES, null);

        int info = 0;
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getInt(cursor.getColumnIndex(ressourcesBarre));
            }while(cursor.moveToNext());
        }
        return info;
    }

//    public int selectNomBunker(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT " + nomBunker + " FROM " + TABLES_BUNKERINFO, null);
//
//        int info = 0;
//        if(cursor.moveToFirst()) {
//            do {
//                info = cursor.getInt(cursor.getColumnIndex(nomBunker));
//            }while(cursor.moveToNext());
//        }
//        return info;
//    }

    public int selectNbreSurvivant(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + nbreSurvivant + " FROM " + TABLES_BUNKERINFO, null);

        int info = 0;
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getInt(cursor.getColumnIndex(nbreSurvivant));
            }while(cursor.moveToNext());
        }
        return info;
    }

    public String selectNomSurvivant(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + nomSurvivant + " FROM " + TABLES_SURVIVANTS, null);

        String info = "";
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getString(cursor.getColumnIndex(nomSurvivant));
            }while(cursor.moveToNext());
        }
        return info;
    }

    public String selectMetierSurvivant(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + metierSurvivant + " FROM " + TABLES_SURVIVANTS, null);

        String info = "";
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getString(cursor.getColumnIndex(metierSurvivant));
            }while(cursor.moveToNext());
        }
        return info;
    }

    public String selectForceSurvivant(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + forceSurvivant + " FROM " + TABLES_SURVIVANTS, null);

        String info = "";
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getString(cursor.getColumnIndex(forceSurvivant));
            }while(cursor.moveToNext());
        }
        return info;
    }

    public String selectIntelSurvivant(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + intelSurvivant + " FROM " + TABLES_SURVIVANTS, null);

        String info = "";
        if(cursor.moveToFirst()) {
            do {
                info = cursor.getString(cursor.getColumnIndex(intelSurvivant));
            }while(cursor.moveToNext());
        }
        return info;
    }

    public List<UnSurvivant> selectSurvivants(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLES_SURVIVANTS, null);

        List<UnSurvivant> listSurv= new ArrayList<>();
        String name = "";
        String job = "";
        String force = "";
        String intel = "";
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                name = cursor.getString(cursor.getColumnIndex(nomSurvivant));
                job = cursor.getString(cursor.getColumnIndex(metierSurvivant));
                force = cursor.getString(cursor.getColumnIndex(forceSurvivant));
                intel = cursor.getString(cursor.getColumnIndex(intelSurvivant));

                listSurv.add(new UnSurvivant(name, job, force, intel));
            }while(cursor.moveToNext());
        }
        return listSurv;
    }

    public void deleteSurvivant(UnSurvivant survivant){
        dbBunker.delete(TABLES_SURVIVANTS, nomSurvivant + " = '" + survivant.getNomS() + "' AND " + metierSurvivant + " = '" + survivant.getMetierS() + "' AND " + forceSurvivant + " = '" + survivant.getForceS() + "' AND " + intelSurvivant + " = '" + survivant.getIntelS() + "\'", null);
    }
}
