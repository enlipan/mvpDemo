package com.example.lee.androidmvp_10.presenter;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Lee on 2016/2/16.
 */
public interface IShowImagePresenter {

    void changeImage(Context context, int index, int[] res);

    void goToSaveInfo(Activity ac);
}
