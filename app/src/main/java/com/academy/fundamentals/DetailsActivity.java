package com.academy.fundamentals;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    // UI Views
    Button movieTrailerBtn;

    // Constants
    private static final String URL = "https://www.youtube.com/watch?v=QwievZ1Tx-8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initViews();
    }

    private void initViews() {
        movieTrailerBtn = findViewById(R.id.movie_trailer_btn);
        movieTrailerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.movie_trailer_btn) {
            openTrailer();
        }
    }

    public void openTrailer() {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, URL);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
