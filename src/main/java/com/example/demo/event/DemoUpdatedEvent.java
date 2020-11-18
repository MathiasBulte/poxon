package com.example.demo.event;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DemoUpdatedEvent extends AbstractEvent {
    private final String inputValue;
}
