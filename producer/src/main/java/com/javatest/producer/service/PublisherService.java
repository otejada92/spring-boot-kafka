package com.javatest.producer.service;

public interface PublisherService<T> {

    void publish(T message);
}
