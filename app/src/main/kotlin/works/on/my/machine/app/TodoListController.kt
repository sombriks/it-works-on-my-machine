package works.on.my.machine.app

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@RestController
class TodoListController(var repository: TodoListRepository) {
    @GetMapping("/todos")
    fun list(): List<TodoList> = repository.findAll()

    @GetMapping("/todo/{id}")
    fun find(@PathVariable("id") id: Long): TodoList =
        repository.findById(id).orElseThrow {
            ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "TODO does not exists"
            )
        }

    @PostMapping("/todo")
    fun save(@RequestBody todo: TodoList): TodoList = repository.save(todo)

    @PutMapping("/todo/{id}")
    fun update(
        @PathVariable("id") id: Long,
        @RequestBody todo: TodoList
    ): TodoList {
        repository.findById(id).orElseThrow {
            ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "TODO does not exists"
            )
        }
        todo.id = id
        todo.updatedAt = LocalDateTime.now()
        return repository.save(todo)
    }

    @DeleteMapping("/todo/{id}")
    fun remove(@PathVariable("id") id: Long): String {
        repository.findById(id).orElseThrow {
            ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "TODO does not exists"
            )
        }
        repository.deleteById(id)
        return "ok";
    }

}