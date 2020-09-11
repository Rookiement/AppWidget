package com.example.recyclerview.item;

import android.view.View;

import com.example.recyclerview.R;
import com.example.recyclerview.viewholder.BaseViewHolder;

public class TestingItem extends BaseAdapterItem<String> implements View.OnClickListener {

    private String mContent;
    private View.OnClickListener mClickListener;

    public TestingItem(String content, View.OnClickListener listener) {
        this.mContent = content;
        this.mClickListener = listener;
    }

    @Override
    public int getLayoutResId() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 0:
                break;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<String> holder) {
    }
}
