package com.example.ashu.healthypie;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class liveaudioadapter extends ArrayAdapter<myWord> {


    public  liveaudioadapter(Activity context, ArrayList<myWord> word){
        super(context,0, (List<myWord>) word);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        myWord currentWord=getItem(position);

        TextView tvMiwok =(TextView)listItemView.findViewById(R.id.textv);
        tvMiwok.setText(currentWord.getMiwokTranslation());
       // TextView tvDefault=(TextView)listItemView.findViewById(R.id.tvDefault);
       // tvDefault.setText(currentWord.getDefaultTranslation());

        ImageView iconView=(ImageView)listItemView.findViewById(R.id.imagev);
        iconView.setImageResource(currentWord.getImgSrc());
        return listItemView;
    }
}