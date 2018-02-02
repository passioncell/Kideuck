package com.kidueck.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.kidueck.Adapter.ImagePagerAdapter;
import com.kidueck.Concrete.PostingRepository;
import com.kidueck.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by system777 on 2016-07-28.
 */
public class DetailPostImage extends Activity{

    PostingRepository postingRepository = new PostingRepository();
    PhotoViewAttacher mAttacher;
    ImageView attachedImg;
    int selectedPostingId;

    int allImageCnt = 0;

    //뷰페이저
    ImagePagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post_img);

        //postingId 가져오기
        Intent intent = getIntent();
        selectedPostingId = Integer.parseInt(intent.getStringExtra("selectedPostingId"));

        //postingImageCount 가져오기
        new GetPostingImageCnt().execute(selectedPostingId);


    }





    private class GetPostingImageCnt extends AsyncTask<Integer, Void, Void> {

        ProgressDialog progressDialog;

        @Override
        protected Void doInBackground(Integer... params) {
            try
            {
                allImageCnt = postingRepository.getImageCnt(params[0]);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();

            //뷰페이저 초기화
            mCustomPagerAdapter = new ImagePagerAdapter(getApplicationContext(), selectedPostingId, allImageCnt);
            mViewPager = (ViewPager) findViewById(R.id.vp_detail_img);
            mViewPager.setAdapter(mCustomPagerAdapter);

//            attachedImg = (ImageView) findViewById(R.id.iv_detail_attached_img2);
//            Picasso.with(getApplicationContext()).load(new URLInfo().getPostImgUploadUrl() +selectedPostingId + "/1.jpg").into(attachedImg);
//            mAttacher = new PhotoViewAttacher(attachedImg);
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(DetailPostImage.this);
            progressDialog.setMessage("사진정보 가져오는중..");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

    }

}
