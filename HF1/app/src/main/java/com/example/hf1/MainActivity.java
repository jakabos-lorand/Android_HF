package com.example.hf1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        EditText szam1 = findViewById(R.id.szam1);
        EditText szam2 = findViewById(R.id.szam2);
        TextView eredmeny = findViewById(R.id.eredmeny);
        Button osszeadas = findViewById(R.id.osszeadas);
        Button kivonas = findViewById(R.id.kivonas);
        Button szorzas = findViewById(R.id.szorzas);
        Button osztas = findViewById(R.id.osztas);

        osszeadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double result = Double.parseDouble(szam1.getText().toString()) +
                            Double.parseDouble(szam2.getText().toString());
                    eredmeny.setText(Double.toString(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Konverzios hiba!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        kivonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double result = Double.parseDouble(szam1.getText().toString()) -
                            Double.parseDouble(szam2.getText().toString());
                    eredmeny.setText(Double.toString(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Konverzios hiba!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        szorzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double result = Double.parseDouble(szam1.getText().toString()) *
                            Double.parseDouble(szam2.getText().toString());
                    eredmeny.setText(Double.toString(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Konverzios hiba!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        osztas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (szam2.getText().toString().equals("0")) {
                    Toast.makeText(MainActivity.this, "0-val való osztás nem lehetséges!", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        double result = Double.parseDouble(szam1.getText().toString()) /
                                Double.parseDouble(szam2.getText().toString());
                        eredmeny.setText(Double.toString(result));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Konverzios hiba!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}