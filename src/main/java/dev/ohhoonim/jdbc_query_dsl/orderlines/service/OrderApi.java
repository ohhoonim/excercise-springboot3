package dev.ohhoonim.jdbc_query_dsl.orderlines.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ohhoonim.jdbc_query_dsl.orderlines.model.OrderLinesService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/orderlines")
@RequiredArgsConstructor
public class OrderApi {

    private final OrderLinesService orderLinesStory;
    
    @GetMapping("/test")
    public String orderlinesTest() {
        orderLinesStory.sendEvent();

        return "success";
    }
    
}
