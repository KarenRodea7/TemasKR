package com.example.estilos_kr;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView text;
    Button bot;
    int nuevo;
    private static String TEMA = "tema";

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.Spinner1);
        text = findViewById(R.id.Text);
        bot = findViewById(R.id.Bot);

        final String[] nombre = {"Selecciona un tema","Sakura","Bosque","Cielo"};
        int[] estilos = {R.style.Sakura, R.style.Bosque, R.style.Cielo};

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (!preferences.contains(TEMA)) {
            preferences.edit().putInt(TEMA, R.style.Base_Theme_Estilos_KR).apply();
        }
        int TemaP = preferences.getInt(TEMA, R.style.Base_Theme_Estilos_KR);
        setTheme(TemaP);

        spinner.setAdapter(new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_list_item_1,nombre));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        nuevo = R.style.Base_Theme_Estilos_KR;
                    break;
                    case 1:
                        nuevo = R.style.Sakura;
                        break;
                    case 2:
                        nuevo = R.style.Bosque;
                        break;
                    case 3:
                        nuevo = R.style.Cielo;
                        break;
                    default:
                        return;
                }

                text.setText(nombre[position]);

                int TemaAct = preferences.getInt(TEMA, R.style.Base_Theme_Estilos_KR);
                if(TemaAct != nuevo) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(TEMA, nuevo);
                    editor.apply();

                    recreate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

//    public void Cargar(){
//        int TemaP = preferences.getInt(TEMA, R.style.Base_Theme_Estilos_KR);
//        if(TemaP != nuevo) {
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putInt(TEMA, nuevo);
//            editor.apply();
//
//            recreate();
//        }


}