package com.example.ashu.healthypie.BabyFragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ashu.healthypie.R;
import com.example.ashu.healthypie.liveaudioadapter;
import com.example.ashu.healthypie.myWord;

import java.util.ArrayList;

public class LiveAudioFragment extends Fragment {
    ListView listview;
    ArrayList<myWord> word ;
    FloatingActionButton b;
  /*  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_live_audio);
        ArrayList<myWord> word = new ArrayList<myWord>();

        word.add(new myWord("Lutti", "One", R.drawable.one));
        word.add(new myWord("Otiiko", "Two", R.drawable.two));
        word.add(new myWord("Tolookosu", "Three", R.drawable.three));
        word.add(new myWord("Oyyisa", "Four", R.drawable.four));
        word.add(new myWord("Massokka", "Five", R.drawable.five));
        word.add(new myWord("Temmokka", "Six", R.drawable.six));
        word.add(new myWord("Kenekaku", "Seven", R.drawable.seven));
        word.add(new myWord("Kawinta", "Eight", R.drawable.eight));
        word.add(new myWord("Wo'e", "Nine", R.drawable.nine));
        word.add(new myWord("Na'accha", "Ten", R.drawable.ten));

      liveaudioadapter itemsAdapter = new liveaudioadapter(LiveAudioFragment.this, word);
        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(itemsAdapter);
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_live_audio,null);
        listview=v.findViewById(R.id.mobile_list);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        word = new ArrayList<myWord>();
        word.add(new myWord("Name", "One", R.drawable.speak2));
        word.add(new myWord("Name", "Two", R.drawable.speak2));
        inflateList(word);

        b=view.findViewById(R.id.addUser);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                word.add(new myWord("Name", "One", R.drawable.speak2));
                inflateList(word);
            }
        });

    }

    private void inflateList(ArrayList<myWord> word) {
        liveaudioadapter itemsAdapter = new liveaudioadapter(getActivity(), word);
        listview.setAdapter(itemsAdapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Uri phoneCall = Uri.fromParts("sip", "ayush9398" + "@" + "sip.linphone.org", "");
        Intent caller = new Intent(Intent.ACTION_CALL, phoneCall);
        startActivity(caller);


    }
}
