package main.java.controller;

import main.java.model.Member;
import main.java.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by junghk on 2016. 7. 28..
 */
public class JoinController extends HttpServlet{

    private static MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/login/join.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id  = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        if(id == null || id.length() == 0){
            // exception
            response.sendRedirect("/join");

        } else if(pwd == null || pwd.length() == 0) {
            // exception
            response.sendRedirect("/join");

        } else {
            Member member = new Member(id, pwd);
            memberService.join(member);

            response.sendRedirect("/login");
        }

    }
}
