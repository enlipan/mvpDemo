package com.example.lee.androidmvp_10.viewImp;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.lee.androidmvp_10.R;
import com.example.lee.androidmvp_10.presenter.OptionDataPresenterImp;
import com.example.lee.androidmvp_10.presenter.ShowImagePresenterImp;
import com.example.lee.androidmvp_10.presenterImp.IOptionDataPresenter;
import com.example.lee.androidmvp_10.presenterImp.IShowImagePresenter;
import com.example.lee.androidmvp_10.view.IViewMainActivity;

public class MainActivity extends AppCompatActivity implements IViewMainActivity,View.OnClickListener{

    private final int[] RES_IMAGE_ID = {R.drawable.guidepage01,R.drawable.guidepage02,R.drawable.guidepage03};
    private int mIndex = 0;
    private IShowImagePresenter mShowImagePresenter;
    private IOptionDataPresenter mOptionDataPresenter;

    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShowImagePresenter = new ShowImagePresenterImp(this);
        mOptionDataPresenter = new OptionDataPresenterImp(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        mImageView = (ImageView) findViewById(R.id.iv_center_image);
        mImageView.setOnClickListener(this);
        showImageAfterClick();
    }


    public void showImageAfterClick() {
        mShowImagePresenter.ChangeImage(this,mIndex,RES_IMAGE_ID);
        mIndex ++;
    }

    @Override
    public void changeImageByBitmapCache(BitmapDrawable bitmapDrawable) {
        mImageView.setImageDrawable(bitmapDrawable);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab){
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }else if (id == R.id.iv_center_image){
            showImageAfterClick();
        }
    }
}
