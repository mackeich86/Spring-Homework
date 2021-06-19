package ru.appline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.Range;
import ru.appline.logic.СompassMap;

import java.util.Arrays;
import java.util.Map;

@RestController
public class СompassController {

    private static final СompassMap model = СompassMap.getInstance();

    @PostMapping(value = "/compass/createCompass", consumes = "application/json", produces = "text/html")
    public String createCompass(@RequestBody Map<String, String> cardinalDirections) {
        for (Map.Entry<String, String> entry : cardinalDirections.entrySet()) {
            int[] range = Arrays.stream(entry.getValue().split("-")).mapToInt(Integer::parseInt).toArray();
            model.add(entry.getKey(), new Range(range[0], range[1]));
        }
        return "<html><h3>Стороны света с диапазонами значений добавлены</h3></html>";
    }

    @GetMapping(value = "/compass/getSide", consumes = "application/json", produces = "application/json")
    public String getSide(@RequestBody Map<String, Integer> degree) {
        return model.getSide(degree.get("Degree"));
    }
}
