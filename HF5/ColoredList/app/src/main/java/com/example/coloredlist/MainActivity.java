package com.example.coloredlist;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listItems2;
    ArrayAdapter<String> adapter;

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

        ListView list = findViewById(R.id.list);
        String[] listItems = getResources().getStringArray(R.array.progLanguages);
        listItems2 = new ArrayList<>(Arrays.asList(listItems));

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listItems2);
        list.setAdapter(adapter);
        registerForContextMenu(list);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = item.getItemId();

        ListView listView = findViewById(R.id.list);
        View rowView = listView.getChildAt(info.position - listView.getFirstVisiblePosition());
        TextView textView = rowView.findViewById(android.R.id.text1);

        if(id == R.id.red){
            textView.setTextColor(Color.RED);
        } else if (id == R.id.green){
            textView.setTextColor(Color.GREEN);
        } else if (id == R.id.yellow){
            textView.setTextColor(Color.YELLOW);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sort) {
            Toast.makeText(this, "Sort list", Toast.LENGTH_SHORT).show();
            java.util.Collections.sort(listItems2);
            adapter.notifyDataSetChanged();
            return true;
        } else if (id == R.id.delete) {
            Toast.makeText(this, "Delete list", Toast.LENGTH_SHORT).show();
            listItems2.clear();
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}