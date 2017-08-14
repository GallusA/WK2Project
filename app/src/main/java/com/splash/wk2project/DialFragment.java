package com.splash.wk2project;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by gallusawa on 8/13/17.
 */

public class DialFragment extends DialogFragment {

    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dialog,container,false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        getDialog().setTitle("imageView");

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CountDownTimer gameTimer = new CountDownTimer(2500, 2500) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                dismiss();
            }
        };
        gameTimer.start();
    }
}


