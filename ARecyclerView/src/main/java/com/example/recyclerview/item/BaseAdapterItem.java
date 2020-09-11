package com.example.recyclerview.item;

import com.example.recyclerview.viewholder.BaseViewHolder;

import androidx.annotation.LayoutRes;

/**
 * @author reber
 */
public abstract class BaseAdapterItem<T> {

    public final int getItemViewType() {
        return this.getClass().getSimpleName().hashCode();
    }

    @LayoutRes
    public abstract int getLayoutResId();

    public abstract void onBindViewHolder(BaseViewHolder<T> holder);
}
