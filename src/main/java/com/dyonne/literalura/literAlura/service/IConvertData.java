package com.dyonne.literalura.literAlura.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> tclass);
}
