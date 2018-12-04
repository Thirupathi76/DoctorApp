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

import com.marolix.doctorapp.DoctorProfileActivity;
import com.marolix.doctorapp.R;

public class DoctorsVAdapter extends RecyclerView.Adapter<DoctorsVAdapter.MyViewHolder> {

    private String[] doctorsname = {"Hari Kishan", "Kamal Lahoti", "Veera Reddy", "Bangari Sami", "Srinivas Agurla",
            "Praveen Kumar", "Kumaraswamy Iyer", "Veera Reddy", "Bangari Sami", "Sameer Fazal"};
    private String[] doctorsVisits = {"Panjagutta", "Ameerpet", "Kairathabad", "Begumpet", "Mehedipattnam",
            "Panjagutta", "Yousufguda", "ESI", "BasheerBagh", "SR Nagar"};
    private String[] doctorsrate = {"4.2", "4.3", "3.9", "4.9", "4.0","4.2", "4.3", "3.9", "4.9", "4.0"};
    private String[] doctorsfeedbcks = {"12 reviews", "8 reviews", "9 reviews", "4 reviews", "2 reviews",
            "12 reviews", "8 reviews", "9 reviews", "4 reviews", "2 reviews"};
    private String[] doctorsphone;
    private int[] doctorsimage = {R.drawable.doctor_1,R.drawable.doctor_3,R.drawable.doctor_2,R.drawable.doctor_1,R.drawable.doctor_2,
            R.drawable.doctor_1,R.drawable.doctor_2,R.drawable.doctor_1,R.drawable.doctor_2,R.drawable.doctor_1};
    private Context context;

    public DoctorsVAdapter(Context productActivity) {
        this.context = productActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_doctors, viewGroup, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        myViewHolder.doctorsname.setText(doctorsname[i]);
        myViewHolder.doctorsVisits.setText(doctorsVisits[i]);
        myViewHolder.doctorsrate.setText(doctorsrate[i]);
        myViewHolder.doctorsreviews.setText(doctorsfeedbcks[i]);

        myViewHolder.doctorsimage.setImageResource(doctorsimage[i]);
        myViewHolder.doctor_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DoctorProfileActivity.class));

            }
        });

        myViewHolder.doctor_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DoctorProfileActivity.class));

            }
        });

        myViewHolder.doctorslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, DoctorProfileActivity.class));
            }
        });
//        myViewHolder.prod_image.setImageResource(clini[i]);


    }

    @Override
    public int getItemCount() {
        return doctorsname.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView doctorsname, doctorsVisits, doctorsrate, doctorsreviews, doctor_profile, doctor_appointment;
        CardView doctorslayout;
        ImageView doctorsimage, plus, minus;
        int sum;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorsname = itemView.findViewById(R.id.doctor_name);
            doctorslayout = itemView.findViewById(R.id.doctors_layout);
            doctorsVisits = itemView.findViewById(R.id.doctor_visits);
            doctorsrate = itemView.findViewById(R.id.rate_bar);
            doctorsreviews = itemView.findViewById(R.id.doctor_feedback);
            doctorsimage = itemView.findViewById(R.id.doctor_image);
            doctor_profile = itemView.findViewById(R.id.doctor_profile);
            doctor_appointment = itemView.findViewById(R.id.doctor_appointment);


        }
    }
}
