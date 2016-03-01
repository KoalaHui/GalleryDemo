package com.gellarydemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @创建者 luhui
 * @创时间 2016-03-01 14:53
 * @描述 TODO
 */
public class HomeContentAdapter extends PagerAdapter {
    private static final String TAG = "HomeContentAdapter";
    private Context mContext;
  private int[] datas ={R.mipmap.guide01,R.mipmap.guide02,R.mipmap.guide03,R.mipmap.guide01,R.mipmap.guide02,R.mipmap.guide03};

    public HomeContentAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(mContext);
                imageView.setImageResource(datas[position]);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
