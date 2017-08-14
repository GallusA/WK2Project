package com.splash.wk2project;

import android.app.DialogFragment;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by gallusawa on 8/14/17.
 */

public class SMSData extends DialogFragment {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    private static final String SENT = "Message Sent!!!!";
    private static final String DELIVERED = "Message Delivered";
    EditText number, message;
    Button btnSMS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sending_sms, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        message = (EditText) view.findViewById(R.id.message);
        number = (EditText) view.findViewById(R.id.number);
        btnSMS = (Button) view.findViewById(R.id.btnSMS);
        getDialog().setTitle("Send Message");
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
                dismiss();
                message.setText("");
                number.setText("");
            }
        });

        return view;
    }

    private void sendMessage() {
        // Get the default instance of the SmsManager
        SmsManager smsM = SmsManager.getDefault();
        smsM.sendTextMessage(number.getText().toString(), null, message.getText().toString(), null, null);
        Toast.makeText(getActivity(), "Your sms was successfully sent!",
                Toast.LENGTH_LONG).show();

    }
}