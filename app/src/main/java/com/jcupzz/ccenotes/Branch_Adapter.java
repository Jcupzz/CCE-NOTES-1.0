package com.jcupzz.ccenotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Branch_Adapter extends RecyclerView.Adapter<Branch_ViewHolder> {
    Branch branch;
    ArrayList<Branch_Names> branch_names_arr;
    public Branch_Adapter(Branch branch,ArrayList<Branch_Names> branch_names)
{
    this.branch = branch;
    branch_names_arr = branch_names;
}


    @NonNull
    @Override
    public Branch_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater branch_layoutInflater = LayoutInflater.from(branch.getBaseContext());
        View branch_view = branch_layoutInflater.inflate(R.layout.branch_elements, parent, false);
        return new Branch_ViewHolder(branch_view);
    }

    @Override
    public void onBindViewHolder(@NonNull Branch_ViewHolder holder, int position) {
        holder.mBranch_tv.setText(branch_names_arr.get(position).getB_name());
    }

    @Override
    public int getItemCount() {
        return branch_names_arr.size();
    }
}
