package com.sdigtizers.progressdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sdigtizers.progressdialogutil.ProgressDialogAndroid;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressDialogAndroid progressDialogUtil =new ProgressDialogAndroid(MainActivity.this);
        progressDialogUtil.setMessage("Testing For Progress").setMarqueText(true).setCancellable(true)
                .setProgressStartColor(getResources().getColor(R.color.colorPrimaryDark))
                .setProgressEndColor(getResources().getColor(R.color.colorPrimary))
                .show();
    }
}
