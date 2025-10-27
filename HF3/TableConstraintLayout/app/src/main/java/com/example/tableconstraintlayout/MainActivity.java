package com.example.tableconstraintlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etCode, etName, etPrice;
    private Button btnAdd, btnCancel, btnShow;
    private TextView tvProducts;

    private ArrayList<Product> prodList = new ArrayList<>();

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

        etCode = findViewById(R.id.productCode);
        etName = findViewById(R.id.productName);
        etPrice = findViewById(R.id.productPrice);
        btnAdd = findViewById(R.id.add);
        btnCancel = findViewById(R.id.cancel);
        btnShow = findViewById(R.id.showButton);
        tvProducts = findViewById(R.id.productList);

        setTitle("TableLayout2");

        btnAdd.setOnClickListener(v -> {
            String code = etCode.getText().toString();
            String name = etName.getText().toString();
            String priceStr = etPrice.getText().toString();

            if (code.isEmpty() || name.isEmpty() || priceStr.isEmpty()) {
                Toast.makeText(this, "Adj meg minden információt!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double price = Double.parseDouble(priceStr);

                Product prod = new Product(code, name, price);
                prodList.add(prod);

                Toast.makeText(this, "Termék hozzáadva.", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Számot adj meg árként!", Toast.LENGTH_SHORT).show();
            }

        });

        btnCancel.setOnClickListener(v -> {
            etCode.setText("");
            etName.setText("");
            etPrice.setText("");
        });

        btnShow.setOnClickListener(v -> {
            if (prodList.isEmpty()) {
                tvProducts.setText("Üres a lista.");
                return;
            }

            StringBuilder list = new StringBuilder();
            for (Product prod : prodList) {
                list.append(prod.toString()).append("\n");
            }
            tvProducts.setText(list.toString());
        });
    }
}