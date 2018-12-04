package com.marolix.doctorapp.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.marolix.doctorapp.R;
import com.marolix.doctorapp.adapter.TabPagerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RemindersFragment extends Fragment /*implements GetOrdersInterface*/ {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View layoutInflater = inflater.inflate(R.layout.fragment_reminders, viewGroup, false);

        mViewPager = layoutInflater.findViewById(R.id.products_viewPager);
        mTabLayout = layoutInflater.findViewById(R.id.tabs);
        setUpViewPager();
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabSelectedListener());
        mTabLayout.setupWithViewPager(mViewPager);
        return layoutInflater;
    }

    class TabSelectedListener implements TabLayout.OnTabSelectedListener {
        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            /*LinearLayout tabLayout = (LinearLayout)((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition());
            TextView tabTextView = (TextView) tabLayout.getChildAt(1);
            tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.NORMAL);*/
        }



        public void onTabSelected(TabLayout.Tab tab) {
            /*LinearLayout tabLayout = (LinearLayout)((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition());
            TextView tabTextView = (TextView) tabLayout.getChildAt(1);
            tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);*/
            mViewPager.setCurrentItem(tab.getPosition());
        }
    }
    public void onResume() {
        super.onResume();
//        getOrderDetails();
    }

    private void setUpViewPager() {

        TabPagerAdapter adapter = new TabPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new CreateReminderFrag(), "Reminders");
        adapter.addFrag(new NotificationsFrag(), "Notifications");

        mViewPager.setAdapter(adapter);

        // viewPager.setOffscreenPageLimit(-1);
        adapter.notifyDataSetChanged();

    }

    public void onDestroy() {
        super.onDestroy();
        }
}
