package com.example.lee.androidmvp_10.viewImp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lee.androidmvp_10.R;
import com.example.lee.androidmvp_10.presenter.OptionDataPresenterImp;
import com.example.lee.androidmvp_10.presenterImp.IOptionDataPresenter;
import com.example.lee.androidmvp_10.view.IViewInfoSaveActivity;

/**
 * Created by pan_li on 2016/2/25.
 */
public class InfoSaveActivity extends AppCompatActivity implements IViewInfoSaveActivity, View.OnClickListener {

    private IOptionDataPresenter mOptionDataPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOptionDataPresenter = new OptionDataPresenterImp(this);
        setContentView(R.layout.activity_save_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_save);
        fab.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab_save){

        }
    }
}
