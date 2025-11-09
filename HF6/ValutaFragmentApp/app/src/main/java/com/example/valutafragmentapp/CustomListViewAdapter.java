package com.example.valutafragmentapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListViewAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] images;
    private final String[] currShort;
    private final String[] currency;

    public CustomListViewAdapter(@NonNull Activity context,
                                 @NonNull String[] currShort,
                                 @NonNull String[] currency,
                                 @NonNull Integer[] images) {
        super(context, R.layout.list_item, currShort);
        this.context = context;
        this.currShort = currShort;
        this.currency = currency;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            rowView = inflater.inflate(R.layout.list_item, parent, false);
        }


        ImageView imageIV = rowView.findViewById(R.id.image);
        TextView currTV = rowView.findViewById(R.id.curr);
        TextView currencyTV = rowView.findViewById(R.id.currency);

        imageIV.setImageResource(images[position]);
        currTV.setText(currShort[position]);
        currencyTV.setText(currency[position]);

        return rowView;
    }
}
