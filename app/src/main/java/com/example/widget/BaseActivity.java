package com.example.widget;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        onCreateInitWithState(savedInstanceState);
    }

    @LayoutRes
    protected abstract int getActivityLayoutId();

    protected abstract void onCreateInitWithState(Bundle savedInstanceState);
}
