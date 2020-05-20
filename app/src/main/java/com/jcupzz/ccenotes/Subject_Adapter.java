package com.jcupzz.ccenotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import static com.jcupzz.ccenotes.Branch.j;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Subject_Adapter extends RecyclerView.Adapter<Subject_ViewHolder> {
    Subject subject;
    ArrayList<Subject_Names> subject_names_arr;

    public Subject_Adapter(Subject subject, ArrayList<Subject_Names> subject_names)
    {
        this.subject = subject;
        subject_names_arr = subject_names;
    }
    @NonNull
    @Override
    public Subject_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater subject_layoutInflater = LayoutInflater.from(subject.getBaseContext());
        View subject_view = subject_layoutInflater.inflate(R.layout.subject_elements, parent, false);
        return new Subject_ViewHolder(subject_view);

    }

    @Override
    public void onBindViewHolder(@NonNull Subject_ViewHolder holder, int position) {
holder.subject_tv.setText(subject_names_arr.get(position).getS_name());
        holder.cardView.setTag(position+1);

    }
    @Override
    public int getItemCount() {
        return subject_names_arr.size();
    }
}
