package com.rrhdyh.schedule.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.rrhdyh.schedule.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

public class WebUtil {
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static <T> void writejson(T result, HttpServletResponse resp) throws IOException {
//        Gson gson = new Gson();
//               resp.getWriter().write(gson.toJson(result));
        resp.getWriter().write(objectMapper.writeValueAsString(result));
    }
    public static <T> T readJson(HttpServletRequest request, Class<T> clazz) throws IOException {
        T t = null;
        BufferedReader reader = null;

        reader = request.getReader();
        StringBuffer buffer = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            t = objectMapper.readValue(buffer.toString(), clazz);
        }
        return t;
    }
}
