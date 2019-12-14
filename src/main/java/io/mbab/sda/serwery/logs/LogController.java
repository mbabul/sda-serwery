package io.mbab.sda.serwery.logs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
@Slf4j
public class LogController {

    @GetMapping
    String menu() {
        return "<button onClick=\"location.href='logs/generate'\"><b>GENERATE_LOGS<b></button>";
    }

    @GetMapping("/generate")
    void generate() {
        log.debug("Generated DEBUG log");
        log.info("Generated INFO log");
        log.warn("Generated WARN log");
        log.error("Generated ERROR log");
    }
}
