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
import java.util.Arrays;
import java.util.List;

@WebServlet({
        "/month3/index",
        "/month3/search"
})
public class SearchByMonthServlet extends HttpServlet {

    private VideoService videoService;

    public SearchByMonthServlet(){
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
        req.getRequestDispatcher("/views/bai3/searchByMonth.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String uri = req.getRequestURI();
       if(uri.contains("search")){
           this.search(req,resp);
       }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> lists = Arrays.asList(req.getParameterValues("months"));
        List<Integer> months = new ArrayList<>();
        for(String month:lists){
            months.add(Integer.parseInt(month));
        }
        ArrayList<Video> videos = new FavoriteReponsitory().getVideoWithMonthByNameQuery(months);
        req.setAttribute("videos",videos);
        req.getRequestDispatcher("/views/bai3/searchByMonth.jsp").forward(req,resp);
    }
}
