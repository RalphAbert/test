package services;


import entities.Favorite;
import entities.User;
import entities.Video;
import reponsitories.FavoriteReponsitory;

import java.util.ArrayList;

public class FavoriteService {
    private FavoriteReponsitory favoriteReponsitory;

    public FavoriteService(){
        this.favoriteReponsitory = new FavoriteReponsitory();
    }

    public ArrayList<Favorite> findAll(){
        return this.favoriteReponsitory.findAll();
    }

    public Favorite findOne(String ma){
        return this.favoriteReponsitory.findOne(ma);
    }

    public ArrayList<Video> getVideoByIDUser(String id){
        ArrayList<Video> favorites = new ArrayList<>();
        for(Favorite favorite : this.favoriteReponsitory.findAll()){
            if(favorite.getUser().getId().equalsIgnoreCase(id)){
                favorites.add(favorite.getVideo());
            }
        }
        return favorites;
    }

    public static void main(String[] args) {
        System.out.println(new FavoriteService().getVideoByIDUser("U2"));
    }

    public ArrayList<Video> getVideoWithTitle(String title) {
        return this.favoriteReponsitory.getVideoWithTitle(title);
    }

    public ArrayList<User> getVideoWithidVideo(String title) {
        return this.favoriteReponsitory.getVideoWithidVideo(title);
    }

    public ArrayList<Video> getFavariteWithCheck(String check) {
        return this.favoriteReponsitory.getFavariteWithCheck(check);
    }

}
