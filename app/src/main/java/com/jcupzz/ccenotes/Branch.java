package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Branch extends AppCompatActivity{

    ViewPager viewPager;
    Branch_Adapter adapter;
    List<Branch_Names> branch_names;
    public static int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);


        branch_names = new ArrayList<Branch_Names>();
        branch_names.add(new Branch_Names(null));
        branch_names.add(new Branch_Names("Computer Science\nEngineering"));
        branch_names.add(new Branch_Names("Electrical\nEngineering"));
        branch_names.add(new Branch_Names("Electronics\nEngineering"));
        branch_names.add(new Branch_Names("Mechanical\nEngineering"));
        branch_names.add(new Branch_Names("Civil\nEngineering"));
        branch_names.add(new Branch_Names(null));

        adapter = new Branch_Adapter(this, branch_names);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(120, 0, 120, 0);
        viewPager.setCurrentItem(1);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==6)
                {
                    viewPager.setCurrentItem(1);

                }
                if(position==0)
                {
                    viewPager.setCurrentItem(5);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
