package com.marolix.doctorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.marolix.doctorapp.adapter.OfferAdapter;

public class OfferActivity extends AppCompatActivity {
ListView listView;
String[] reasons={"Chat with a doctor @Rs.99","Chat with a top Physiotherapist for free.","Upto 40% off on 1st medicine order"};
String[] descriptions={"Cold,fever,cough or flu?chat with a doctor now.","Get free health,fitness & diet advice from top doctors.",
        "40%=25% OFF + 15% Health Cash cashback on perscription medicines only.Max cashbackworth Rs.75 per order." +
                "Cashback given within 24hrs of order delivery in practo amount as HealthCash.Limited Period Offer."};
String[] coupons={"GPCHAT","PHYSIO","PRACTO"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers);
        listView=findViewById(R.id.listview);
        OfferAdapter adapter=new OfferAdapter(OfferActivity.this,reasons,descriptions,coupons);
        listView.setAdapter(adapter);
    }
}
