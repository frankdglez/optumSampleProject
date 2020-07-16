package com.optum.optumsample.controller;

public interface IController<T> {
    Object getAll();
    T getById(String elementId);
    T save(T t);
}
