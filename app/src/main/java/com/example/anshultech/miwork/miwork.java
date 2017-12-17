package com.example.anshultech.miwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.nio.file.Files;

public class miwork extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miwork);
        TextView numbersview = (TextView) findViewById(R.id.textviewnumbers);
        TextView famymembersview = (TextView) findViewById(R.id.textviewfamilymembers);
        TextView colorsview = (TextView) findViewById(R.id.textviewcolors);
        TextView phrasesview = (TextView) findViewById(R.id.textviewphrases);

        numbersview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberintent = new Intent(miwork.this, NumbersActivity.class);
                startActivity(numberintent);

            }
        });

        famymembersview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familymembersintent = new Intent(miwork.this, FamilyActivity.class);
                startActivity(familymembersintent);

            }
        });


        colorsview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsintent = new Intent(miwork.this, ColorsActivity.class);
                startActivity(colorsintent);

            }
        });

        phrasesview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesintent = new Intent(miwork.this, PhrasesActivity.class);
                startActivity(phrasesintent);
            }
        });


    }
}
