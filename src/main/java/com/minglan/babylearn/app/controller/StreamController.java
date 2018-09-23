package com.minglan.babylearn.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * StreamController
 * descript : TDGO
 * create date : 18/9/24 06:49
 *
 * @author yangling
 * @version 1.0
 */
@RestController
public class StreamController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamController.class);

    @PostMapping(value = "stream")
    public String stream(HttpServletRequest request) throws IOException {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        reader.close();

        String requestString = stringBuilder.toString();
        String jsonString = requestString.substring(requestString.indexOf("{"));

        LOGGER.info(jsonString);

        JSONObject j = JSON.parseObject (jsonString);

        LOGGER.info("get object from request : {} ",j.toString());

        return stringBuilder.toString();



    }
}
