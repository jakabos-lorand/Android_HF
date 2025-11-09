package com.example.valutafragmentapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    private OnCurrencySelectedListener listener;

    String[] currShortList;
    String[] currList;
    Integer[] imageArray = {
            R.drawable.eur,
            R.drawable.usd,
            R.drawable.gbp,
            R.drawable.aud,
            R.drawable.cad,
            R.drawable.chf,
            R.drawable.dkk,
            R.drawable.huf
    };

    Double[] cumpList = {4.4100, 3.9750, 6.1250, 2.9600, 3.0950, 4.2300, 0.5850, 0.0136};
    Double[] vindList = {4.5500, 4.1450, 6.3550, 3.0600, 3.2650, 4.3300, 0.6150, 0.0146};

    public interface OnCurrencySelectedListener {
        void onCurrencySelected(double buy, double sell);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnCurrencySelectedListener) {
            listener = (OnCurrencySelectedListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnCurrencySelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);

        currShortList = getResources().getStringArray(R.array.currencyShort);
        currList = getResources().getStringArray(R.array.currencies);

        ListView myList = view.findViewById(R.id.currency_list_view);

        CustomListViewAdapter adapter = new CustomListViewAdapter(
                requireActivity(),
                currShortList,
                currList,
                imageArray
        );
        myList.setAdapter(adapter);

        myList.setOnItemClickListener((AdapterView<?> parent, View v, int position, long id) -> {
            if (listener != null) {
                listener.onCurrencySelected(cumpList[position], vindList[position]);
            }
        });

        return view;
    }
}
