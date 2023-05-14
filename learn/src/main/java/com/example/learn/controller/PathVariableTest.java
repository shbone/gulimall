package com.example.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Map;

@Slf4j
@RestController
public class PathVariableTest {
    @RequestMapping("/list/{id}/")
    public String get(@PathVariable Integer id, @RequestParam Map<String, Object> map) {
        map.forEach((k, v) -> {
            System.out.println(k + v);
        });
        log.info(map.toString());
        return id + "_";
    }

}
