package com.example.lee.androidmvp_10.modelImp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.lee.androidmvp_10.model.IPersonSaveModel;
import com.example.lee.androidmvp_10.model.bean.PersonBean;

/**
 * Created by pan_li on 2016/2/25.
 */
public class PersonSaveModelImp implements IPersonSaveModel{

    private Context mContext;

    public PersonSaveModelImp(Context context){
        mContext = context;
    }

    @Override
    public void savePerson(PersonBean person) {
        PersonSaveDBHelper dbHelper = new PersonSaveDBHelper(mContext);
        SQLiteDatabase db =  dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PersonSaveDBHelper.COLUMN_NAME,person.name);
        values.put(PersonSaveDBHelper.COLUMN_AGE,person.age);
        values.put(PersonSaveDBHelper.COLUMN_PERSON_ID,person.id);
        db.insert(PersonSaveDBHelper.PERSON_TABLE,null,values);
    }
}
