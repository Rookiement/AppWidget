package com.example.recyclerview.adapter;

import com.example.recyclerview.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAppAdapter<M, T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    private final List<M> mAdapterList;

    public BaseAppAdapter() {
        this(false);
    }

    public BaseAppAdapter(boolean hasStabledIds) {
        this.mAdapterList = new ArrayList<>();
        setHasStableIds(hasStabledIds);
    }

    public BaseAppAdapter(@NonNull List<M> adapterList) {
        this.mAdapterList = adapterList;
    }

    public List<M> getAdapterList() {
        return mAdapterList;
    }

    /*=============================单个插入Item======================*/
    public void insertItem(M item) {
        if (item != null) {
            insertItemWhenNotEmpty(item, getItemCount());
        }
    }

    public void insertItemNotify(M item) {
        if (item != null) {
            insertItemWhenNotEmpty(item, getItemCount());
            notifyItemChanged(getItemCount());
        }
    }

    public void insertItem(M item, int position) {
        if (item != null) {
            insertItemWhenNotEmpty(item, position);
        }
    }

    public void insertItemNotify(M item, int position) {
        if (item != null) {
            insertItemWhenNotEmpty(item, position);
            notifyItemChanged(position);
        }
    }

    /*==============================插入列表=========================*/
    public void insertItemList(M[] itemList) {
        if (itemList != null && itemList.length > 0) {
            insertItemListWhenNotEmpty(Arrays.asList(itemList));
        }
    }

    public void insertItemListNotify(M[] itemList) {
        if (itemList != null && itemList.length > 0) {
            insertItemListWhenNotEmpty(Arrays.asList(itemList));
            notifyItemRangeInserted(getItemCount(), itemList.length);
        }
    }

    public void insertItemList(List<M> itemList) {
        if (itemList != null && !itemList.isEmpty()) {
            insertItemListWhenNotEmpty(itemList);
        }
    }

    public void insertItemListNotify(List<M> itemList) {
        if (itemList != null && !itemList.isEmpty()) {
            insertItemListWhenNotEmpty(itemList);
            notifyItemRangeInserted(mAdapterList.size(), itemList.size());
        }
    }

    public void addNewItemListNotify(M[] itemList) {
        mAdapterList.clear();
        if (itemList != null && itemList.length > 0) {
            insertItemListWhenNotEmpty(Arrays.asList(itemList));
        }
        notifyDataSetChanged();
    }

    public void addNewItemListNotify(List<M> itemList) {
        mAdapterList.clear();
        if (itemList != null && !itemList.isEmpty()) {
            insertItemListWhenNotEmpty(itemList);
        }
        notifyDataSetChanged();
    }

    protected void insertItemWhenNotEmpty(@NonNull M item, int position) {
        mAdapterList.add(position, item);
    }

    protected void insertItemListWhenNotEmpty(@NonNull List<M> itemList) {
        mAdapterList.addAll(itemList);
    }

    @Override
    public int getItemCount() {
        return mAdapterList.size();
    }
}
