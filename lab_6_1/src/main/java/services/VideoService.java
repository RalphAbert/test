package services;


import entities.Video;
import reponsitories.VideoReponsitory;

import java.util.ArrayList;

public class VideoService {

    private VideoReponsitory videoReponsitory;

    public VideoService(){
        this.videoReponsitory = new VideoReponsitory();
    }

    public ArrayList<Video> findAll(){
        return this.videoReponsitory.findAll();
    }

    public Video findOne(String ma){
        return this.videoReponsitory.findOne(ma);
    }

    public static void main(String[] args) {
        ArrayList<Video> videos = new VideoService().findAll();
        System.out.println(videos);
    }
}
