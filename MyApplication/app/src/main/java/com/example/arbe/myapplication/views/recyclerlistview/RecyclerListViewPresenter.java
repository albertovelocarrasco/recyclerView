package com.example.arbe.myapplication.views.recyclerlistview;

import android.util.Log;

import com.example.arbe.myapplication.interfaces.ViewModel;

import java.util.List;

/**
 * Created by arbe on 16/11/14.
 */
public class RecyclerListViewPresenter implements RecyclerListPresenter {
    private static final String TAG = "LIST PRESENTER";

    protected RecyclerListViewModel mViewModel;

    @Override
    public void setViewModel(ViewModel viewModel) {
        mViewModel = (RecyclerListViewModel)viewModel;
    }

    @Override
    public void setData(Object data) {
        Log.w(TAG, "setData: " + data);
        mViewModel.setData((List<String>)data);
    }

    @Override
    public void addItem() {
        mViewModel.addItem();
    }
}
