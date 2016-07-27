package main.java.controller;

import main.java.model.Member;
import main.java.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by junghk on 2016. 7. 28..
 */
public class LoginController extends HttpServlet {

    private final MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher view = request.getRequestDispatcher("/login/login.jsp");
        view.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String id  = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        Member member = memberService.loginCheck(id, pwd);

        if(member != null){
            session.setAttribute("id", id);
            session.setAttribute("pwd", pwd);

            response.sendRedirect("/board/main");
        } else {

            response.sendRedirect("/login");
        }
    }
}
