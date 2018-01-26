package com.example.evolved.widgets.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.evolved.widgets.R;

import java.util.ArrayList;

/**
 * Created by Evolved on 1/21/2018.
 */

public class KotaAdapter extends ArrayAdapter<String> {
    String mProvinsi = "";


    public KotaAdapter(Context context, ArrayList<String> listKota) {
        super(context, R.layout.row_spinner_kota, listKota);
    }


    public void setProvinsi(String provinsi) {
        this.mProvinsi = provinsi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_spinner_kota, parent, false);

        TextView tvTitle = convertView.findViewById(R.id.textViewTitle);
        tvTitle.setText(getItem(position).substring(0, 1));
        TextView tvKota = convertView.findViewById(R.id.textViewKota);
        tvTitle.setText(getItem(position).substring(0, 1));
        TextView tvProvinsi = convertView.findViewById(R.id.textViewProvinsi);
        tvTitle.setText(getItem(position).substring(0, 1));

        return convertView;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


}
