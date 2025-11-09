package com.example.valutafragmentapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnCurrencySelectedListener {

    private static final String TAG_LIST_FRAGMENT = "list_fragment";
    private static final String TAG_EXCHANGE_FRAGMENT = "exchange_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_list, new ListFragment(), TAG_LIST_FRAGMENT)
                    .replace(R.id.fragment_exchange, new ExchangeFragment(), TAG_EXCHANGE_FRAGMENT)
                    .commit();
        }
    }

    @Override
    public void onCurrencySelected(double buy, double sell) {
        ExchangeFragment exchangeFragment = (ExchangeFragment)
                getSupportFragmentManager().findFragmentByTag(TAG_EXCHANGE_FRAGMENT);

        if (exchangeFragment != null) {
            if (exchangeFragment.getView() != null) {
                exchangeFragment.updateRates(buy, sell);
            }
        }
    }
}