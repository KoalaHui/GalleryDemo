package com.gellarydemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVpcontent;
    private RelativeLayout mRlcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVpcontent = (ViewPager) findViewById(R.id.vp_content);
        mRlcontent = (RelativeLayout) findViewById(R.id.rl_content);

        initView();
    }

    private void initView() {
        mVpcontent.setAdapter(new HomeContentAdapter(this));
        mVpcontent.setOffscreenPageLimit(3);
        //设置page之间的距离
        mVpcontent.setPageMargin(10);
        //设置缩放及透明度
        mVpcontent.setPageTransformer(true, new ScalePageTransformer());
        //监听viewpager滑动，在page滑动的时候一直去更新界面
        mVpcontent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mVpcontent != null) {
                    mVpcontent.invalidate();
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRlcontent.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 这是让整个View随着触摸而滑动
                return mVpcontent.dispatchTouchEvent(event);
            }
        });
    }
}
