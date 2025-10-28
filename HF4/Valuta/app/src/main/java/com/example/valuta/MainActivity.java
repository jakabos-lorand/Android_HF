package com.example.valuta;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView myList = findViewById(R.id.listView);
        String[] currShortList = getResources().getStringArray(R.array.currencyShort);
        String[] currList = getResources().getStringArray(R.array.currencies);

        CustomListViewAdapter myAdapter = new CustomListViewAdapter(this, currShortList, currList, imageArray, cumpList, vindList);
        myList.setAdapter(myAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myAdapter.setVisibility(position);
            }
        });
    }
}