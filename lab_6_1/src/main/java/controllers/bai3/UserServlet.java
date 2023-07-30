package controllers.bai3;


import entities.User;
import entities.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reponsitories.FavoriteReponsitory;
import services.FavoriteService;
import services.UserService;
import services.VideoService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/user3/index",
        "/user3/search"
})
public class UserServlet extends HttpServlet {

    private UserService userService;

    private FavoriteService favoriteService;

    private VideoService videoService;

    public UserServlet(){
        this.userService = new UserService();
        this.favoriteService = new FavoriteService();
        this.videoService = new VideoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("index")){
            this.index(req,resp);
        }
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // hàm hiển thị ra danh sách các user tương ứng
        ArrayList<Video> videos = videoService.findAll();
        req.setAttribute("videos",videos);
        req.getRequestDispatcher("/views/bai3/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("search")){
            this.search(req,resp);
        }else if(uri.contains("title")){
            this.searchWithTitle(req,resp);
        }
    }

    private void searchWithTitle(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
       ArrayList<Video> list = new FavoriteReponsitory().getVideoWithUserNameByNameQuery(username);
       User user = userService.findOne(username);

       req.setAttribute("user",user);
       req.setAttribute("videos",list);
       req.getRequestDispatcher("/views/bai3/index.jsp").forward(req,resp);
    }
}
