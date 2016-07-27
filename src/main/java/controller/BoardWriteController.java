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

/**
 * Created by junghk on 2016. 7. 27..
 */
public class BoardWriteController extends HttpServlet{

    private final BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String seq = request.getParameter("seq");
        RequestDispatcher view = request.getRequestDispatcher("/board/write.jsp");

        if(seq != null && seq.length() != 0){
            request.setAttribute("boads", boardService.findOne(seq));
        }

        request.setAttribute("writer", session.getAttribute("id"));
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title   = request.getParameter("title");    // 제목
        String content = request.getParameter("content");  // 내용
        String writer  = request.getParameter("writer");   // 이름
        String seq = request.getParameter("seq");

        Board board = new Board(title, writer, content);

        if(seq == null || seq.length() == 0){
            boardService.create(board);

        } else {
            boardService.update(board, seq);
        }


        response.sendRedirect("/board/main");
    }
}
