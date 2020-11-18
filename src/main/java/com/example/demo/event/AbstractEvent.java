package com.example.demo.event;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class AbstractEvent {
    private final String aggregateId;
}
