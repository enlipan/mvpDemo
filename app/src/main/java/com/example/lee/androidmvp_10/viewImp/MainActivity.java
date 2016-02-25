package com.example.lee.androidmvp_10.viewImp;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.lee.androidmvp_10.R;
import com.example.lee.androidmvp_10.presenter.ShowImagePresenterImp;
import com.example.lee.androidmvp_10.presenterImp.IShowImagePresenter;
import com.example.lee.androidmvp_10.view.IViewMainActivity;

public class MainActivity extends AppCompatActivity implements IViewMainActivity,View.OnClickListener{

    private final int[] RES_IMAGE_ID = {R.drawable.guidepage01,R.drawable.guidepage02,R.drawable.guidepage03};
    private int mIndex = 0;
    private IShowImagePresenter mShowImagePresenter;


    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShowImagePresenter = new ShowImagePresenterImp(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add);
        fab.setOnClickListener(this);

        mImageView = (ImageView) findViewById(R.id.iv_center_image);
        mImageView.setOnClickListener(this);
        showImageAfterClick();
    }


    public void showImageAfterClick() {
        mShowImagePresenter.changeImage(this, mIndex, RES_IMAGE_ID);
        mIndex ++;
    }

    @Override
    public void changeImageByBitmapCache(BitmapDrawable bitmapDrawable) {
        mImageView.setImageDrawable(bitmapDrawable);
    }

    @Override
    public void goToSaveInfo(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab_add){
            mShowImagePresenter.goToSaveInfo(this);
        }else if (id == R.id.iv_center_image){
            showImageAfterClick();
        }
    }
}
