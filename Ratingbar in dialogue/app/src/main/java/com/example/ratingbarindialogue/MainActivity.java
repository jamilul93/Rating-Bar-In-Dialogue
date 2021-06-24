package com.example.ratingbarindialogue;

import android.content.DialogInterface;
import android.media.Rating;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button getRating;
    private TextView ratingTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRating = findViewById(R.id.btnGetRating);
        ratingTv = findViewById(R.id.tvRating);

        getRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder ratingDialogue = new AlertDialog.Builder(MainActivity.this);
                final RatingBar ratingBar = new RatingBar(MainActivity.this);

                //ratingbar setting in linear layout declaration
                LinearLayout ratingbarContainingll = new LinearLayout(MainActivity.this);

                //setting rating bar parameters
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                lp.leftMargin = 100;
                lp.topMargin =50;
                ratingBar.setLayoutParams(lp);
                ratingBar.setNumStars(5);
                ratingBar.setStepSize(1);

                //setting rating bar to ll
                ratingbarContainingll.addView(ratingBar);

                //ll setting to dialogue box
                ratingDialogue.setView(ratingbarContainingll);


                ratingDialogue.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double rating = ratingBar.getRating();
                        ratingTv.setText("Current rating "+rating);
                    }
                });
                ratingDialogue.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                ratingDialogue.create();
                ratingDialogue.show();


            }
        });





    }
}