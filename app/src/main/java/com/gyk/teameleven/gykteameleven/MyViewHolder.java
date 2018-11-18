package com.gyk.teameleven.gykteameleven;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView name,topics;
    public ImageView avatar;
    public RatingBar rating;

    public MyViewHolder(View itemView){
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.nameSurname);
        topics = (TextView) itemView.findViewById(R.id.favoriteTopics);
        rating = (RatingBar) itemView.findViewById(R.id.ratingBar);
        avatar = itemView.findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View v) {
        //detail activity gecisi
    }
}