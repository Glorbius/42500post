package kz.marat0.model;

import kz.marat0.model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping(path = "/42500.enbek.kz")
public class ControllerKafka {


    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping(value = "/ad")
    public void sendOrder(String accounts){

        kafkaTemplate.send("addPeoples",accounts);
    }

    @PostMapping(value = "/add", produces = "application/json") // Добавить
    public @ResponseBody
    void addNew(@RequestBody String accounts) throws IOException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        kafkaTemplate.send("addPeoples",accounts);
    }
}
