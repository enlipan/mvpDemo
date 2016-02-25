package com.example.lee.androidmvp_10.presenter;

import android.content.Context;

import com.example.lee.androidmvp_10.model.IPersonSaveModel;
import com.example.lee.androidmvp_10.model.bean.PersonBean;
import com.example.lee.androidmvp_10.modelImp.PersonSaveModelImp;
import com.example.lee.androidmvp_10.presenterImp.IOptionDataPresenter;
import com.example.lee.androidmvp_10.view.IViewInfoSaveActivity;

/**
 * Created by Lee on 2016/2/16.
 */
public class OptionDataPresenterImp implements IOptionDataPresenter{

    private IViewInfoSaveActivity mIViewInfoSaveAc;

    private IPersonSaveModel mIPersonSaveModel;

    public OptionDataPresenterImp(IViewInfoSaveActivity activity) {
        mIViewInfoSaveAc = activity;
    }


    @Override
    public void savePersonDate(Context context,PersonBean person) {
        mIPersonSaveModel = new PersonSaveModelImp(context);
        mIPersonSaveModel.savePerson(person);
        mIViewInfoSaveAc.backToMainAc();
    }
}
