package com.gyk.teameleven.gykteameleven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.gyk.teameleven.gykteameleven.model.Teacher;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Teacher teacher = (Teacher) getIntent().getSerializableExtra("teacher");
    }
}
