package com.sdigtizers.progressdialogutil;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RotateDrawable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Objects;

import static android.text.TextUtils.TruncateAt.MARQUEE;


public class ProgressDialogAndroid {

    private Dialog dialog;
    private ProgressBar progressCircular;
    private Context context;
    private TextView customMessageTv;
    int colors[] = { 0xff255779, 0xffa6c0cd };

    public ProgressDialogAndroid(Context context){
        this.context=context;
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_progress);
        progressCircular=(ProgressBar)dialog.findViewById(R.id.progress_circular);
        customMessageTv = (TextView) dialog.findViewById(R.id.progress_message);
        customMessageTv.setSelected(true);
        customMessageTv.setText("");
        customMessageTv.setEllipsize(MARQUEE);
        customMessageTv.setTextColor(Color.BLACK);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        RotateDrawable rd =  (RotateDrawable) progressCircular.getIndeterminateDrawable();
        GradientDrawable gd = (GradientDrawable)rd.getDrawable();
        gd.setColors(colors);
        rd.setDrawable(gd);
        progressCircular.setIndeterminateDrawable(rd);
    }

    public ProgressDialogAndroid setBackgroundDrawable(int customColor){
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(customColor));
        return this;
    }

    public ProgressDialogAndroid setMessage(String msg){
        customMessageTv.setText(msg);
        return this;
    }

    public ProgressDialogAndroid setCancellable(boolean value){
        dialog.setCancelable(value);
        return this;
    }

    public ProgressDialogAndroid show(){
        dialog.show();
        return this;
    }

    public ProgressDialogAndroid dismiss(){
        dialog.dismiss();
        return this;
    }

    public ProgressDialogAndroid setMarqueText(boolean value){
        return this;
    }

    public ProgressDialogAndroid setProgressStartColor(int color1){
        colors[0]=color1;
        return this;
    }

    public ProgressDialogAndroid setProgressEndColor(int color2){
        colors[1]=color2;
        return this;
    }

}
