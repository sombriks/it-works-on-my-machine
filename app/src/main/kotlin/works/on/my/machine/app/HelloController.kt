package works.on.my.machine.app

import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello() = "Hello!!!!!!!"
}