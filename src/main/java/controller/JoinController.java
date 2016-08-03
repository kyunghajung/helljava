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
public class JoinController extends HttpServlet{

    private static MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getSession().invalidate();

        doGetRedirect(request, response, "/login/join.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id  = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        if(id != null && id.length()!= 0 && pwd != null && pwd.length()!= 0){
            Member member = new Member(id, pwd);
            memberService.join(member);
            response.sendRedirect("/login");
        } else {
            request.setAttribute("message", "아이디, 비밀번호를 입력해주세요");
            request.setAttribute("redirectUrl", "/join");
            doGetRedirect(request, response,"/logic/alert.jsp");
        }

    }

}
