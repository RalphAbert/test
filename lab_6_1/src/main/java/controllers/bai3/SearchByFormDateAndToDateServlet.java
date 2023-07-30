package controllers.bai3;

import entities.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reponsitories.FavoriteReponsitory;
import services.VideoService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/date3/index",
        "/date3/search"
})
public class SearchByFormDateAndToDateServlet extends HttpServlet {

    private VideoService videoService;

    public SearchByFormDateAndToDateServlet(){
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
        ArrayList<Video> videos = videoService.findAll();
        req.setAttribute("videos",videos);
        req.getRequestDispatcher("/views/bai3/searchByDate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String uri = req.getRequestURI();
       if(uri.contains("search")){
           this.search(req,resp);
       }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Integer fromDate = Integer.parseInt(req.getParameter("fromDate"));
       Integer toDate = Integer.parseInt(req.getParameter("toDate"));
        ArrayList<Video> videos = new FavoriteReponsitory().getVideoWithUserNameByNameQuery(fromDate,toDate);
        req.setAttribute("videos",videos);
        req.getRequestDispatcher("/views/bai3/searchByDate.jsp").forward(req,resp);
    }
}
