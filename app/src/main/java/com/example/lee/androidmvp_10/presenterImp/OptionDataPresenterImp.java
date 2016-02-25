package com.example.lee.androidmvp_10.presenterImp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.lee.androidmvp_10.model.IPersonSaveModel;
import com.example.lee.androidmvp_10.model.bean.PersonBean;
import com.example.lee.androidmvp_10.modelImp.PersonSaveModelImp;
import com.example.lee.androidmvp_10.presenter.IOptionDataPresenter;
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
    public void savePersonDate(Context context, EditText nameEt, EditText ageEt, EditText idEt) {
        PersonBean person = new PersonBean();
        if (idEt != null && !TextUtils.isEmpty(idEt.getText().toString()))person.id = Long.valueOf(idEt.getText().toString());
        if (nameEt != null  && !TextUtils.isEmpty(nameEt.getText().toString()))person.name = nameEt.getText().toString();
        if (ageEt != null && !TextUtils.isEmpty(ageEt.getText().toString()))person.age = Integer.parseInt(ageEt.getText().toString());
        mIPersonSaveModel = new PersonSaveModelImp(context);
        mIPersonSaveModel.savePerson(person);
        mIViewInfoSaveAc.backToMainAc();
    }
}
