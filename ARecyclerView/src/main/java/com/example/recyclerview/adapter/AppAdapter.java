package com.example.recyclerview.adapter;

import com.example.recyclerview.viewholder.AppViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @param <T>
 * @author reber
 */
public abstract class AppAdapter<T> extends RecyclerView.Adapter<AppViewHolder<T>> {

    private final List<T> mAdapterList;

    public AppAdapter() {
        this(false);
    }

    public AppAdapter(boolean hasStabledIds) {
        this.mAdapterList = new ArrayList<>();
        setHasStableIds(hasStabledIds);
    }

    public List<T> getAdapterList() {
        return mAdapterList;
    }

    public T getItemWithPosition(int position) {
        return mAdapterList.get(position);
    }

    @Override
    public int getItemCount() {
        return mAdapterList.size();
    }

    /*=============================单个插入Item======================*/
    public void insertItem(T item) {
        if (item != null) {
            insertItemWhenNotEmpty(item);
        }
    }

    public void insertItemNotify(T item) {
        if (item != null) {
            insertItemWhenNotEmpty(item);
            notifyItemChanged(getItemCount());
        }
    }

    public void insertItem(T item, int position) {
        if (item != null) {
            insertItemWhenNotEmpty(item, position);
        }
    }

    public void insertItemNotify(T item, int position) {
        if (item != null) {
            insertItemWhenNotEmpty(item, position);
            notifyItemChanged(position);
        }
    }

    /*==============================插入列表=========================*/
    public void insertItemList(T[] itemList) {
        if (itemList != null && itemList.length > 0) {
            insertItemListWhenNotEmpty(Arrays.asList(itemList));
        }
    }

    public void insertItemListNotify(T[] itemList) {
        if (itemList != null && itemList.length > 0) {
            insertItemListWhenNotEmpty(Arrays.asList(itemList));
            notifyItemRangeInserted(getItemCount(), itemList.length);
        }
    }

    public void insertItemList(List<T> itemList) {
        if (itemList != null && !itemList.isEmpty()) {
            insertItemListWhenNotEmpty(itemList);
        }
    }

    public void insertItemListNotify(List<T> itemList) {
        if (itemList != null && !itemList.isEmpty()) {
            insertItemListWhenNotEmpty(itemList);
            notifyItemRangeInserted(mAdapterList.size(), itemList.size());
        }
    }

    public void addNewItemListNotify(T[] itemList) {
        mAdapterList.clear();
        if (itemList != null && itemList.length > 0) {
            insertItemListWhenNotEmpty(Arrays.asList(itemList));
        }
        notifyDataSetChanged();
    }

    public void addNewItemListNotify(List<T> itemList) {
        mAdapterList.clear();
        if (itemList != null && !itemList.isEmpty()) {
            insertItemListWhenNotEmpty(itemList);
        }
        notifyDataSetChanged();
    }

    protected void insertItemWhenNotEmpty(@NonNull T item) {
        mAdapterList.add(item);
    }

    protected void insertItemWhenNotEmpty(@NonNull T item, int position) {
        mAdapterList.add(position, item);
    }

    protected void insertItemListWhenNotEmpty(@NonNull List<T> itemList) {
        mAdapterList.addAll(itemList);
    }
}
