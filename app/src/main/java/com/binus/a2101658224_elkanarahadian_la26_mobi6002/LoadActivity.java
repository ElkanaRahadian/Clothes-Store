package com.binus.a2101658224_elkanarahadian_la26_mobi6002;

import android.app.Activity;
import android.content.Context;
import android.os.*;

import java.util.ArrayList;
import java.util.HashMap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ListView;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LoadActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();

    private LinearLayout linear1;
    private LinearLayout linear2;
    private TextView textview1;
    private ListView listview2;

    private SharedPreferences files;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load);

        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        textview1 = (TextView) findViewById(R.id.textview1);
        listview2 = (ListView) findViewById(R.id.listview2);
        files = getSharedPreferences("f2", Activity.MODE_PRIVATE);
    }

    @Override
    public void onStart() {
        super.onStart();
        files.edit().putString("pos", "").commit();
        if (!files.getString("allnotes", "").equals("")) {
            listmap = new Gson().fromJson(files.getString("allnotes", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
            listview2.setAdapter(new Listview2Adapter(listmap));
            ((BaseAdapter) listview2.getAdapter()).notifyDataSetChanged();
        }
    }

    public class Listview2Adapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
            _data = _arr;
        }

        @Override
        public int getCount() {
            return _data.size();
        }

        @Override
        public HashMap<String, Object> getItem(int _index) {
            return _data.get(_index);
        }

        @Override
        public long getItemId(int _index) {
            return _index;
        }


        @Override
        public View getView(final int _position, View _view, ViewGroup _viewGroup) {
            LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View _v = _view;
            if (_v == null) {
                _v = _inflater.inflate(R.layout.loadview, null);
            }

            final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
            final LinearLayout linear10 = (LinearLayout) _v.findViewById(R.id.linear10);
            final LinearLayout linear11 = (LinearLayout) _v.findViewById(R.id.linear11);
            final LinearLayout linear12 = (LinearLayout) _v.findViewById(R.id.linear12);
            final LinearLayout linear14 = (LinearLayout) _v.findViewById(R.id.linear14);
            final LinearLayout linear16 = (LinearLayout) _v.findViewById(R.id.linear16);
            final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);
            final LinearLayout linear18 = (LinearLayout) _v.findViewById(R.id.linear18);
            final ImageView imageview3 = (ImageView) _v.findViewById(R.id.imageview3);
            final TextView textview3 = (TextView) _v.findViewById(R.id.textview3);
            final LinearLayout linear19 = (LinearLayout) _v.findViewById(R.id.linear19);
            final TextView lbltype = (TextView) _v.findViewById(R.id.lbltype);
            final TextView textview4 = (TextView) _v.findViewById(R.id.textview4);
            final LinearLayout linear20 = (LinearLayout) _v.findViewById(R.id.linear20);
            final TextView lblcolor = (TextView) _v.findViewById(R.id.lblcolor);
            final TextView textview5 = (TextView) _v.findViewById(R.id.textview5);
            final LinearLayout linear21 = (LinearLayout) _v.findViewById(R.id.linear21);
            final TextView lblsize = (TextView) _v.findViewById(R.id.lblsize);

            lbltype.setText(listmap.get((int) _position).get("type").toString());
            lblcolor.setText(listmap.get((int) _position).get("color").toString());
            lblsize.setText(listmap.get((int) _position).get("size").toString());
            if (lbltype.getText().toString().equals("Shirt")) {
                if (lblcolor.getText().toString().equals("Red")) {
                    imageview3.setImageResource(R.drawable.bajumerah);
                } else {
                    if (lblcolor.getText().toString().equals("Green")) {
                        imageview3.setImageResource(R.drawable.bajuhijau);
                    } else {
                        if (lblcolor.getText().toString().equals("Blue")) {
                            imageview3.setImageResource(R.drawable.bajubiru);
                        }
                    }
                }
            } else {
                if (lbltype.getText().toString().equals("Pants")) {
                    if (lblcolor.getText().toString().equals("Red")) {
                        imageview3.setImageResource(R.drawable.celanamerah);
                    } else {
                        if (lblcolor.getText().toString().equals("Green")) {
                            imageview3.setImageResource(R.drawable.celanahijau);
                        } else {
                            if (lblcolor.getText().toString().equals("Blue")) {
                                imageview3.setImageResource(R.drawable.celanabiru);
                            }
                        }
                    }
                } else {
                    if (lbltype.getText().toString().equals("Hat")) {
                        if (lblcolor.getText().toString().equals("Red")) {
                            imageview3.setImageResource(R.drawable.topimerah);
                        } else {
                            if (lblcolor.getText().toString().equals("Green")) {
                                imageview3.setImageResource(R.drawable.topihijau);
                            } else {
                                if (lblcolor.getText().toString().equals("Blue")) {
                                    imageview3.setImageResource(R.drawable.topibiru);
                                }
                            }
                        }
                    }
                }
            }

            return _v;
        }
    }


}
