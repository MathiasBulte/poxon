package com.example.demo.command;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@SuperBuilder
public class AbstractCommand {

    @TargetAggregateIdentifier
    private final String aggregateId;
}
