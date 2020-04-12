package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {
    ListView listView;
    ListViewAdapter adapter;
    Serializable downloadArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        downloadArray = getIntent().getSerializableExtra("Downloaded");
        adapter = new ListViewAdapter(MainActivity.this, (ArrayList<HashMap<String, String>>) downloadArray);
        listView.setAdapter(adapter);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("position", listView.getFirstVisiblePosition());
        savedInstanceState.putSerializable("array", downloadArray);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        downloadArray = savedInstanceState.getSerializable("array");
        listView.setSelection(savedInstanceState.getInt("position"));
    }
}
