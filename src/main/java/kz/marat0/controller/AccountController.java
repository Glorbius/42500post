package kz.marat0.controller;

import kz.marat0.data.ElasticBase;
import kz.marat0.model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/42500.enbek.kz")
public class AccountController {

    @Autowired
    private ElasticBase elasticrepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping(path = "/accounts/canhelp", produces = "application/json")
    //Можно ли получить выплату (json)
    public @ResponseBody
    String needhelp(@RequestBody Accounts accounts) {

        String answer = null;
        if (elasticrepository.findByIin(accounts.getIin()) == null) {

            answer = "Нет такого ИИН в базе данных";
        } else {

            for (Accounts s : elasticrepository.findByIin(accounts.getIin()))
                if (!s.isStatus()) {
                    answer = "Вы можете получить выплату 42500 тг.";
                } else {
                    answer = "Вам отказано!";
                }
        }
        return answer;
    }


    @GetMapping("/accounts/help")
//Можно ли получить выплату (параметры)
    String getByIin(@RequestParam(value = "iin") long iin) {

        String answer = null;
        if (elasticrepository.findByIin(iin) == null) {

            answer = "Нет такого ИИН в базе данных";
        } else {

            for (Accounts a : elasticrepository.findByIin(iin))
                if (!a.isStatus()) {
                    answer = "Вы можете получить выплату 42500 тг.";
                } else {
                    answer = "Вам отказано!";
                }
        }
        return answer;
    }


    @PostMapping(value = "/accounts/ad")
    //Отправка через param
    public void sendOrder(String accounts) {

        kafkaTemplate.send("addPeoples", accounts);
    }


    @PostMapping(value = "/accounts/add", produces = "application/json") // //Отправка через json
    public @ResponseBody
    void addNew(@RequestBody String accounts) throws IOException {

        kafkaTemplate.send("addPeoples", accounts);

    }
}





