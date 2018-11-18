package com.gyk.teameleven.gykteameleven;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.gyk.teameleven.gykteameleven.Model.Teacher;
import java.util.ArrayList;
import java.util.Map;

public class TeacherAdapter extends RecyclerView.Adapter<MyViewHolder>
{
    ArrayList teacherList;
    LayoutInflater inflater;
    Context context;

    public TeacherAdapter(Context context, ArrayList<Teacher> teachers){
        inflater = LayoutInflater.from(context);
        this.teacherList = teachers;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_detail, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Map<String,Object> selectedTeacher = (Map<String, Object>) teacherList.get(position);
        holder.name.setText(selectedTeacher.get("name")+" "+selectedTeacher.get("surname"));
        holder.topics.setText(selectedTeacher.get("favorite_topics").toString());
        holder.rating.setRating((Long)selectedTeacher.get("stars"));
        Glide.with(context)
                .load(selectedTeacher.get("photo_url"))
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }
}
