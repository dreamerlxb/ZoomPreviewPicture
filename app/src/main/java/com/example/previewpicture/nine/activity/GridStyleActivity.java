package com.example.previewpicture.nine.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.previewpicture.R;
import com.example.previewpicture.bean.UserViewInfo;
import com.example.previewpicture.nine.adapter.PostAdapter;
import com.example.previewpicture.nine.entity.Post;
import com.jaeger.ninegridimageview.NineGridImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Jaeger on 16/2/24.
 * <p>
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */
public class GridStyleActivity extends BaseActivity {

    private RecyclerView mRvPostLister;
    private PostAdapter mNineImageAdapter;
    private List<Post> mPostList;
    private String[] IMG_URL_LIST = {
            "http://img44.photophoto.cn/20170731/0847085207211178_s.jpg",
            "http://img44.photophoto.cn/20170728/0017030319740534_s.jpg",
            "http://img44.photophoto.cn/20170731/0838084002855326_s.jpg",
            "http://img44.photophoto.cn/20170728/0847085969586424_s.jpg",
            "http://img44.photophoto.cn/20170727/0014105802293676_s.jpg",
            "http://img44.photophoto.cn/20170729/0847085226124343_s.jpg",
            "http://img44.photophoto.cn/20170728/0847085200668628_s.jpg",
            "http://img44.photophoto.cn/20170728/0847085246003750_s.jpg",
            "http://img44.photophoto.cn/20170728/0847085012707934_s.jpg",
            "http://img44.photophoto.cn/20170729/0005018303330857_s.jpg",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.activity_recycler);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        mRvPostLister = findViewById(R.id.rv_post_list);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        mRvPostLister.setLayoutManager(manager);
        mPostList = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            List<UserViewInfo> imgUrls = new ArrayList<>();
            UserViewInfo userViewInfo;
            Random ss = new Random();
            for (int j = 0; j < ss.nextInt(9); j++) {
                userViewInfo = new UserViewInfo(IMG_URL_LIST[j]);
                imgUrls.add(userViewInfo);
            }
            Post post = new Post("Am I handsome? Am I handsome? Am I handsome?", imgUrls);
            mPostList.add(post);
        }

        mNineImageAdapter = new PostAdapter(this, mPostList, NineGridImageView.STYLE_GRID);
        mRvPostLister.setAdapter(mNineImageAdapter);
        manager.scrollToPositionWithOffset(5, 0);
        mRvPostLister.post(new Runnable() {
            @Override
            public void run() {
                View view = manager.findViewByPosition(1);
                if (view != null) System.out.println(view.getMeasuredHeight());
            }
        });
    }
}

