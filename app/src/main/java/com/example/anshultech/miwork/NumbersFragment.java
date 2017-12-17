package com.example.anshultech.miwork;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {


    public NumbersFragment() {
        // Required empty public constructor

    }

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mediaplayercompletion= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new word("two", "ottiko", R.drawable.number_two, R.raw.number_two));
        words.add(new word("three", "tolookusu", R.drawable.number_three, R.raw.number_three));
        words.add(new word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new word("five", "massoka", R.drawable.number_five, R.raw.number_five));
        words.add(new word("six", "temmoka", R.drawable.number_six, R.raw.number_six));
        words.add(new word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));


        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
        ListView listview = (ListView) rootView.findViewById(R.id.activity_numbers);
        listview.setAdapter(itemsAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();
                word wordClassVariable = words.get(i);

                mMediaPlayer = MediaPlayer.create(getActivity(), wordClassVariable.getmMusicResourceID());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mediaplayercompletion);

            }

        });

        return rootView;
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
