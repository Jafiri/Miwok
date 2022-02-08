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


public class PhrasesFragment extends Fragment {
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

        words.add(new WordClass("Where are you going?","minto wuksus",
                R.raw.phrase_where_are_you_going));
        words.add(new WordClass("What is your name?","tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        words.add(new WordClass("My name is...", "oyaaset...",
                R.raw.phrase_my_name_is));
        words.add(new WordClass("How are you feeling?","michәksәs?",
                R.raw.phrase_how_are_you_feeling));
        words.add(new WordClass("I’m feeling good.","kuchi achit",
                R.raw.phrase_im_feeling_good));
        words.add(new WordClass("Are you coming?","әәnәs'aa?",
                R.raw.phrase_are_you_coming));
        words.add(new WordClass("Yes, I’m coming.","hәә’ әәnәm",
                R.raw.phrase_yes_im_coming));
        words.add(new WordClass("I’m coming.","әәnәm",
                R.raw.phrase_im_coming));
        words.add(new WordClass("Let’s go.","yoowutis",
                R.raw.phrase_lets_go));
        words.add(new WordClass("Come here.","әnni'nem",
                R.raw.phrase_come_here));


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
    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {

            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}