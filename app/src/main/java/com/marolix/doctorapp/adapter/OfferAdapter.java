package com.marolix.doctorapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.marolix.doctorapp.OfferActivity;
import com.marolix.doctorapp.R;

public class OfferAdapter extends BaseAdapter {
    Context context;
    String[] reasons;
    String[] descriptions;
    String[] coupons;

    public OfferAdapter(OfferActivity offerActivity, String[] reasons, String[] descriptions, String[] coupons) {
        this.context=offerActivity;
        this.reasons=reasons;
        this.descriptions=descriptions;
        this.coupons = coupons;
    }

    @Override
    public int getCount() {
        return reasons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      View view1= LayoutInflater.from(context).inflate(R.layout.offerlist,viewGroup,false);
        TextView reason,description,coupon;
        reason=view1.findViewById(R.id.reason);
        description=view1.findViewById(R.id.description);
        coupon=view1.findViewById(R.id.coupon);
        reason.setText(reasons[i]);
        description.setText(descriptions[i]);
        coupon.setText(coupons[i]);
        return view1;
    }
}
