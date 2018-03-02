package com.yaoyi.myintergration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


/**
 * Created by c on 2018/1/22.
 */

public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;//抽屉不觉
    private ActionBarDrawerToggle mDrawerToggle;//反转布局

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!BuildConfig.DEBUG) {//非调试模式下
                //TODO 1 配置崩溃返回框架   Fabric
//            Fabric.with(this, new Crashlytics());//使用Crashlytics将崩溃信息返回
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);//抽屉布局
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);//新建反转对象
        mDrawer.setDrawerListener(mDrawerToggle);//为抽屉布局设置反转

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//设置向左箭头图标
            actionBar.setDisplayShowHomeEnabled(true);//设置向左图标显示
            actionBar.setDisplayShowTitleEnabled(true);//设置可以使用标题
            actionBar.setDisplayUseLogoEnabled(false);//可以使用logo
            actionBar.setHomeButtonEnabled(true);//向左图标可以点击
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {//官方推荐配置，在Activity的配置更改后自动调用此函数
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) ||
                super.onOptionsItemSelected(item);
    }
}
