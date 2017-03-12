package com.orangelabs.vumetertest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.orangelabs.vumeter.VuMeter;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final VuMeter vmA = (VuMeter)findViewById(R.id.ivA);
        final VuMeter vmB = (VuMeter)findViewById(R.id.ivB);
        final TextView tvA = (TextView)findViewById(R.id.tvA);
        final TextView tvB = (TextView)findViewById(R.id.tvB);
        SeekBar seekBarA = (SeekBar) findViewById(R.id.seekBarA);
        SeekBar seekBarB = (SeekBar) findViewById(R.id.seekBarB);

        tvA.setText(Integer.toString(seekBarA.getProgress()));
        tvB.setText(Integer.toString(seekBarB.getProgress()));


        seekBarA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vmA.setLevel(progress);
                tvA.setText(Integer.toString(progress));
                }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vmB.setLevel(progress);
                tvB.setText(Integer.toString(progress));
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
