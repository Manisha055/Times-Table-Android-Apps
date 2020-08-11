package com.example.timestables;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    public void  generate(int timetblenumber){

        ArrayList<String> arrayList= new ArrayList<>();
        int j;
        for (j=1; j<=10; j++){
            arrayList.add(Integer.toString(j*timetblenumber));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        SeekBar seekBar=findViewById(R.id.seekBar);
        int max=20;
        int startingposition=0;

        seekBar.setMax(max);
        seekBar.setProgress(startingposition);
        generate(startingposition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timetblenumber;
                if (progress < min) {
                    timetblenumber = min;
                    seekBar.setProgress(min);
                } else {
                    timetblenumber = progress;
                }
                Log.i("Seekbar Value", Integer.toString(timetblenumber));
                generate(timetblenumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}