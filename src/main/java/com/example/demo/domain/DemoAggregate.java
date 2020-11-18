package com.example.demo.domain;

import com.example.demo.command.CreateDemoCommand;
import com.example.demo.command.UpdateDemoCommand;
import com.example.demo.event.DemoCreatedEvent;
import com.example.demo.event.DemoUpdatedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
@NoArgsConstructor
public class DemoAggregate {

    @AggregateIdentifier
    private String aggregateId;
    private String inputValue;

    @CommandHandler
    public DemoAggregate(CreateDemoCommand createDemoCommand) {
        AggregateLifecycle.apply(DemoCreatedEvent.builder()
                .aggregateId(createDemoCommand.getAggregateId())
                .inputValue(createDemoCommand.getInputValue())
                .build());
    }

    @CommandHandler
    public void handleUpdateDemoCommand(UpdateDemoCommand updateDemoCommand) {
        AggregateLifecycle.apply(DemoUpdatedEvent.builder()
                .aggregateId(updateDemoCommand.getAggregateId())
                .inputValue(updateDemoCommand.getInputValue())
                .build());
    }


    @EventSourcingHandler
    public void handleDemoCreatedEvent(DemoCreatedEvent demoCreatedEvent) {
        this.aggregateId = demoCreatedEvent.getAggregateId();
        this.inputValue = demoCreatedEvent.getInputValue();
    }

    @EventSourcingHandler
    public void handleDemoUpdatedEvent(DemoUpdatedEvent demoUpdatedEvent) {
        this.inputValue = demoUpdatedEvent.getInputValue();
    }
}
