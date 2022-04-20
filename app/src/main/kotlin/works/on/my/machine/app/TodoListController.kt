package works.on.my.machine.app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoListController(var repository: TodoListRepository) {
    @GetMapping("/todos")
    fun list(): List<TodoList> {
        return repository.findAll()
    }
}