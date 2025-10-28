package com.example.valuta;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter {
    private Activity context;
    private Integer[] images;
    private String[] currShort;
    private String[] currency;
    private Double[] cumpara;
    private Double[] vinde;
    private ArrayList<Boolean> visibleStates;


    public CustomListViewAdapter(@NonNull Activity context, String[] currShort, String[] currency,
                                 Integer[] images, Double[] cumpara, Double[] vinde) {
        super(context, R.layout.list_item, currShort);

        this.context = context;
        this.currShort = currShort;
        this.currency = currency;
        this.images = images;
        this.cumpara = cumpara;
        this.vinde = vinde;

        visibleStates = new ArrayList<>();
        for (int i = 0; i < currShort.length; i++) {
            visibleStates.add(false);
        }
    }

    public void setVisibility(int position) {
        visibleStates.set(position, true);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView currTV = rowView.findViewById(R.id.curr);
        TextView currencyTV = rowView.findViewById(R.id.currency);
        ImageView imageIV = rowView.findViewById(R.id.image);
        TextView cumparaTV = rowView.findViewById(R.id.cumpara);
        TextView vindeTV = rowView.findViewById(R.id.vinde);
        TextView cumparaTVL = rowView.findViewById(R.id.cumparaTV);
        TextView vindeTVL = rowView.findViewById(R.id.vindeTV);


        currTV.setText(currShort[position]);
        currencyTV.setText(currency[position]);
        imageIV.setImageResource(images[position]);
        cumparaTV.setText(cumpara[position].toString() + " RON");
        vindeTV.setText(vinde[position].toString() + " RON");

        cumparaTV.setVisibility(View.INVISIBLE);
        cumparaTVL.setVisibility(View.INVISIBLE);
        vindeTV.setVisibility(View.INVISIBLE);
        vindeTVL.setVisibility(View.INVISIBLE);

        if (visibleStates.get(position)) {
            cumparaTV.setVisibility(View.VISIBLE);
            cumparaTVL.setVisibility(View.VISIBLE);
            vindeTV.setVisibility(View.VISIBLE);
            vindeTVL.setVisibility(View.VISIBLE);
        } else {
            cumparaTV.setVisibility(View.INVISIBLE);
            cumparaTVL.setVisibility(View.INVISIBLE);
            vindeTV.setVisibility(View.INVISIBLE);
            vindeTVL.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }

}
