package com.gyk.teameleven.gykteameleven;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyk.teameleven.gykteameleven.model.Teacher;

import java.util.ArrayList;
import java.util.Map;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {
    ArrayList teacherList;
    LayoutInflater inflater;
    Context context;
    private ListItemClickListener itemClickListener;

    public TeacherAdapter(Context context, ArrayList<Teacher> teachers, ListItemClickListener listItemClickListener) {
        inflater = LayoutInflater.from(context);
        this.teacherList = teachers;
        this.context = context;
        this.itemClickListener = listItemClickListener;
    }

    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_detail, parent, false);
        TeacherViewHolder holder = new TeacherViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TeacherViewHolder holder, int position) {
        Map<String, Object> selectedTeacher = (Map<String, Object>) teacherList.get(position);
        holder.name.setText(selectedTeacher.get("name") + " " + selectedTeacher.get("surname"));
        holder.topics.setText(selectedTeacher.get("favorite_topics").toString());
        holder.rating.setRating((Long) selectedTeacher.get("stars"));
        Glide.with(context)
                .load(selectedTeacher.get("photo_url"))
                .apply(RequestOptions.circleCropTransform())
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }


    public class TeacherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, topics;
        public ImageView avatar;
        public RatingBar rating;

        public TeacherViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameSurname);
            topics = itemView.findViewById(R.id.favoriteTopics);
            rating = itemView.findViewById(R.id.ratingBar);
            avatar = itemView.findViewById(R.id.avatar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Map<String, Object> teacherMap = (Map<String, Object>) teacherList.get(adapterPosition);
            Teacher item = new Teacher();
            item.setId((Long) teacherMap.get("id"));
            item.setPhotoUrl(teacherMap.get("photo_url").toString());
            item.setComments(teacherMap.get("comments").toString());
            item.setDescription(teacherMap.get("description").toString());
            item.setEmail(teacherMap.get("email").toString());
            item.setFavoriteTopics(teacherMap.get("favorite_topics").toString());
            item.setName(teacherMap.get("name").toString());
            item.setSurname(teacherMap.get("surname").toString());
            item.setStars((Long) teacherMap.get("stars"));
            item.setStatus((Long) teacherMap.get("status"));
            itemClickListener.onItemClick(item);
        }
    }
}
