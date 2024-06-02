package com.dyonne.literalura.literAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData{

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> tclass) {
       try {
           return mapper.readValue(json, tclass);
       } catch (JsonProcessingException e) {
           throw new RuntimeException(e);
       }
    }
}
