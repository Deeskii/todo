import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.littleworld.todo.model.*;
import com.littleworld.todo.services.*;

@WebServlet("/list")
public class TodoListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        List<Todo> todos = TodoMockService.getInstance().findAll();
        //List<Todo> todos = TodoJDBCService.getInstance().findAll();
        request.setAttribute("todos", todos);
        request.getServletContext().getRequestDispatcher("/todoList.jsp").forward(request, response);
    }
}
