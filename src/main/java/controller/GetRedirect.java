package main.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by junghk on 2016. 8. 3..
 */
public class GetRedirect {

    public static void doGetRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(url);
        view.forward(request, response);
    }
}
