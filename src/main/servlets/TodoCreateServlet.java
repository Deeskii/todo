import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.littleworld.todo.model.*;
import com.littleworld.todo.services.*;


@WebServlet("/create")
public class TodoCreateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");


        Todo todo = new Todo(0, task);

        TodoMockService.getInstance().create(todo);
        //TodoJDBCService.getInstance().create(todo);
        response.sendRedirect("list");
    }
}