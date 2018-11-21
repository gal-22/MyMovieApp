package com.academy.fundamentals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity implements OnMovieClickListener {

    // UI Views
    RecyclerView moviesRv;

    //Objects/
    ArrayList<MovieModel> movies;
    MoviesViewAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        loadMovies();
        initViews();
        moviesAdapter.notifyDataSetChanged();
    }

    private void initViews() {
        moviesRv = findViewById(R.id.movies_rv);
        moviesRv.setLayoutManager(new LinearLayoutManager(this));
        moviesAdapter = new MoviesViewAdapter(movies, this, this);
        moviesRv.setAdapter(moviesAdapter);
    }

    private void loadMovies() {
        movies = new ArrayList<>();

        MovieModel movie1 = new MovieModel();
        MovieModel movie2 = new MovieModel();
        MovieModel movie3 = new MovieModel();
        MovieModel movie4 = new MovieModel();
        MovieModel movie5 = new MovieModel();
        MovieModel movie6 = new MovieModel();

        movie1.setMovieName("Jurassic World - Fallen Kingdom");
        movie2.setMovieName("The Meg");
        movie3.setMovieName("The First Purge");
        movie4.setMovieName("Deadpool 2");
        movie5.setMovieName("Black Panther");
        movie6.setMovieName("Ocean's Eight");

        movie1.setImageResId(R.drawable.jurrasic_world);
        movie2.setImageResId(R.drawable.the_meg);
        movie3.setImageResId(R.drawable.the_purge);
        movie4.setImageResId(R.drawable.deadpool2);
        movie5.setImageResId(R.drawable.black_panter);
        movie6.setImageResId(R.drawable.ocean);


        movie1.setOverview("Three years after the demise of Jurassic World, a volcanic eruption threatens the remaining dinosaurs on the isla Nublar, so Claire Dearing, the former park manager, recruits Owen Grady to help prevent the extinction of the dinosaurs once again");
        movie2.setOverview("A deep sea submersible pilot revisits his past fears in the Mariana Trench, and accidentally unleashes the seventy foot ancestor of the Great White Shark believed to be extinct");
        movie3.setOverview("To push the crime rate below one percent for the rest of the year, the New Founding Fathers of America test a sociological theory that vents aggression for one night in one isolated community. But when the violence of oppressors meets the rage of the others, the contagion will explode from the trial-city borders and spread across the nation");
        movie4.setOverview("Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life");
        movie5.setOverview("King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war");
        movie6.setOverview("Debbie Ocean, a criminal mastermind, gathers a crew of female thieves to pull off the heist of the century at New York's annual Met Gala");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);

    }
    @Override
    public void onMovieClicked(int itemPosition) {
        if (itemPosition < 0 || itemPosition >= movies.size()) return;
        MovieModel movieModel = movies.get(itemPosition);
        if (movieModel == null || TextUtils.isEmpty(movieModel.getMovieName())) return;
        Toast.makeText(this, movieModel.getMovieName(), Toast.LENGTH_SHORT).show();
    }
}
