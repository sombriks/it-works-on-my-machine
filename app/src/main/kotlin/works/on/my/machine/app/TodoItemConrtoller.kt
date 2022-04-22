package works.on.my.machine.app

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class TodoItemController(var itemRepository: TodoItemRepository) {

    @GetMapping("/todo/{id}/items")
    fun list(@PathVariable("id") id: Long) = itemRepository.findByTodoListId(id)

    @PostMapping("/todo/{id}/item")
    fun add(
        @PathVariable("id") id: Long,
        @RequestBody item: TodoItem
    ): TodoItem {
        item.todoListId = id
        itemRepository.save(item)
        return item
    }

    @PutMapping("/todo/{id}/item")
    fun update(
        @PathVariable("id") id: Long,
        @RequestBody item: TodoItem
    ): TodoItem {
        val itemId: Long = item.id ?: -1
        itemRepository.findById(itemId).orElseThrow {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "item not found"
            )
        }
        item.todoListId = id
        itemRepository.save(item)
        return item
    }

    @DeleteMapping("/todo/item/{id}")
    fun remove(@PathVariable("id") id: Long): String {
        itemRepository.deleteById(id)
        return "ok"
    }

}