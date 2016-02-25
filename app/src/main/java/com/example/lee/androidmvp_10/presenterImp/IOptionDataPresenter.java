package com.example.lee.androidmvp_10.presenterImp;

import android.content.Context;

import com.example.lee.androidmvp_10.model.bean.PersonBean;

/**
 * Created by Lee on 2016/2/16.
 */
public interface IOptionDataPresenter {

    void savePersonDate(Context context,PersonBean person);

}
