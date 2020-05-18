package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Branch extends AppCompatActivity{
RecyclerView mRecyclerView;
RecyclerView.Adapter adapter;
ArrayList<Branch_Names> branch_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        setUpRecyclerView();

        branch_names = new ArrayList<Branch_Names>();
        branch_names.add(new Branch_Names("C.S"));
        branch_names.add(new Branch_Names("E.C"));
        branch_names.add(new Branch_Names("E.E.E"));
        branch_names.add(new Branch_Names("M.E"));
        branch_names.add(new Branch_Names("C.E"));

        adapter = new Branch_Adapter(this,branch_names);
mRecyclerView.setAdapter(adapter);

    }
    private void setUpRecyclerView() {
        mRecyclerView = findViewById(R.id.recycle_branch_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
