package com.example.lee.androidmvp_10.modelImp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lee on 2016/2/25.
 */
public class PersonSaveDBHelper extends SQLiteOpenHelper {

    private static final String PERSON_SAVE_DB = "mvp_person.db";
    public static final String PERSON_TABLE = "person_table";
    public static final int DB_VERSION = 1;

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_PERSON_ID = "person_id";


    public PersonSaveDBHelper(Context context) {
        super(context, PERSON_SAVE_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create db
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE ").append(PERSON_TABLE)
                .append(" ( ")
                .append(COLUMN_ID).append(" INTEGER PRIMARY KEY,")
                .append(COLUMN_NAME).append("  TEXT ,")
                .append(COLUMN_AGE).append("  INTEGER ,")
                .append(COLUMN_PERSON_ID).append("  INTEGER ")
                .append(" ); ");
        db.execSQL(sqlBuilder.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropSql = "DROP TABLE IF EXISTS" + PERSON_TABLE;
        db.execSQL(dropSql);
        //update db
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        //trigger this function  after open db
    }
}
