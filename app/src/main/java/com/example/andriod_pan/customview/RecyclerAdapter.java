package com.example.andriod_pan.customview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriod_pan on 2018/9/10.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {
    private final static int HEAD_COUNT = 1;
    private final static int FOOT_COUNT = 1;

    private final static int TYPE_HEAD = 0;
    private final static int TYPE_CONTENT = 1;
    private final static int TYPE_FOOTER = 2;
    Context mcontext;
    ArrayList<String> mlist;

    public RecyclerAdapter(Context context, ArrayList<String> list) {
        mcontext = context;
        mlist = list;
    }

    public int getContentSize() {
        return mlist.size();
    }

    public boolean isHead(int position) {
        return HEAD_COUNT != 0 && position == 0;
    }

    public boolean isFoot(int position) {
        return FOOT_COUNT != 0 && position == getContentSize() + HEAD_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        int contentSize = getContentSize();
        if (HEAD_COUNT != 0 && position == 0) { // 头部
            return TYPE_HEAD;
        } else if (FOOT_COUNT != 0 && position == HEAD_COUNT + contentSize) { // 尾部
            return TYPE_FOOTER;
        } else {
            return TYPE_CONTENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            View itemView = LayoutInflater.from(mcontext).inflate(R.layout.head_for_recyclerview, parent, false);
            return new RecyclerAdapter.HeadHolder(itemView);
        } else if (viewType == TYPE_CONTENT) {
            View itemView = LayoutInflater.from(mcontext).inflate(R.layout.item_for_recycler_view, parent, false);
            return new RecyclerAdapter.ContentHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(mcontext).inflate(R.layout.foot_for_recyclerview, parent, false);
            return new RecyclerAdapter.FootHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerAdapter.HeadHolder) { // 头部

        } else if (holder instanceof RecyclerAdapter.ContentHolder) { // 内容
            RecyclerAdapter.ContentHolder myHolder = (RecyclerAdapter.ContentHolder) holder;
            myHolder.itemText.setText(mlist.get(position - 1));
        } else { // 尾部

        }
    }

    @Override
    public int getItemCount() {
        return mlist.size() + HEAD_COUNT + FOOT_COUNT;
    }

    // 头部
    private class HeadHolder extends RecyclerView.ViewHolder {
        public HeadHolder(View itemView) {
            super(itemView);
        }
    }

    // 内容
    private class ContentHolder extends RecyclerView.ViewHolder {
        TextView itemText;

        public ContentHolder(View itemView) {
            super(itemView);
            itemText = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

    // 尾部
    private class FootHolder extends RecyclerView.ViewHolder {
        public FootHolder(View itemView) {
            super(itemView);
        }
    }
}
