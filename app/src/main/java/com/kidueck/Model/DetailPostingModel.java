package com.kidueck.Model;

/**
 * Created by system777 on 2016-06-27.
 */
public class DetailPostingModel {
    public String writtenDate;
    public String content;
    public int isUpDown;
    public boolean isImage;
    public int imageCnt;

    public DetailPostingModel(){

    }
    public DetailPostingModel(String writtenDate, String content, int isUpDown, boolean isImage, int imageCnt) {
        this.writtenDate = writtenDate;
        this.content = content;
        this.isUpDown = isUpDown;
        this.isImage = isImage;
        this.imageCnt = imageCnt;
    }

    public String getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(String writtenDate) {
        this.writtenDate = writtenDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsUpDown() {
        return isUpDown;
    }

    public void setIsUpDown(int isUpDown) {
        this.isUpDown = isUpDown;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setIsImage(boolean isImage) {
        this.isImage = isImage;
    }

    public int getImageCnt() {
        return imageCnt;
    }

    public void setImageCnt(int imageCnt) {
        this.imageCnt = imageCnt;
    }
}
