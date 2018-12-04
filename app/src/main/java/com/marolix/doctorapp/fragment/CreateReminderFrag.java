package com.marolix.doctorapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.marolix.doctorapp.R;
import com.marolix.doctorapp.font.TextView_AvenirLTStd_Book;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import sharukh.sliderdtpicker.SliderDateTimePicker;

public class CreateReminderFrag extends Fragment {

    private TextView reminder_text;

    public CreateReminderFrag() {
        // Required empty public constructor
    }
    private SimpleDateFormat sdf = new SimpleDateFormat("d MMM, h aa", Locale.ENGLISH);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_create_reminder, container, false);
        Button btn_set_reminder = view.findViewById(R.id.btn_set_reminder);
        reminder_text = view.findViewById(R.id.reminder_text);
        btn_set_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SliderDateTimePicker.newInstance()
                        .setOnDateTimeSetListener((new SliderDateTimePicker.OnDateTimeSetListener() {
                            @Override
                            public void onDateTimeSelected(final Calendar startTime) {
                                reminder_text.setText("Reminder set at "+sdf.format(startTime.getTime()));
                                Toast.makeText(getActivity(), "Alarm set at "+sdf.format(startTime.getTime()), Toast.LENGTH_SHORT).show();
                            }
                        }))
                        .setStartLabel("Set Time")
                        .show(getFragmentManager(), "Your wish");
            }
        });

        return view;
    }
}
