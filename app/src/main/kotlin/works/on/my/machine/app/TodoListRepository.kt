package works.on.my.machine.app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoListRepository : JpaRepository<TodoList, Long>