package com.example.kafkaproducerconsumer;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;

    @Autowired
    public KafkaController(KafkaTemplate<String, String> kafkaTemplate,
                           Gson jsonConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping
    public void post(@RequestBody Model model) {
        kafkaTemplate.send("myTopic", jsonConverter.toJson(model));
    }

    @PostMapping("/v2")
    public void post(@RequestBody SimpleModel model) {
        kafkaTemplate.send("myTopic2", jsonConverter.toJson(model));
    }

    @KafkaListener(topics = "myTopic")
    public void getFromKafka(String model) {
        System.out.println(model);
        Model simpleModel = jsonConverter.fromJson(model, Model.class);
        System.out.println(simpleModel.toString());
    }

    @KafkaListener(topics = "myTopic2")
    public void getFromKafkaSecondVersion(String model) {
        System.out.println(model);
        SimpleModel simpleModel = jsonConverter.fromJson(model, SimpleModel.class);
        System.out.println(simpleModel.toString());
    }
}
