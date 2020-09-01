package jontes.io.cicddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "hello ci/cd demo";
    }

    @GetMapping("/add/{valueOne}/{valueTwo}")
    public String add(@PathVariable int valueOne, @PathVariable int valueTwo) {
        return String.valueOf(valueOne + valueTwo);
    }
}
