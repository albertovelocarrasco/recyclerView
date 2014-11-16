package com.example.arbe.myapplication.activity;

import android.util.Log;

import com.example.arbe.myapplication.interfaces.Presenter;
import com.example.arbe.myapplication.interfaces.ViewModel;
import com.example.arbe.myapplication.views.recyclerlistview.RecyclerListPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arbe on 16/11/14.
 */
public class ActivityViewPresenter implements ActivityPresenter{
    private static final String TAG = "ACTIVITY_PRESENTER";

    private ActivityViewModel mViewModel;
    private RecyclerListPresenter mListPresenter;
    private List<String> mData;

    public ActivityViewPresenter() {
        mData = new ArrayList<String>();
    }

    @Override
    public void buttonClicked() {
        mListPresenter.addItem();
    }

    @Override
    public void setListPresenter(Presenter presenter) {
        mListPresenter = (RecyclerListPresenter)presenter;
    }

    @Override
    public void setViewModel(ViewModel viewModel) {
        mViewModel = (ActivityViewModel)viewModel;
    }

    @Override
    public void setData(Object data) {

    }

}
