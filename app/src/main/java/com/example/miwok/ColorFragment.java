package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Adapter.WordAdapter;
import Classes.WordClass;


public class ColorFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootview = inflater.inflate(R.layout.word_list, container, false);
        ListView listView = (ListView) rootview.findViewById(R.id.list_View);

        final ArrayList<WordClass> words = new ArrayList<WordClass>();


        // short code
        words.add( new WordClass("red","weṭeṭṭi",R.drawable.color_red,
                R.raw.color_red));
        words.add( new WordClass("green","chokokki",R.drawable.color_green,
                R.raw.color_green));
        words.add( new WordClass("brown","ṭakaakki",R.drawable.color_brown,
                R.raw.color_brown));
        words.add( new WordClass("gray","ṭopoppi",R.drawable.color_gray,
                R.raw.color_gray));
        words.add( new WordClass("black","kululli",R.drawable.color_black,
                R.raw.color_black));
        words.add( new WordClass("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow));
        words.add( new WordClass("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow));
        words.add( new WordClass("white","kelelli",R.drawable.color_white,
                R.raw.color_white));

        WordAdapter adapter = new WordAdapter (getActivity(),words);
        // GridView gridView = (GridView) findViewById(R.id.list) ;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WordClass word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(getActivity(),word.getmMediaResource());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });
        return rootview;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }
    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
