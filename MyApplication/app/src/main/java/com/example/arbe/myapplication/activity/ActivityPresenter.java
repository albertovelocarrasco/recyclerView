package com.example.arbe.myapplication.activity;

import com.example.arbe.myapplication.interfaces.Presenter;

/**
 * Created by arbe on 16/11/14.
 */
public interface ActivityPresenter extends Presenter{

    public void buttonClicked();
    public void setListPresenter(Presenter presenter);
}
