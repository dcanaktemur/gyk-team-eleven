package com.gyk.teameleven.gykteameleven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.gyk.teameleven.gykteameleven.Model.Teacher;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Teacher teacher = (Teacher) getIntent().getSerializableExtra("teacher");
        TextView name,email,description,favoriteTopics,comments;
        RatingBar stars;
        int status;
        ImageView photo;

        //Views
        name = (TextView)findViewById(R.id.nameSurname);
        email = (TextView)findViewById(R.id.email);
        description = (TextView)findViewById(R.id.description);
        favoriteTopics = (TextView)findViewById(R.id.favoriteTopics);
        comments = (TextView)findViewById(R.id.comments);
        photo = findViewById(R.id.avatar);
        stars = (RatingBar)findViewById(R.id.ratingBar);

        //Setters
        name.setText(teacher.getName()+" "+teacher.getSurname());
        email.setText(teacher.getEmail());
        description.setText(teacher.getDescription());
        favoriteTopics.setText(teacher.getFavoriteTopics());
        comments.setText(teacher.getComments());
        Glide.with(this.getClass())
                .load(teacher.getPhotoUrl())
                .into(R.id.avatar);
        stars.setRating(teacher.getStars());

        
    }
}
