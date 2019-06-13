package io.mbab.sda.serwery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping
    String root() {
        return "<h3>Hello</h3>" +
                "<br><button onClick=\"location.href='logs'\"><b>GO_TO_LOGS<b></button></br>" +
                "<br><button onClick=\"location.href='cities'\"><b>GO_TO_CITIES<b></button></br>";
    }
}
