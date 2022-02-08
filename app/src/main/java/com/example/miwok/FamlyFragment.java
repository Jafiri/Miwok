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


public class FamlyFragment extends Fragment {

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

        words.add (new WordClass("father","әpә",
                R.drawable.family_father,R.raw.family_father));
        words.add (new WordClass("mother","әṭa",
                R.drawable.family_mother,R.raw.family_mother));
        words.add (new WordClass("son","angsi",
                R.drawable.family_son,R.raw.family_son));
        words.add (new WordClass("daughter","tune",
                R.drawable.family_daughter,R.raw.family_daughter));
        words.add (new WordClass("older brother","taachi",
                R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add (new WordClass("younger brother","chalitti",
                R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add (new WordClass("older sister","teṭe",
                R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add (new WordClass("younger sister","kolliti",
                R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add (new WordClass("grandmother","ama",
                R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add (new WordClass("grandfather","paapa",
                R.drawable.family_grandfather,R.raw.family_grandfather));

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
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}