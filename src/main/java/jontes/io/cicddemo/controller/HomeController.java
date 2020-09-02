package jontes.io.cicddemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class HomeController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
    public String home() {
        return welcomeMessage;
    }

    @GetMapping("/add/{valueOne}/{valueTwo}")
    public String add(@PathVariable int valueOne, @PathVariable int valueTwo) {
        return String.valueOf(valueOne + valueTwo);
    }
}
