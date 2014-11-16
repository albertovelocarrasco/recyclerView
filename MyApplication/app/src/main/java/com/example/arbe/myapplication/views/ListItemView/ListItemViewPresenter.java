package com.example.arbe.myapplication.views.ListItemView;

import android.util.Log;

import com.example.arbe.myapplication.interfaces.ViewModel;

/**
 * Created by arbe on 16/11/14.
 */
public class ListItemViewPresenter implements ListItemPresenter {
    private static final String TAG = "LIST ITEM PRESENTER";

    protected ListItemViewModel mViewModel;

    @Override
    public void setViewModel(ViewModel viewModel) {
        Log.w(TAG, "set setViewModel: ");
        mViewModel = (ListItemViewModel)viewModel;
    }

    @Override
    public void setData(Object data) {
        Log.w(TAG, "set data: " + data);
        if(data instanceof String){
            mViewModel.setData((String)data);
        }
    }
}
