package works.on.my.machine.app

import org.springframework.web.bind.annotation.RestController

@RestController
class TodoItemController(var repository: TodoItemRepository) {

    fun add(item: TodoItem): TodoItem {
        return null
    }

    fun update(id: Long, item: TodoItem): TodoItem {
        return null
    }

    fun remove(id: Long): String {
        return "ok"
    }

}