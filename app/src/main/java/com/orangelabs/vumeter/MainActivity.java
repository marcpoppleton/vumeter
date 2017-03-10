package com.orangelabs.vumeter;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends Activity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("TEST",String.format("progress %d",progress));
                switch (progress) {
                    case 0:
                        iv.setImageDrawable(getDrawable(R.drawable.step_0_vector_anim));
                        break;
                    case 1:
                        iv.setImageDrawable(getDrawable(R.drawable.step_1_vector_anim));
                        break;
                    case 2:
                        iv.setImageDrawable(getDrawable(R.drawable.step_2_vector_anim));
                        break;
                    case 3:
                        iv.setImageDrawable(getDrawable(R.drawable.step_3_vector_anim));
                        break;
                    case 4:
                        iv.setImageDrawable(getDrawable(R.drawable.step_4_vector_anim));
                        break;
                    case 5:
                        iv.setImageDrawable(getDrawable(R.drawable.step_5_vector_anim));
                        break;
                    case 6:
                        iv.setImageDrawable(getDrawable(R.drawable.step_6_vector_anim));
                        break;
                    case 7:
                        iv.setImageDrawable(getDrawable(R.drawable.step_7_vector_anim));
                        break;
                    case 8:
                        iv.setImageDrawable(getDrawable(R.drawable.step_8_vector_anim));
                        break;
                    case 9:
                        iv.setImageDrawable(getDrawable(R.drawable.full_vector_anim));
                        break;

                }
                Drawable drawable = iv.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }

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
