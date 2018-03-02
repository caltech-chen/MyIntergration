package com.yaoyi.myintergration;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.yaoyi.myintergration.Header.HeaderDesign;
import com.yaoyi.myintergration.fragment.BaseFragment;
import com.yaoyi.myintergration.fragment.FindFragment;
import com.yaoyi.myintergration.fragment.HomeFragment;
import com.yaoyi.myintergration.fragment.RecyclerViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by c on 2018/1/22.
 */

public class MainActivity extends DrawerActivity {
    @BindView(R.id.materialViewPager)//主界面为materialViewPager和drawlayout组成，这里绑定主界面
            MaterialViewPager mViewPager;
    private HomeFragment homeFragment;
    private FindFragment findFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        ButterKnife.bind(this);//butterknife配置基本不走
        final Toolbar toolbar = mViewPager.getToolbar();//获得布局中的toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar);//此处将toolbar变成Actionbar，然后在父类DrawActivity中调用onStart进行配置该Actionbar
        }
        if (homeFragment == null)
            homeFragment = new HomeFragment();

        if (findFragment == null)
            findFragment = new FindFragment();
        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public BaseFragment getItem(int position) {//设置Material 中的viewpager的Adapter，也就是PagerTitleStrip的下部分
                switch (position % 4) {
                    case 0:
                        return homeFragment;
                    case 1:
                        return findFragment;
                    case 2:
//                      return WebViewFragment.newInstance();
                        return RecyclerViewFragment.newInstance();
                    case 3:
                        return RecyclerViewFragment.newInstance();

//                    default:
//                        return RecyclerViewFragment.newInstance();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 4;
            }//Viewpager页面数量

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {//viewpager页面标题
                    case 0:
                        return "首页";
                    case 1:
                        return "发现";
                    case 2:
                        return "热门";
                    case 3:
                        return "我的";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {//viewpager滑动监听器
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());//限制viewpager的数量
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());//设置对应的PaperTitleStrip

        final View logo = findViewById(R.id.logo_white);//设置logo的点击事件
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });


        }


    }


}
