package com.example.rxjavalearning.my_timer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.rxjavalearning.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class TimerFragment extends Fragment {

    private CheckBox mSingleShotCheckBox;
    private Button mStartButton, mCancelButton;
    private TextView mCounterTextView;

    private Timer mTimer;
    private MyTimerTask mMyTimerTask;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timer, container, false);


        mSingleShotCheckBox = (CheckBox) view.findViewById(R.id.checkBoxSingleShot);
        mStartButton = (Button) view.findViewById(R.id.buttonStart);
        mCancelButton = (Button) view.findViewById(R.id.buttonCancel);
        mCounterTextView = (TextView) view.findViewById(R.id.textViewCounter);

        mStartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (mTimer != null) {
                    mTimer.cancel();
                }

                // re-schedule timer here
                // otherwise, IllegalStateException of
                // "TimerTask is scheduled already"
                // will be thrown
                mTimer = new Timer();
                mMyTimerTask = new MyTimerTask();

                if (mSingleShotCheckBox.isChecked()) {
                    // singleshot delay 1000 ms
                    mTimer.schedule(mMyTimerTask, 1000);
                } else {
                    // delay 1000ms, repeat in 5000ms
                    mTimer.schedule(mMyTimerTask, 1000, 1000);
                }
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mTimer != null) {
                    mTimer.cancel();
                    mTimer = null;
                }
            }
        });
        return view;


    }


    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "dd:MMMM:yyyy HH:mm:ss a", Locale.getDefault());
            final String strDate = simpleDateFormat.format(calendar.getTime());

            getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    mCounterTextView.setText(strDate);
                }
            });
        }
    }

}