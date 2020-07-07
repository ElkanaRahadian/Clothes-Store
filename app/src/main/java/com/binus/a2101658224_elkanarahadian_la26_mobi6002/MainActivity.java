package com.binus.a2101658224_elkanarahadian_la26_mobi6002;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double number = 0;

    private ArrayList<String> Type = new ArrayList<>();
    private ArrayList<String> Color = new ArrayList<>();
    private ArrayList<String> Size = new ArrayList<>();

    private LinearLayout linear1;
    private LinearLayout linear2;
    private TextView textview1;
    private TextView textview2;
    private Spinner sptype;
    private TextView textview3;
    private Spinner spcolor;
    private TextView textview4;
    private Spinner spsize;
    private Button btnview;
    private Button load;

    private Intent l = new Intent();
    private SharedPreferences files;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        textview1 = (TextView) findViewById(R.id.textview1);
        textview2 = (TextView) findViewById(R.id.textview2);
        sptype = (Spinner) findViewById(R.id.sptype);
        textview3 = (TextView) findViewById(R.id.textview3);
        spcolor = (Spinner) findViewById(R.id.spcolor);
        textview4 = (TextView) findViewById(R.id.textview4);
        spsize = (Spinner) findViewById(R.id.spsize);
        btnview = (Button) findViewById(R.id.btnview);
        load = (Button) findViewById(R.id.load);

        files = getSharedPreferences("f2", Activity.MODE_PRIVATE);

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                if (!Type.get((int) (sptype.getSelectedItemPosition())).equals("Pick a type")) {
                    if (!Color.get((int) (spcolor.getSelectedItemPosition())).equals("Pick a color")) {
                        if (!Size.get((int) (spsize.getSelectedItemPosition())).equals("Pick a size")) {
                            l.setClass(getApplicationContext(), ClothesActivity.class);
                            l.putExtra("type", Type.get((int) (sptype.getSelectedItemPosition())));
                            l.putExtra("color", Color.get((int) (spcolor.getSelectedItemPosition())));
                            l.putExtra("size", Size.get((int) (spsize.getSelectedItemPosition())));
                            startActivity(l);
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Choose the Size!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Choose the Color!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please Choose the Type!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                files.edit().putString("pos", "").commit();
                if (!files.getString("allnotes", "").equals("")) {
                    l.setClass(getApplicationContext(), LoadActivity.class);
                    startActivity(l);
                } else {
                    Toast.makeText(getApplicationContext(), "No Data Saved!", Toast.LENGTH_LONG).show();
                }
            }
        });

        initializeLogic();

    }

    private void initializeLogic() {
        Type.add("Pick a type");
        Type.add("Shirt");
        Type.add("Pants");
        Type.add("Hat");
        Color.add("Pick a color");
        Color.add("Red");
        Color.add("Green");
        Color.add("Blue");
        Size.add("Pick a size");
        Size.add("S");
        Size.add("M");
        Size.add("L");
        Size.add("XL");
        sptype.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Type));
        spcolor.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Color));
        spsize.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Size));
    }

}
