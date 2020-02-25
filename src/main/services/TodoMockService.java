import java.util.List;
import java.util.ArrayList;
import com.littleworld.todo.model.*;

public class TodoMockService {

    // create singleton
    private static TodoMockService instance = new TodoMockService();

    public static TodoMockService getInstance() {
        return instance;
    }

    private TodoMockService() {}

    // generate id with auto increment
    int uniqueId = 1;

    List<Todo> todos = new ArrayList<Todo>();

    public Todo create(Todo todo ) {
        todo.setId(uniqueId++);
        todos.add(todo);
        return todo;
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo findById(int id) {
        return todos.get(id);
    }

    public void delete(int id) {
        for (int i = 0; i <  todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                todos.remove(i);
                break;
            }
        }
    }
}
