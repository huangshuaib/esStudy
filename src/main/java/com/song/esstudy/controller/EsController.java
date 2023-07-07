package com.song.esstudy.controller;

import com.song.esstudy.highclient.RestHighLevelClientService;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
/**
 * @author huangshuai
 * @date 2023/7/7
 */
@RestController
public class EsController {

    @Autowired
    RestHighLevelClientService service;

    @GetMapping("/es")
    public String testHigh() throws IOException{
        String source = "{\n" +
                "  \"name\" : \"这一刀,会很帅\",\n" +
                "  \"price\" : 300,\n" +
                "  \"num\" : 800,\n" +
                "  \"date\" : \"2023-07-07\"\n" +
                "}";

        IndexResponse response = service.addDoc("idx_clouthing", source);
        return response.toString();
    }
}
