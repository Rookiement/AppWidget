package com.example.widget;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class ViewUtil {

    public static TextView generateTextView(Context context, String content) {
        TextView textView = new TextView(context);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        textView.setText(content);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(getLayoutParams());
        return textView;
    }

    public static ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
    }
}
