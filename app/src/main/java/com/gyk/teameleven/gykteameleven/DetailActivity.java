package com.gyk.teameleven.gykteameleven;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyk.teameleven.gykteameleven.model.Teacher;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Teacher teacher = (Teacher) getIntent().getSerializableExtra("teacher");

        TextView name, email, description, favoriteTopics, comments;
        RatingBar stars;
        ImageView photo;
        ImageButton callButton = findViewById(R.id.callButton);

        //Views
        name = findViewById(R.id.nameSurname);
        email = findViewById(R.id.email);
        description = findViewById(R.id.description);
        favoriteTopics = findViewById(R.id.favoriteTopics);
        comments = findViewById(R.id.comments);
        photo = findViewById(R.id.avatar);
        stars = findViewById(R.id.ratingBar);

        //Setters
        name.setText(teacher.getName() + " " + teacher.getSurname());
        email.setText(teacher.getEmail());
        description.setText(teacher.getDescription());
        favoriteTopics.setText(teacher.getFavoriteTopics());
        comments.setText(teacher.getComments());
        Glide.with(this)
                .load(teacher.getPhotoUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(photo);
        stars.setRating(teacher.getStars());

        if(teacher.getStatus() == 0){
            callButton.setEnabled(false);
        }
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });

    }
}
