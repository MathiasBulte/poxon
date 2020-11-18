package com.example.demo.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DemoCreatedEvent extends AbstractEvent {
    private final String inputValue;
}
