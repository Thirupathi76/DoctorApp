package com.marolix.doctorapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marolix.doctorapp.ClinicProfileActivity;
import com.marolix.doctorapp.R;

public class ClinicHAdapter extends RecyclerView.Adapter<ClinicHAdapter.MyViewHolder> {

    private String[] clinic_name = {"Rainbow clinic", "Bhushan clinic", "Krishna clinic", "Renew Clinic", "AllisWell clinic"};
    private String[] clinic_address = {"Panjagutta", "Ameerpet", "Kairathabad", "Begumpet", "Mehedipattnam"};
    private String[] clinic_rate = {"4.5", "4.0", "3.8", "4.9", "4.0"};
    private String[] clinic_feedbcks = {"12 reviews", "8 reviews", "9 reviews", "4 reviews", "2 reviews"};
    private String[] clinic_phone;
    private int[] clinic_image = {R.drawable.clinic_1,R.drawable.clinic_2,R.drawable.clinic_3,
    R.drawable.clinic_1,R.drawable.clinic_2};
    private Context context;

    public ClinicHAdapter(Context productActivity) {
        this.context = productActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_clinic, viewGroup, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        myViewHolder.clinic_name.setText(clinic_name[i]);
        myViewHolder.clinic_address.setText(clinic_address[i]);
        myViewHolder.clinic_rate.setText(clinic_rate[i]);
        myViewHolder.clinic_reviews.setText(clinic_feedbcks[i]);

        myViewHolder.clinic_image.setImageResource(clinic_image[i]);
//        myViewHolder.prod_image.setImageResource(clini[i]);


        myViewHolder.clinic_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ClinicProfileActivity.class));
            }
        });

        myViewHolder.book_clinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ClinicProfileActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return clinic_name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView clinic_name, clinic_address, clinic_rate, clinic_reviews, book_clinic;
        CardView clinic_layout;
        ImageView clinic_image, plus, minus;
        int sum;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            clinic_name = itemView.findViewById(R.id.clinic_name);
            clinic_layout = itemView.findViewById(R.id.clinic_layout);
            clinic_address = itemView.findViewById(R.id.clinic_address);
            clinic_rate = itemView.findViewById(R.id.rate_bar);
            clinic_reviews = itemView.findViewById(R.id.clinic_feedback);
            clinic_image = itemView.findViewById(R.id.clinic_image);
            book_clinic = itemView.findViewById(R.id.book_clinic);


        }
    }
}
