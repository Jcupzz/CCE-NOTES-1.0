package com.jcupzz.ccenotes;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Branch_ViewHolder extends RecyclerView.ViewHolder{

CardView mBranch_CardView;
TextView mBranch_tv;


    public Branch_ViewHolder(@NonNull View itemView) {
        super(itemView);



        mBranch_tv = itemView.findViewById(R.id.branch_name_tv_id);
        mBranch_CardView = itemView.findViewById(R.id.branch_card_id);
        mBranch_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                String branch_tv_name_holder = mBranch_tv.getText().toString();
                Toast.makeText(v.getContext(),"At position = "+pos+" "+branch_tv_name_holder,Toast.LENGTH_SHORT).show();
            }
        });



    }

}
