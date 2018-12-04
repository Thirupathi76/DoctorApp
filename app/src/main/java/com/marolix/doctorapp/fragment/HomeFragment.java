package com.marolix.doctorapp.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.marolix.doctorapp.Chat_Room;
import com.marolix.doctorapp.MainActivity;
import com.marolix.doctorapp.MedicineBookActivity;
import com.marolix.doctorapp.OrderMedicinesActivity;
import com.marolix.doctorapp.R;
import com.marolix.doctorapp.SpecialitiesActivity;
import com.marolix.doctorapp.TestsBookActivity;
import com.marolix.doctorapp.adapter.ViewPagerAdapter;
import com.marolix.doctorapp.utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment implements OnClickListener {


    private ViewPager introPager;
    private LinearLayout sliderDotspanel;

    private int dotscount;
    private ImageView[] dots;

    private LinearLayout clinic_doc_layout, chat_doctor_layout, order_medicine_layout, book_test_layout;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater view, ViewGroup viewGroup, Bundle bundle) {

        View layoutInflater = view.inflate(R.layout.fragment_home_new, viewGroup, false);

        introPager = layoutInflater.findViewById(R.id.home_banner_pager);
        sliderDotspanel = layoutInflater.findViewById(R.id.home_banner_pager_indicator);
        clinic_doc_layout = layoutInflater.findViewById(R.id.clinic_doc_layout);
        chat_doctor_layout = layoutInflater.findViewById(R.id.chat_doctor_layout);
        chat_doctor_layout.setOnClickListener(this);
        order_medicine_layout = layoutInflater.findViewById(R.id.order_medicine_layout);
        order_medicine_layout.setOnClickListener(this);

        book_test_layout = layoutInflater.findViewById(R.id.book_test_layout);
        book_test_layout.setOnClickListener(this);
        clinic_doc_layout.setOnClickListener(this);

        Utilities.setPreference(getActivity(), Utilities.USER_NAME, "User");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());

        introPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        setUpSlider();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 4000);

        return layoutInflater;
    }

    private void setUpSlider() {


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonactive_dot));

        introPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonactive_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clinic_doc_layout:
                startActivity(new Intent(getActivity(), SpecialitiesActivity.class));
                break;

            case R.id.chat_doctor_layout:
                startActivity(new Intent(getActivity(), Chat_Room.class));
                break;

            case R.id.order_medicine_layout:
                startActivity(new Intent(getActivity(), OrderMedicinesActivity.class));
                break;

            case R.id.book_test_layout:
                startActivity(new Intent(getActivity(), TestsBookActivity.class));
                break;
        }
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            if (getActivity() == null)
                return;
            ((Activity) getActivity()).runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    if (introPager.getCurrentItem() == 0) {
                        introPager.setCurrentItem(1);
                    } else if (introPager.getCurrentItem() == 1) {
                        introPager.setCurrentItem(2);
                    } /*else if (introPager.getCurrentItem() == 2) {
                        introPager.setCurrentItem(3);
                    }*/ else {
                        introPager.setCurrentItem(0);
                    }

                }
            });
        }

    }

}

