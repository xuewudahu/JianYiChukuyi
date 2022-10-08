package com.kuaidihelp.posthouse;

import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Express {
    private int imageId;
    private String textView;
   // private Switch aSwitch;

    public Express(int imageView, String textView) {
        this.imageId = imageView;
        this.textView = textView;
      //  this.aSwitch = aSwitch;
    }

    public int getImageView() {
        return imageId;
    }

    public String getTextView() {
        return textView;
    }

/*    public Switch getaSwitch() {
        return aSwitch;
    }*/
}
