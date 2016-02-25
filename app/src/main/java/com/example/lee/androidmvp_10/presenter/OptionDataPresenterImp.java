package com.example.lee.androidmvp_10.presenter;

import com.example.lee.androidmvp_10.presenterImp.IOptionDataPresenter;
import com.example.lee.androidmvp_10.view.IViewInfoSaveActivity;

/**
 * Created by Lee on 2016/2/16.
 */
public class OptionDataPresenterImp implements IOptionDataPresenter{

    private IViewInfoSaveActivity mIViewInfoSaveAc;

    public OptionDataPresenterImp(IViewInfoSaveActivity activity) {
        mIViewInfoSaveAc = activity;
    }





}
