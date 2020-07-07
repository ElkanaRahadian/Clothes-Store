package com.binus.a2101658224_elkanarahadian_la26_mobi6002;

import android.app.Activity;
import android.os.*;
import android.widget.*;

import java.util.HashMap;
import java.util.ArrayList;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.content.SharedPreferences;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ClothesActivity extends AppCompatActivity {

    private double position = 0;
    private HashMap<String, Object> map = new HashMap<>();
    private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
    private LinearLayout linear1;
    private LinearLayout linear2;
    private TextView textview1;
    private ImageView imageview1;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private Button btnsave;
    private TextView textview3;
    private TextView lbltype;
    private TextView textview5;
    private TextView lblcolor;
    private TextView textview7;
    private TextView lblsize;
    private SharedPreferences files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothes);

        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        textview1 = (TextView) findViewById(R.id.textview1);
        imageview1 = (ImageView) findViewById(R.id.imageview1);
        linear3 = (LinearLayout) findViewById(R.id.linear3);
        linear4 = (LinearLayout) findViewById(R.id.linear4);
        linear5 = (LinearLayout) findViewById(R.id.linear5);
        btnsave = (Button) findViewById(R.id.btnsave);
        textview3 = (TextView) findViewById(R.id.textview3);
        lbltype = (TextView) findViewById(R.id.lbltype);
        textview5 = (TextView) findViewById(R.id.textview5);
        lblcolor = (TextView) findViewById(R.id.lblcolor);
        textview7 = (TextView) findViewById(R.id.textview7);
        lblsize = (TextView) findViewById(R.id.lblsize);
        files = getSharedPreferences("f2", Activity.MODE_PRIVATE);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                if (position == -1) {
                    map = new HashMap<>();
                    map.put("type", lbltype.getText().toString());
                    map.put("color", lblcolor.getText().toString());
                    map.put("size", lblsize.getText().toString());
                    listmap.add(map);
                } else {
                    listmap.get((int) position).put("type", lbltype.getText().toString());
                    listmap.get((int) position).put("color", lblcolor.getText().toString());
                    listmap.get((int) position).put("size", lblsize.getText().toString());
                }
                files.edit().putString("allnotes", new Gson().toJson(listmap)).commit();
                Toast.makeText(getApplicationContext(), "Data Saved...", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        initializeLogic();

    }

    private void initializeLogic() {
        lbltype.setText(getIntent().getStringExtra("type"));
        lblcolor.setText(getIntent().getStringExtra("color"));
        lblsize.setText(getIntent().getStringExtra("size"));
        if (lbltype.getText().toString().equals("Shirt")) {
            if (lblcolor.getText().toString().equals("Red")) {
                imageview1.setImageResource(R.drawable.bajumerah);
            } else {
                if (lblcolor.getText().toString().equals("Green")) {
                    imageview1.setImageResource(R.drawable.bajuhijau);
                } else {
                    if (lblcolor.getText().toString().equals("Blue")) {
                        imageview1.setImageResource(R.drawable.bajubiru);
                    }
                }
            }
        } else {
            if (lbltype.getText().toString().equals("Pants")) {
                if (lblcolor.getText().toString().equals("Red")) {
                    imageview1.setImageResource(R.drawable.celanamerah);
                } else {
                    if (lblcolor.getText().toString().equals("Green")) {
                        imageview1.setImageResource(R.drawable.celanahijau);
                    } else {
                        if (lblcolor.getText().toString().equals("Blue")) {
                            imageview1.setImageResource(R.drawable.celanabiru);
                        }
                    }
                }
            } else {
                if (lbltype.getText().toString().equals("Hat")) {
                    if (lblcolor.getText().toString().equals("Red")) {
                        imageview1.setImageResource(R.drawable.topimerah);
                    } else {
                        if (lblcolor.getText().toString().equals("Green")) {
                            imageview1.setImageResource(R.drawable.topihijau);
                        } else {
                            if (lblcolor.getText().toString().equals("Blue")) {
                                imageview1.setImageResource(R.drawable.topibiru);
                            }
                        }
                    }
                } else {

                }
            }
        }
        if (!files.getString("allnotes", "").equals("")) {
            listmap = new Gson().fromJson(files.getString("allnotes", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
        }
        if (!files.getString("pos", "").equals("")) {
            position = Double.parseDouble(files.getString("pos", ""));
        } else {
            position = -1;
        }
    }

}
