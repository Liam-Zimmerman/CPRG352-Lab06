package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet 
{

    HttpSession session;
    ArrayList<String> items = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

        if (request.getParameter("logout") != null) 
        {
            items.clear();
            session.invalidate();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

        if (request.getParameter("register") != null) 
        {
            session = request.getSession();

            String username = request.getParameter("username");

            session.setAttribute("username", username);

            String url = request.getRequestURL().toString();

            System.out.println(url);

            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        } 
        else if (request.getParameter("add") != null) 
        {
            items.add(request.getParameter("item"));

            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

    }

}
