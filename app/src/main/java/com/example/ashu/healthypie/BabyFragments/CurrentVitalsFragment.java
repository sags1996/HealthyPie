package com.example.ashu.healthypie.BabyFragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.ashu.healthypie.BabyActivity;
import com.example.ashu.healthypie.JsonParser;
import com.example.ashu.healthypie.NetworkUtility;
import com.example.ashu.healthypie.R;

import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;

public class CurrentVitalsFragment extends android.support.v4.app.Fragment {
    SeekBar humSeekBar,tempSeekBar;
    HashMap<String, String> mdata;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final URL DetailSearchUrl = NetworkUtility.buildUrl();
        new DetailQueryTask().execute(DetailSearchUrl);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_baby_current_vitals,null);


        humSeekBar = (SeekBar)v.findViewById(R.id.humseekbar);
        tempSeekBar=v.findViewById(R.id.tempseekbar);


        humSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {


            }

        });/*
        ImageView img = (ImageView)v.findViewById(R.id.crying_gif);
        Glide.with(this).load("https://www.picgifs.com/baby-graphics/laughing/baby-graphics-laughing-658518")
                .into(img);
       *//* Glide.with(getContext())
                .load("https://www.picgifs.com/baby-graphics/laughing/baby-graphics-laughing-658518").as
                .into(img);
        return inflater.inflate(R.layout.fragment_baby_current_vitals,null);*//*

        *//*GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img);
        Glide.with(this).load(R.raw.sample_gif).into(imageViewTarget);*//*
*/
        return inflater.inflate(R.layout.fragment_baby_current_vitals,null);

    }



    private class DetailQueryTask extends AsyncTask<URL, Void, HashMap<String, String>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected HashMap<String, String> doInBackground(URL... params) {
            URL searchUrl = params[0];

            try {
                if (BabyActivity.InternetStatus == true) {
                    String DetailSearchResults = NetworkUtility.getResponseFromHttpUrl(searchUrl);
                    mdata = JsonParser.getJsonData(DetailSearchResults);

                } else
                    mdata = new HashMap<>();
            } catch (UnknownHostException e) {
                mdata = new HashMap<>();
            } catch (Exception e) {
                e.printStackTrace();
                mdata = new HashMap<>();
            }
            return mdata;

        }

        @Override
        protected void onPostExecute(HashMap<String, String> data) {

            if (data.isEmpty())
                    Toast.makeText(getActivity(),"Data Fetched",Toast.LENGTH_LONG).show();
            else {
                showDetails(data);

            }
        }
    }

    public void showDetails(HashMap<String, String> data) {


       Toast.makeText(getActivity(),"Temp: "+data.get("temp")+" Hum: "+data.get("hum"),Toast.LENGTH_LONG).show();

    }
}

