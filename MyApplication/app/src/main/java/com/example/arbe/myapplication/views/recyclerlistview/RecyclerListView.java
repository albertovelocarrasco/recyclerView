package com.example.arbe.myapplication.views.recyclerlistview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.arbe.myapplication.R;
import com.example.arbe.myapplication.adapter.RecyclerAdapter;
import com.example.arbe.myapplication.interfaces.Presenter;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by arbe on 16/11/14.
 */
public class RecyclerListView extends LinearLayout implements RecyclerListViewModel {

    private static final String TAG = "RECYCLER LIST VIEW";

    private Presenter mPresenter;

    private RecyclerView mList;

    private LinearLayoutManager mLayoutManager;

    private RecyclerAdapter mAdapter;

    public RecyclerListView(Context context) {
        super(context);
        init();
    }

    public RecyclerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RecyclerListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void setData(final List<String> data) {
        Log.w(TAG, "setData");
        if (mList != null && mAdapter != null) {
            Observable.just(true)
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(
                              new Action1<Boolean>() {
                                  @Override
                                  public void call(Boolean o) {
                                      mAdapter.setData(data);
                                  }
                              });
        }
    }

    @Override
    public void addItem() {
        mAdapter.addItemAtTheBeggining();
        mList.scrollToPosition(0);
    }

    private void init() {
        Log.w(TAG, "init");
        final LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.recycler_list_view, this, true);
        mList = (RecyclerView) findViewById(R.id.list);

        mList.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext());
        mList.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(getContext());
        mList.setAdapter(mAdapter);

        mPresenter = new RecyclerListViewPresenter();
        mPresenter.setViewModel(this);

    }

}
