package com.example.arbe.myapplication.views.ListItemView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arbe.myapplication.R;
import com.example.arbe.myapplication.interfaces.Presenter;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by arbe on 16/11/14.
 */
public class ListItemView extends LinearLayout implements ListItemViewModel{

    private TextView mId;

    private Presenter mPresenter;


    public ListItemView(Context context) {
        super(context);
        init();
    }

    public ListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void setData(String data) {
        Observable.just(data)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(
                          new Action1<String>() {
                              @Override
                              public void call(String s) {
                                  populateData(s);
                              }
                          });
    }

    private void init(){
        final LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_item_view, this, true);
        mId = (TextView)findViewById(R.id.item_id);
        mPresenter = new ListItemViewPresenter();
        mPresenter.setViewModel(this);
    }

    private void populateData(String data){
        if(data != null && data.length() >0) {
            mId.setText(data);
        }
    }

}
