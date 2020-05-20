package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import static com.jcupzz.ccenotes.Branch.j;
import static com.jcupzz.ccenotes.StudentDetailsCategory.i;

public class Subject extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter adapters;
    ArrayList<Subject_Names> subject_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setUpRecyclerView();
        String[] cities = getResources().getStringArray(R.array.S2_SUBJECTS_ARRAY);
        subject_names = new ArrayList<Subject_Names>();
        for(int y = 0; y < cities.length; y++) {
            subject_names.add(new Subject_Names(cities[y]));
        }

        adapters = new Subject_Adapter(this,subject_names);
        mRecyclerView.setAdapter(adapters);
    }

    private void setUpRecyclerView() {
        mRecyclerView = findViewById(R.id.subject_recycle_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
