package com.example.widget.recycler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.AppRecyclerView;
import com.example.recyclerview.adapter.AppSingleTypeAdapter;
import com.example.recyclerview.viewholder.AppViewHolder;
import com.example.widget.BaseActivity;
import com.example.widget.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

public class RecyclerViewListActivity extends BaseActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RecyclerViewListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_recycler_list;
    }

    @Override
    protected void onCreateInitWithState(Bundle savedInstanceState) {
        AppRecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AppSingleTypeAdapter<String> adapter = new AppSingleTypeAdapter<String>(R.layout.item_recycler_list) {
            @Override
            public void onInitViewHolderWhenCreated(@NonNull AppViewHolder<String> holder) {
                holder.setOnClickListener(R.id.item_content, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "aaa", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNotifyViewHolderWhenBind(@NonNull AppViewHolder<String> holder, String content, int position) {
                holder.setText(R.id.item_content, content);
            }
        };
        recyclerView.setAdapter(adapter);

        adapter.insertItemList(getDataList(50));
    }

    private List<String> getDataList(int count) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add("Testing-00" + i);
        }
        return data;
    }
}
