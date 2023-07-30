package controllers.bai2;


import entities.Report;
import entities.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reponsitories.ReportReponsitory;
import services.FavoriteService;
import services.UserService;
import services.VideoService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/report/index"// videotrongngay
})
public class reportServlet extends HttpServlet {

    private UserService userService;

    private FavoriteService favoriteService;

    private VideoService videoService;

    private ReportReponsitory reportReponsitory;

    public reportServlet(){
        this.userService = new UserService();
        this.favoriteService = new FavoriteService();
        this.videoService = new VideoService();
        this.reportReponsitory = new ReportReponsitory();
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
        ArrayList<Report> reports = reportReponsitory.getFavariteWithCheck();
        req.setAttribute("reports",reports);
        req.getRequestDispatcher("/views/bai2/report.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
         if(uri.contains("search")){
            this.search(req,resp);
        }
    }



    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String check = req.getParameter("favorite");
       ArrayList<Video> list = favoriteService.getFavariteWithCheck(check);

       req.setAttribute("videos",list);
        req.getRequestDispatcher("/views/bai2/favorite.jsp").forward(req,resp);
    }
}
