package com.example.arbe.myapplication.views.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.arbe.myapplication.interfaces.ViewModel;

/**
 * Created by arbe on 16/11/14.
 */
public class ViewHolderImpl extends RecyclerView.ViewHolder {

    private View mView;

    public ViewHolderImpl(View itemView) {
        super(itemView);
        mView = itemView;
    }


    public View getView(){
        return mView;
    }
}
