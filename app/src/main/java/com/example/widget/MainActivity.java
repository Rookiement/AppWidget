package com.example.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.widget.recycler.RecyclerViewListActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TYPE_NAME_RECYCLER_VIEW = "RecyclerView";

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreateInitWithState(Bundle savedInstanceState) {
        LinearLayout container = findViewById(R.id.container);
        container.addView(getItemViewWithTypeName(TYPE_NAME_RECYCLER_VIEW));
    }

    @Override
    public void onClick(View view) {
        String tag = (String) view.getTag();
        switch (tag) {
            case TYPE_NAME_RECYCLER_VIEW:
                RecyclerViewListActivity.startActivity(this);
                break;
        }
    }

    private View getItemViewWithTypeName(String typeName) {
        View itemView = ViewUtil.generateTextView(this, typeName);
        itemView.setTag(typeName);
        itemView.setOnClickListener(this);
        return itemView;
    }
}