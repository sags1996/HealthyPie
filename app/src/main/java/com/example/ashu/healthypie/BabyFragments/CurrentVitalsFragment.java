package com.example.ashu.healthypie.BabyFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ashu.healthypie.R;

public class CurrentVitalsFragment extends android.support.v4.app.Fragment {
    SeekBar seekBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_baby_current_vitals,null);


        seekBar = (SeekBar)v.findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {


            }

        });
        ImageView img = (ImageView)v.findViewById(R.id.crying_gif);
        Glide.with(getContext())
                .load("https://www.picgifs.com/baby-graphics/laughing/baby-graphics-laughing-658518")
                .into(img);
        return inflater.inflate(R.layout.fragment_baby_current_vitals,null);

    }

}

