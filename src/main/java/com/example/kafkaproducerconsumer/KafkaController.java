package com.example.kafkaproducerconsumer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka ")
public class KafkaController {

    public void post(@RequestBody Model model) {

    }
}
