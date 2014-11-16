package com.example.arbe.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.example.arbe.myapplication.interfaces.ViewModel;
import com.example.arbe.myapplication.views.ListItemView.ListItemView;
import com.example.arbe.myapplication.views.viewholder.ViewHolderImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arbe on 16/11/14.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolderImpl> {

    private static final String TAG = "RECYCLER ADAPTER";

    private List<String> mData;

    private Context mContext;

    public RecyclerAdapter(Context context) {
        super();
        Log.w(TAG, "RecyclerAdapter()");
        mData = new LinkedList<String>();
        mContext = context;
    }

    @Override
    public ViewHolderImpl onCreateViewHolder(
            ViewGroup viewGroup, int i) {
        Log.w(TAG, "onCreateViewHolder");
        return new ViewHolderImpl(new ListItemView(mContext));
    }

    @Override
    public void onBindViewHolder(
            ViewHolderImpl viewHolder, int i) {
        Log.w(TAG, "onBindViewHolder");
        if(viewHolder.getView() instanceof ViewModel){
            Log.w(TAG, "onBindViewHolder.setting data into the views Presenter");
            ((ViewModel) viewHolder.getView()).getPresenter().setData(mData.get(i));
        }
    }

    @Override
    public int getItemCount() {
        if(mData == null){
            return 0;
        }else {
            return mData.size();
        }
    }

    public void setData(List<String> data){
        Log.w(TAG, "set data: " + data);
        mData = data;
        notifyDataSetChanged();
    }

    public void addItem(){
        if(mData != null){
            mData.add("item :" + (mData.size() + 1));
            notifyItemInserted(mData.size() -1);
        }
    }

    public void addItemAtTheBeggining(){
        if(mData != null) {
            ((LinkedList) mData).addFirst("item :" + (mData.size() + 1));
            notifyItemInserted(0);

//            notifyItemRangeInserted(0, mData.size() -1);
        }
    }
}
