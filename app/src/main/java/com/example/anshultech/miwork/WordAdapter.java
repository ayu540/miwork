package com.example.anshultech.miwork;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AnshulTech on 10-Dec-17.
 */

public class WordAdapter extends ArrayAdapter<word> {

    private int mColorResourceID;

    public WordAdapter(Activity Context, ArrayList<word> word, int colorResourceID) {
        super(Context, 0, word);
        mColorResourceID= colorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitem = convertView;
        if (listitem == null) {
            listitem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        word currentword = getItem(position);


        TextView listenglishitemview = (TextView) listitem.findViewById(R.id.listitemenglishtextview);
        listenglishitemview.setText(currentword.getmDefaultTranslation());

        TextView listmiwokitemview = (TextView) listitem.findViewById(R.id.listitemmiwoktextview);
        listmiwokitemview.setText(currentword.getmMiwokTranslation());

        ImageView listimageitemview = (ImageView) listitem.findViewById(R.id.listviewimage);
        if(currentword.hasImage()) {

            listimageitemview.setImageResource(currentword.getmImageResourceID());
            listimageitemview.setVisibility(View.VISIBLE);
        }
        else{
            listimageitemview.setVisibility(View.GONE);
        }

        View textContainer = listitem.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        textContainer.setBackgroundColor(color);

        return listitem;
    }

}
