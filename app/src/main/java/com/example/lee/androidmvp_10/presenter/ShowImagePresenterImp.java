package com.example.lee.androidmvp_10.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import com.example.lee.androidmvp_10.presenterImp.IShowImagePresenter;
import com.example.lee.androidmvp_10.view.IViewMainActivity;
import com.example.lee.androidmvp_10.viewImp.InfoSaveActivity;

import java.lang.ref.SoftReference;
import java.util.WeakHashMap;

/**
 * Created by Lee on 2016/2/16.
 */
public class ShowImagePresenterImp implements IShowImagePresenter{

    private IViewMainActivity mIViewMainActivity;

    public ShowImagePresenterImp(IViewMainActivity activity){
        mIViewMainActivity = activity;
    }

    WeakHashMap<Integer,SoftReference<BitmapDrawable>>  mBitMapCache;
    private void loadBitMapToCache(Context context,int index,int[] res){
        if (mBitMapCache == null){
            mBitMapCache = new WeakHashMap<>(res.length);
        }
        SoftReference<BitmapDrawable> drawable =  mBitMapCache.get(index);
        if (drawable == null){
            Resources resources = context.getResources();
            drawable = new SoftReference<>(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources,res[index])));
            mBitMapCache.put(index,drawable);
        }
    }

    private BitmapDrawable getBitmapDrawableFromCache(Context context,int index,int[] resId){
        if (mBitMapCache == null) return null;

        SoftReference<BitmapDrawable> drawable =  mBitMapCache.get(index);
        if (drawable != null && drawable.get() != null){
            return drawable.get();
        }else {
            Resources resources = context.getResources();
            drawable = new SoftReference<>(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources,resId[index])));
            mBitMapCache.put(index,drawable);
            return drawable.get();
        }
    }

    @Override
    public void changeImage(Context context, int index, int[] res) {
        int resIndex = index % res.length;
        loadBitMapToCache(context,resIndex, res);
        BitmapDrawable bitmapDrawable = getBitmapDrawableFromCache(context,resIndex, res);
        mIViewMainActivity.changeImageByBitmapCache(bitmapDrawable);
    }

    @Override
    public void goToSaveInfo(Activity ac) {
        Intent intent = new Intent(ac, InfoSaveActivity.class);
        mIViewMainActivity.goToSaveInfo(intent);
    }

}
