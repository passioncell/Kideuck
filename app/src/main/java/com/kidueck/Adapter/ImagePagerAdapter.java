package com.kidueck.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kidueck.Common.URLInfo;
import com.kidueck.R;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by system777 on 2016-08-13.
 */
public class ImagePagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    PhotoViewAttacher mAttacher;
    int selectedPostingId;
    int maxCnt;

    public ImagePagerAdapter(Context context,int selectedPostingId, int maxCnt) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.selectedPostingId = selectedPostingId;
        this.maxCnt = maxCnt;
    }

    @Override
    public int getCount() {
        return maxCnt;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item_detail_img, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_detail_attached_img2);

        Picasso.with(mContext).load(new URLInfo().getPostImgUploadUrl() +selectedPostingId + "/"+
                String.valueOf(position+1)+".jpg").into(imageView);
        mAttacher = new PhotoViewAttacher(imageView);


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
