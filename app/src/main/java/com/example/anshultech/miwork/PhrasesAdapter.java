package com.example.anshultech.miwork;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by AnshulTech on 17-Dec-17.
 */

public class PhrasesAdapter extends Fragment{
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mediaplayercompletion= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new word("Come here.", "әnni'nem", R.raw.phrase_come_here));


        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words,R.color.category_phrases);
        ListView listview = (ListView) rootview.findViewById(R.id.activity_numbers);
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
