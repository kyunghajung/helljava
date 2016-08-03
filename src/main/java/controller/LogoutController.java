package main.java.controller;

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
 * Created by junghk on 2016. 8. 2..
 */
public class LogoutController extends HttpServlet{

    private final MemberService memberService = new MemberService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.invalidate();
        request.setAttribute("message", "로그아웃");
        request.setAttribute("redirectUrl", "/login");
        doGetRedirect(request, response,"/logic/alert.jsp");

    }


}
