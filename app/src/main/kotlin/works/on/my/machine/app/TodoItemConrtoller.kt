package works.on.my.machine.app

import org.springframework.web.bind.annotation.RestController

@RestController
class TodoItemController(var repository: TodoItemRepository) {

}