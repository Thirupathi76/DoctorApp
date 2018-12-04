package com.marolix.doctorapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marolix.doctorapp.DoctorsClinicActivity;
import com.marolix.doctorapp.R;

public class TestsAdapter extends RecyclerView.Adapter<TestsAdapter.ViewHolderClass> {
    Context context;
    String[] specialities;

    public TestsAdapter(Context context) {
        this.specialities = context.getResources().getStringArray(R.array.tests_array);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_specialities, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolder, int i) {
        viewHolder.txt1.setText(specialities[i]);
        viewHolder.txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, DoctorsClinicActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return specialities.length;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView txt1;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt_speciality);
            //itemView=imageView.findViewById(R.id.img);
        }

    }
}