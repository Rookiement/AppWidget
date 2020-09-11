package com.example.recyclerview.adapter;

import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.recyclerview.item.BaseAdapterItem;
import com.example.recyclerview.viewholder.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;

public class AppMultiTypeAdapter<T> extends AppAdapter<BaseAdapterItem<T>, T> {

    private final SparseIntArray mItemLayoutIds;

    public AppMultiTypeAdapter() {
        super();
        this.mItemLayoutIds = new SparseIntArray();
    }

    public AppMultiTypeAdapter(@NonNull List<BaseAdapterItem<T>> adapterList, boolean hasStabledIds) {
        super(adapterList);
        this.mItemLayoutIds = new SparseIntArray();
    }

    @Override
    public int getItemViewType(int position) {
        return getAdapterList().get(position).getItemViewType();
    }

    @NonNull
    @Override
    public BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layoutResId = mItemLayoutIds.get(viewType);
        return new BaseViewHolder<T>(LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutResId, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T> holder, int position) {
        getAdapterList().get(position).onBindViewHolder(holder);
    }

    @Override
    protected void insertItemWhenNotEmpty(@NonNull BaseAdapterItem<T> item, int position) {
        updateLayoutIdList(item);
        super.insertItemWhenNotEmpty(item, position);
    }

    @Override
    protected void insertItemListWhenNotEmpty(@NonNull List<BaseAdapterItem<T>> itemList) {
        for (BaseAdapterItem<T> item : itemList) {
            updateLayoutIdList(item);
        }
        super.insertItemListWhenNotEmpty(itemList);
    }

    protected void updateLayoutIdList(@NonNull BaseAdapterItem<T> item) {
        int itemViewType = item.getItemViewType();
        if (mItemLayoutIds.get(itemViewType) == 0) {
            mItemLayoutIds.put(itemViewType, item.getLayoutResId());
        }
    }
}
