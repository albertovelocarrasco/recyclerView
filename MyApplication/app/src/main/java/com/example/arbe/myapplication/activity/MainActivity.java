package com.example.arbe.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.arbe.myapplication.R;
import com.example.arbe.myapplication.interfaces.Presenter;
import com.example.arbe.myapplication.views.recyclerlistview.RecyclerListView;

public class MainActivity extends Activity implements ActivityViewModel{

    private static final String TAG = "MAIN_ACTIVITY";

    private RecyclerListView mList;
    private Button mButton;
    private ActivityPresenter mPresenter;

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        mList = (RecyclerListView) findViewById(R.id.rec_list);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(getClickListener());
        mPresenter = new ActivityViewPresenter();
        mPresenter.setListPresenter(mList.getPresenter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener getClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w(TAG, "onClick");
                mPresenter.buttonClicked();
            }
        };
    }

}
