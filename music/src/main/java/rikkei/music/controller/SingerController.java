package rikkei.music.controller;

import rikkei.music.model.Singer;
import rikkei.music.service.singer.ISingerService;
import rikkei.music.service.singer.SingerServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({"/", "/singer"})
public class SingerController extends HttpServlet {
    private ISingerService singerService = new SingerServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreateSinger(request, response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                fromDeleteSinger(request,response);
                break;
            case "detail":
                formDetailSinger(request,response);
                break;
            default:
                showListSinger(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                actionCreate(request, response);
                break;
            case "edit":
                actionEdit(request, response);
                break;
            case "delete":
                actionDeleteSinger(request,response);
                break;
            default:
                actionSearch(request,response);



                
        }
    }

    private void actionSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Singer> studentListSearch = singerService.findByName(name);
        request.setAttribute("listStudent", studentListSearch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/list.jsp");
        dispatcher.forward(request, response);
        System.out.println("==================tìm ==== "+singerService.findByName(name));
    }
//DELETE
    private void actionDeleteSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        singerService.deleteById(id);
        request.setAttribute("message", "Delete success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void fromDeleteSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Singer singer = singerService.findById(id);
//        System.out.println("singer show ---> "+singer);
        request.setAttribute("singer",singer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/delete.jsp");
        dispatcher.forward(request, response);
    }

    //DETAIL
    private void formDetailSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Singer singer = singerService.findById(id);
        request.setAttribute("student",singer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/detail.jsp");
        dispatcher.forward(request, response);
    }
//CREATE
    public void showListSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Singer> singerList = singerService.findAll();
//        request.setAttribute("listSinger", singerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/list.jsp");
        dispatcher.forward(request, response);
    }

    public void showFormCreateSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/create.jsp");
        dispatcher.forward(request, response);
    }

    public void actionCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        Singer singer = new Singer(name, age, sex);
        singerService.save(singer);
        request.setAttribute("message", "Create Singer success !!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/create.jsp");
        dispatcher.forward(request, response);
    }



    public void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Singer singer = singerService.findById(id);
//        System.out.println("singer show ---> "+singer);
        request.setAttribute("singer",singer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Singer singer = singerService.findById(id);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        singer.setName(name);
        singer.setAge(age);
        singer.setSex(sex);
        singerService.save(singer);
        request.setAttribute("message", "Edit success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/singer/edit.jsp");
        dispatcher.forward(request, response);

    }
}
