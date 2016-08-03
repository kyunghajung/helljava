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

import static main.java.controller.GetRedirect.doGetRedirect;

/**
 * Created by junghk on 2016. 7. 28..
 */
public class LoginController extends HttpServlet {

    private final MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getSession().invalidate();
        doGetRedirect(request, response, "/login/login.jsp");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String id  = request.getParameter("id");
        String pwd = request.getParameter("pwd");


        System.out.println(id);
        System.out.println(pwd);

        Member member = memberService.loginCheck(id, pwd);

        if(member != null){
            session.setAttribute("id", id);
            session.setAttribute("pwd", pwd);
            response.sendRedirect("/board/main");
        } else {
            request.setAttribute("message", "아이디, 비밀번호를 확인해주세요");
            request.setAttribute("redirectUrl", "/login");
            doGetRedirect(request, response,"/logic/alert.jsp");
        }


    }




}
