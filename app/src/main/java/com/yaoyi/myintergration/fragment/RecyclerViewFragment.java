package com.yaoyi.myintergration.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaoyi.myintergration.Header.MaterialViewPagerHeaderDecorator;
import com.yaoyi.myintergration.R;
import com.yaoyi.myintergration.TestRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by c on 2018/1/23.
 */

public class RecyclerViewFragment extends BaseFragment {

    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 5;

    @BindView(R.id.recyclerView2)
    RecyclerView mRecyclerView;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);//设置布局，这里添加的
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        final List<Object> items = new ArrayList<>();

        for (int i = 0; i < ITEM_COUNT; ++i) {
            items.add(new Object());//添加 ITEM_COUNT 个对象
        }




        //setup materialviewpager

        if (GRID_LAYOUT) {
            //添加网格布局
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            //添加线性布局
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        //使RecycleView的大小不随内容改变，这样可以优化性能
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());//为RecycleView的头部item添加与ViewPagerStrip之间的间距
        mRecyclerView.setAdapter(new TestRecyclerViewAdapter(items));//为RecycleView添加Adapter
    }

    @Override
    public int getLayoutResources() {
        return 0;
    }

    @Override
    public void initView() {

    }
}
