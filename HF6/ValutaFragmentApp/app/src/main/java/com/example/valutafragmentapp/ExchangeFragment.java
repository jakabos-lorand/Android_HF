package com.example.valutafragmentapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExchangeFragment extends Fragment {

    private TextView textBuy, textSell;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exchange_fragment, container, false);
        textBuy = view.findViewById(R.id.textBuy);
        textSell = view.findViewById(R.id.textSell);
        return view;
    }

    public void updateRates(double buy, double sell) {
        textBuy.setText(String.format("Cumpara: %.4f RON", buy));
        textSell.setText(String.format("Vinde: %.4f RON", sell));
    }
}
