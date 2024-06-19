package com.example.estilos_kr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.Spinner1);
        text = findViewById(R.id.Text);

        final String[] nombre = {"Sakura","Bosque","Cielo"};
        int[] estilos = {R.style.Sakura, R.style.Bosque, R.style.Cielo};

        spinner.setAdapter(new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_list_item_1,nombre));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        setTheme(R.style.Sakura);
                        break;
                    case 1:
                        setTheme(R.style.Bosque);
                        break;
                    case 2:
                        setTheme(R.style.Cielo);
                        break;
                    case 3:
                        return;
                }

                text.setText(nombre[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
}