package com.example.previewpicture.pager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.previewpicture.ImageUrlConfig;
import com.example.previewpicture.R;
import com.example.previewpicture.bean.UserViewInfo;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ArrayList<UserViewInfo> mThumbViewInfoList = new ArrayList<>();
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        mViewPager = findViewById(R.id.mViewPager);
        //准备数据
        List<String> urls = ImageUrlConfig.getUrls();
        for (int i = 0; i < 1; i++) {
            mThumbViewInfoList.add(new UserViewInfo(urls.get(i)));
        }
        MyPagerAdapter adapter = new MyPagerAdapter(mThumbViewInfoList, this);
        mViewPager.setAdapter(adapter);
    }
}
