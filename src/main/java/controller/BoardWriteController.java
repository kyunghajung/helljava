package main.java.controller;

import main.java.model.Board;
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
public class BoardWriteController extends HttpServlet{

    private final BoardService boardService = new BoardService();

    // read, write, update, delete

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String seq = request.getParameter("seq");
        String update = request.getParameter("update");
        String id = (String) session.getAttribute("id");
        String url ="/board/main";

       if(seq != null && seq.length() != 0){
            request.setAttribute("boads", boardService.findOne(seq));
           url = "/board/read.jsp";

           if(update!=null){
               if(update.equals("Y")){
                   url = "/board/update.jsp";
               }else if(update.equals("D")){
                   boardService.delete(seq);
                   request.setAttribute("message", "삭제되었습니다.");
                   request.setAttribute("redirectUrl", "/board/main");
                   url="/logic/alert.jsp";
               }
           }

        } else {
            request.setAttribute("writer", id);
            url = "/board/write.jsp";
        }

        if(id == null || id.length()==0){
            request.setAttribute("message", "로그인 후 이용하실 수 있습니다.");
            request.setAttribute("redirectUrl", "/login");
            url="/logic/alert.jsp";
        }

        doGetRedirect(request, response, url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title   = request.getParameter("title");    // 제목
        String content = request.getParameter("content");  // 내용
        String writer  = request.getParameter("writer");   // 이름
        String seq = request.getParameter("seq");

        Board board = new Board(seq, title, writer, content);

        if(seq == null || seq.length() == 0){
            boardService.create(board);

        } else {
            boardService.update(board, seq);
        }


        response.sendRedirect("/board/main");
    }


}
