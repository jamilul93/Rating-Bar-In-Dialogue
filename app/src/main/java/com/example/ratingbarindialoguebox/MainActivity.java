package com.example.ratingbarindialoguebox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button getRating;
    private TextView tvRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRating = findViewById(R.id.btnGetRating);
        tvRating = findViewById(R.id.tvRating);

        getRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder ratingDialogue = new AlertDialog.Builder(MainActivity.this);
                final RatingBar ratingBar = new RatingBar(MainActivity.this);
                LinearLayout ratingBarContainer = new LinearLayout(MainActivity.this);

                //ratingbar properties set
                LinearLayout.LayoutParams lp =new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                lp.topMargin = 50;
                lp.leftMargin = 100;
                ratingBar.setLayoutParams(lp);
                ratingBar.setNumStars(5);
                ratingBar.setStepSize(1);

                ratingBarContainer.addView(ratingBar);
                ratingDialogue.setView(ratingBarContainer);
                ratingDialogue.setTitle("Add Rating");

                ratingDialogue.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double rating = ratingBar.getRating();
                        tvRating.setText("Rating is: "+rating);
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