package main.java.controller;

import main.java.service.BoardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static main.java.controller.GetRedirect.doGetRedirect;

/**
 * Created by junghk on 2016. 7. 27..
 */
public class BoardController extends HttpServlet{

    private final BoardService boardService = new BoardService();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String url = "/board/main.jsp";
        String id = (String) session.getAttribute("id");
        String seq = request.getParameter("seq");
        String findPart = request.getParameter("findPart");
        String findCont = request.getParameter("findCont");


        if (seq != null && seq.length() != 0){
            url = "/board/read.jsp";
            request.setAttribute("boads", boardService.findOne(seq));
            System.out.println(boardService.findOne(seq));

        } else if( findCont == null || findCont.length() == 0) {
            request.setAttribute("boadsList", boardService.findAll());
        } else {
            request.setAttribute("boadsList", boardService.searchBoards(findPart, findCont));
        }


        if(id != null && id.length() != 0){
            request.setAttribute("memberYn", "Y");
        } else {
            request.setAttribute("message", "로그인하셔야 이용하실 수 있습니다");
            request.setAttribute("redirectUrl", "/login");
            url = "/logic/alert.jsp";
        }


        doGetRedirect(request, response, url);
    }


}
