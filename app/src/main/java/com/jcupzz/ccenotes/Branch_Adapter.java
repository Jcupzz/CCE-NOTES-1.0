package com.jcupzz.ccenotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Branch_Adapter extends PagerAdapter {
    Context context;

    public Branch_Adapter(Context context, List<Branch_Names> branch_names_list) {
        this.context = context;
        this.branch_names_list = branch_names_list;
    }
    List<Branch_Names> branch_names_list;
    LayoutInflater layoutInflater;


    //LayoutInflater branch_layoutInflater = LayoutInflater.from(branch.getBaseContext());
    //      View branch_view = branch_layoutInflater.inflate(R.layout.branch_elements, parent, false);
    //    return new Branch_ViewHolder(branch_view);

    @Override
    public int getCount() {
        return branch_names_list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        layoutInflater = layoutInflater.from(context);
        View branch_view = layoutInflater.inflate(R.layout.branch_elements, container, false);

        TextView textView;
        textView = branch_view.findViewById(R.id.branch_name_tv_id);
        textView.setText(branch_names_list.get(position).getB_name());
        container.addView(branch_view,0);

        branch_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),""+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),Subject.class);
                intent.putExtra("branch_key",position);
                v.getContext().startActivity(intent);
            }
        });

        return branch_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }


}