package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import static com.jcupzz.ccenotes.Branch.j;
import static com.jcupzz.ccenotes.StudentDetailsCategory.i;

public class Subject extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter adapters;
    ArrayList<Subject_Names> subject_names;
    public static int k=0;
String[] var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        Intent intent = getIntent();
        k = intent.getIntExtra("branch_key",0);
        if(i==2)
        {
            var = getResources().getStringArray(R.array.S2_SUBJECTS_ARRAY);
        }
        if(i==4&&k==1)
        {
            var = getResources().getStringArray(R.array.S4_CSE_ARRAY);
        }
        if(i==6&&k==1)
        {
            var = getResources().getStringArray(R.array.S6_CSE_ARRAY);
        }
        if(i==8&&k==1)
        {
            var = getResources().getStringArray(R.array.S8_CSE_ARRAY);
        }

        setUpRecyclerView();
        subject_names = new ArrayList<Subject_Names>();
        for(int y = 0; y < var.length; y++) {
            subject_names.add(new Subject_Names(var[y]));
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
