package com.yaoyi.myintergration.Header;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yaoyi.myintergration.MaterialViewPagerAnimator;
import com.yaoyi.myintergration.MaterialViewPagerHelper;
import com.yaoyi.myintergration.Utils;

/**
 * Created by c on 2018/1/23.
 */

public class MaterialViewPagerHeaderDecorator extends RecyclerView.ItemDecoration {


    boolean registered = false;//未注册

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        final RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(view);//猜想view是recicleview中的每一个view吧
        final Context context = recyclerView.getContext();

        if(!registered) {
            MaterialViewPagerHelper.registerRecyclerView(context, recyclerView);//这里应该是注册当前的recycleview，使其接收scroll动作
            registered = true;
        }

        int headerCells = 1;

        //don't work with stagged
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();//拿到布局管理器
        if(layoutManager instanceof GridLayoutManager){
            GridLayoutManager gridLayoutManager = (GridLayoutManager)layoutManager;
            headerCells = gridLayoutManager.getSpanCount();//拿到
        }

        MaterialViewPagerAnimator animator = MaterialViewPagerHelper.getAnimator(context);
        if (animator != null) {
            if (holder.getAdapterPosition() < headerCells) {
                outRect.top = Math.round(Utils.dpToPx(animator.getHeaderHeight() + 10, context));
            }
        }
    }
}
