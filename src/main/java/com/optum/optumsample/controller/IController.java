package com.optum.optumsample.controller;

public interface IController<T> {
    Object getAll();
    T getById(Long elementId);
    T save(T t);
}
