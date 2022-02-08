package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Adapter.WordAdapter;
import Classes.WordClass;


public class NumbersFragment extends Fragment {
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
        words.add( new WordClass("ONE","lutti",R.drawable.number_one,
                R.raw.number_one));
        words.add( new WordClass("two","otiiko",R.drawable.number_two,
                R.raw.number_two));
        words.add( new WordClass("three","tolookosu",R.drawable.number_three,
                R.raw.number_three));
        words.add( new WordClass("four","oyyisa",R.drawable.number_four,
                R.raw.number_four));
        words.add( new WordClass("five","massokka",R.drawable.number_five,
                R.raw.number_five));
        words.add( new WordClass("six","temmokka",R.drawable.number_six,
                R.raw.number_six));
        words.add( new WordClass("seven","kenekaku",R.drawable.number_seven,
                R.raw.number_seven));
        words.add( new WordClass("eight","kawinta",R.drawable.number_eight,
                R.raw.number_eight));
        words.add( new WordClass("nine","wo’e",R.drawable.number_nine,
                R.raw.number_nine));
        words.add( new WordClass("ten","na’aacha",R.drawable.number_ten,
                R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(getActivity(),words);
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