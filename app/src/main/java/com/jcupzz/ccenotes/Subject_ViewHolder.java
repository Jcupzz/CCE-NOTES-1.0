package com.jcupzz.ccenotes;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.jcupzz.ccenotes.Branch.j;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Subject_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView subject_tv;
    CardView cardView;

    public Subject_ViewHolder(@NonNull final View itemView) {
        super(itemView);
        subject_tv = itemView.findViewById(R.id.subject_tv_id);
        cardView = itemView.findViewById(R.id.subject_CardView_Id);
   cardView.setOnClickListener(this);
    }

        @Override
        public void onClick (View v){
            int o = (int) v.getTag();
            Toast.makeText(v.getContext(), ""+o, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(),MainActivity.class);
            intent.putExtra("key",o);
            v.getContext().startActivity(intent);
        }


}