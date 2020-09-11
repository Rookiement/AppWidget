package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.recyclerview.viewholder.AppViewHolder;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

/**
 * @param <T>
 * @author reber
 */
public abstract class AppSingleTypeAdapter<T> extends AppAdapter<T> {

    private final int mItemLayoutResId;

    public AppSingleTypeAdapter(@LayoutRes int itemLayoutResId) {
        this(itemLayoutResId, false);
    }

    public AppSingleTypeAdapter(@LayoutRes int itemLayoutResId, boolean hasStabledIds) {
        super(hasStabledIds);
        this.mItemLayoutResId = itemLayoutResId;
    }

    @NonNull
    @Override
    public AppViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AppViewHolder<T> appViewHolder = new AppViewHolder<T>(LayoutInflater.from(parent.getContext())
                .inflate(mItemLayoutResId, parent, false));
        onInitViewHolderWhenCreated(appViewHolder);
        return appViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder<T> holder, int position) {
        onNotifyViewHolderWhenBind(holder, getItemWithPosition(position), position);
    }

    public abstract void onInitViewHolderWhenCreated(@NonNull AppViewHolder<T> holder);

    public abstract void onNotifyViewHolderWhenBind(@NonNull AppViewHolder<T> holder, T item, int position);
}
