package com.example.kafkaproducerconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaTemplate<String, Model> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate<String, Model> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void post(@RequestBody Model model) {
        kafkaTemplate.send("myTopic", model);
    }
}
