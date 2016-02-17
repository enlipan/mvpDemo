package com.example.lee.androidmvp_10.viewImp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.lee.androidmvp_10.R;
import com.example.lee.androidmvp_10.presenter.ShowImagePresenterImp;
import com.example.lee.androidmvp_10.presenterImp.IShowImagePresenter;
import com.example.lee.androidmvp_10.view.IViewMainActivity;

public class MainActivity extends AppCompatActivity implements IViewMainActivity,View.OnClickListener{

    private final int[] RES_IMAGE_ID = {R.drawable.guidepage01,R.drawable.guidepage02,R.drawable.guidepage03};
    private int mIndex = 0;
    private IShowImagePresenter mShowImagePresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShowImagePresenter = new ShowImagePresenterImp(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        ImageView iv = (ImageView) findViewById(R.id.iv_center_image);
        iv.setOnClickListener(this);
        showImageAfterClick(iv);
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


    @Override
    public void showImageAfterClick(ImageView iv) {
        mShowImagePresenter.ChangeImage(iv,mIndex,RES_IMAGE_ID);
        mIndex ++;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab){
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }else if (id == R.id.iv_center_image){
            showImageAfterClick((ImageView)v);
        }
    }
}
