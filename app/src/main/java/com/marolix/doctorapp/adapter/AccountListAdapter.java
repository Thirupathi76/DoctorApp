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

import com.marolix.doctorapp.AccountsNextActivity;
import com.marolix.doctorapp.DoctorsClinicActivity;
import com.marolix.doctorapp.OfferActivity;
import com.marolix.doctorapp.R;

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.ViewHolderClass> {
    Context context;
    String[] specialities;

    public AccountListAdapter(Context context) {
        this.specialities = context.getResources().getStringArray(R.array.accounts_array);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.account_list_item, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolder, final int i) {
        viewHolder.txt1.setText(specialities[i]);
        viewHolder.txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                context.startActivity(new Intent(context, DoctorsClinicActivity.class));
                if (specialities[i].equals("Offers"))
                    context.startActivity(new Intent(context, OfferActivity.class));
                else
                    context.startActivity(new Intent(context, AccountsNextActivity.class));
            }
        });
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (specialities[i].equals("Offers"))
                    context.startActivity(new Intent(context, OfferActivity.class));
                else
                    context.startActivity(new Intent(context, AccountsNextActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return specialities.length;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView txt1;
        ImageView icon_account_type;
        CardView layout;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            icon_account_type = itemView.findViewById(R.id.icon_account_det);
            layout = itemView.findViewById(R.id.card_layout);
            txt1 = itemView.findViewById(R.id.text_account_det);
            //itemView=imageView.findViewById(R.id.img);
        }
    }
}