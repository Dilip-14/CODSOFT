package com.example.alarmclock;

// MainActivity.java

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button refreshButton;
    private Button shareButton;
    private Button favoriteButton;

    private SharedPreferences sharedPreferences;
    private static final String PREF_KEY_QUOTE = "favorite_quote";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        refreshButton = findViewById(R.id.refreshButton);
        shareButton = findViewById(R.id.shareButton);
        favoriteButton = findViewById(R.id.favoriteButton);


        displayRandomQuote();


        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayRandomQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shareCurrentQuote();
            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Your quote has been saved successfully", Toast.LENGTH_SHORT).show();
                saveFavoriteQuote();
            }
        });
    }


    private void displayRandomQuote() {
        String[] quotes = {
                "“Every child is an artist; the problem is staying an artist when you grow up” – Pablo Picasso",
                "Don’t think about making art, just get it done. Let everyone else decide if it’s good or bad, whether they love it or hate it. While they are deciding, make even more art.” – Andy Warhol",
                "Art is a collaboration between God and the artist, and the less the artist does the better.” – Andre Gide",
                "Every artist was first an amateur.” – Ralph Waldo Emerson",
                "“I found I could say things with color and shapes that I couldn’t say any other way – things I had no words for.” – Georgia O’Keeffe",
                " “One thing I have learned is that I am not the owner of my talent, I am the manager of it.” - Madonna",
                "If everything was perfect you would never learn and you would never grow.” - Beyonce",
                "‘It’s like if you want something so badly go out and grab, just keep on doing it.” – Ed Sheeran",
                "“I don’t make music for eyes; I make music for ears.” - Adele",
                "“I don’t know where I’m going from here, but I promise it won’t be boring.” – David Bowie",
                " “I didn't fail the test. I just found 100 ways to do it wrong.“ -Benjamin Franklin",
                " “I have learned over the years that when one's mind is made up, this diminishes fear.“ -Rosa Parks",
                "“Self-care is how you take your power back.“ — Lalah Delia",
                "“Being happy never goes out of style.“ — Lilly Pulitzer",
                "“To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.” — Ralph Waldo Emerson",
                " “A dead end is just a good place to turn around.” — Naomi Judd",
                "“Even miracles take a little time.” — The Fairy Godmother, Cinderella",
                "“Find out who you are and do it on purpose.“ — Dolly Parton",
                "“The way I see it, if you want the rainbow, you gotta put up with the rain!” — Dolly Parton",
                "“Say something positive, and you’ll see something positive.“— Jim Thompson",
                "“I never dreamed about success. I worked for it.” — Estée Lauder",
                "“Success is only meaningful and enjoyable if it feels like your own.” — Michelle Obama",
                "“Never let the fear of striking out keep you from playing the game.“— Babe Ruth",


        };


        Random random = new Random();
        int index = random.nextInt(quotes.length);
        String randomQuote = quotes[index];
        quoteTextView.setText(randomQuote);
    }


    private void shareCurrentQuote() {
        String currentQuote = quoteTextView.getText().toString();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, currentQuote);
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent, "Share Qoute"));
    }


    private void saveFavoriteQuote() {
        String favoriteQuote = quoteTextView.getText().toString();

        String currentQuote = quoteTextView.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREF_KEY_QUOTE, currentQuote);
        editor.apply();

    }
}


