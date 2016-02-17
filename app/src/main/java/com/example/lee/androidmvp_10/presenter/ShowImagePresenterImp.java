package com.example.lee.androidmvp_10.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.example.lee.androidmvp_10.presenterImp.IShowImagePresenter;
import com.example.lee.androidmvp_10.view.IViewMainActivity;
import com.example.lee.androidmvp_10.viewImp.MainActivity;

import java.lang.ref.SoftReference;
import java.util.WeakHashMap;

/**
 * Created by Lee on 2016/2/16.
 */
public class ShowImagePresenterImp implements IShowImagePresenter{

    private IViewMainActivity mActivity;

    public ShowImagePresenterImp(MainActivity activity){
        mActivity = activity;
    }

    WeakHashMap<Integer,SoftReference<BitmapDrawable>>  mBitMapCache;
    private void loadBitMapToCache(int index,int[] res){
        if (mBitMapCache == null){
            mBitMapCache = new WeakHashMap<>(res.length);
        }
        SoftReference<BitmapDrawable> drawable =  mBitMapCache.get(index);
        if (drawable == null){
            Resources resources = ((Context) mActivity).getResources();
            drawable = new SoftReference<>(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources,res[index])));
            mBitMapCache.put(index,drawable);
        }
    }

    private BitmapDrawable getBitmapDrawableFromCache(int index,int[] resId){
        if (mBitMapCache == null) return null;

        SoftReference<BitmapDrawable> drawable =  mBitMapCache.get(index);
        if (drawable != null && drawable.get() != null){
            return drawable.get();
        }else {
            Resources resources = ((Context) mActivity).getResources();
            drawable = new SoftReference<>(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources,resId[index])));
            mBitMapCache.put(index,drawable);
            return drawable.get();
        }
    }

    @Override
    public void ChangeImage(ImageView iv, int index, int[] res) {
        int resIndex = index % res.length;
        loadBitMapToCache(resIndex, res);
        BitmapDrawable bitmapDrawable = getBitmapDrawableFromCache(resIndex,res);
        iv.setImageDrawable(bitmapDrawable);
    }

}
