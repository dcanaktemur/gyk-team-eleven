package com.gyk.teameleven.gykteameleven;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.database.*;
import com.gyk.teameleven.gykteameleven.model.Teacher;

import java.util.ArrayList;


public class MasterActivity extends Activity implements ListItemClickListener{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_layout);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("teachers");
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.teacherListView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList td = (ArrayList) dataSnapshot.getValue();
                TeacherAdapter adapter = new TeacherAdapter(MasterActivity.this,td,MasterActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onItemClick(Teacher teacher) {
        Intent intent = new Intent(MasterActivity.this,DetailActivity.class);
        intent.putExtra("teacher",teacher);
        startActivity(intent);
    }
}

