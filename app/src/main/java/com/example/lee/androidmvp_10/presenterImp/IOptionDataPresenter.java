package com.example.lee.androidmvp_10.presenterImp;

import android.content.Context;
import android.widget.EditText;

/**
 * Created by Lee on 2016/2/16.
 */
public interface IOptionDataPresenter {

    void savePersonDate(Context context,EditText nameEt,EditText ageEt,EditText idEt);

}
