package com.example.demo.eventhandler;

import com.example.demo.entity.DemoProjection;
import com.example.demo.event.DemoCreatedEvent;
import com.example.demo.event.DemoUpdatedEvent;
import com.example.demo.repository.DemoProjectionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoEventHandler {

    private final DemoProjectionRepository demoProjectionRepository;

    @EventHandler
    public void handleDemoCreatedEvent(DemoCreatedEvent demoCreatedEvent) {
        demoProjectionRepository.save(new DemoProjection(demoCreatedEvent.getAggregateId(), demoCreatedEvent.getInputValue()));
    }

    @EventHandler
    public void handleDemoUpdateEvent(DemoUpdatedEvent demoUpdatedEvent) {
        demoProjectionRepository.findById(demoUpdatedEvent.getAggregateId())
                .ifPresent(demoProjection -> demoProjection.setInputValue(demoUpdatedEvent.getInputValue()));
    }
}
