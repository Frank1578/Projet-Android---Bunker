package com.example.dugfr1431789.bunker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DugFr1431789 on 2018-05-06.
 */

public class adapterSurvivant extends BaseAdapter
{
    private Context mContext;
    private List<UnSurvivant> mSurvivorList;

    public adapterSurvivant(Context mContext, List<UnSurvivant> mSurvivorList) {
        this.mContext = mContext;
        this.mSurvivorList = mSurvivorList;
    }

    @Override
    public int getCount() {
        return mSurvivorList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = View.inflate(mContext,R.layout.survivors,null);
        TextView name = (TextView)v.findViewById(R.id.name);
        TextView job = (TextView)v.findViewById(R.id.job);
        TextView strenght = (TextView)v.findViewById(R.id.strenght);
        TextView intel = (TextView)v.findViewById(R.id.intel);

        name.setText(mSurvivorList.get(position).getNomS());
        job.setText(mSurvivorList.get(position).getMetierS());
        strenght.setText(mSurvivorList.get(position).getForceS());
        intel.setText(mSurvivorList.get(position).getIntelS());

        return v;
    }
}
