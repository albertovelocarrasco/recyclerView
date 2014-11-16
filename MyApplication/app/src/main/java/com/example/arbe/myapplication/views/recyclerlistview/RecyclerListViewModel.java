package com.example.arbe.myapplication.views.recyclerlistview;

import com.example.arbe.myapplication.interfaces.ViewModel;

import java.util.List;

/**
 * Created by arbe on 16/11/14.
 */
public interface RecyclerListViewModel extends ViewModel {

    public void setData(List<String> data);

    public void addItem();
}
