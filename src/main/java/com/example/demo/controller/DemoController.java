package com.example.demo.controller;

import com.example.demo.command.CreateDemoCommand;
import com.example.demo.command.UpdateDemoCommand;
import com.example.demo.entity.DemoProjection;
import com.example.demo.query.FindAllDemosQuery;
import com.example.demo.query.FindDemoByAggregateIdQuery;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/demo")
@AllArgsConstructor
public class DemoController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @PostMapping
    public String create() {
        var createDemoCommand = CreateDemoCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .inputValue("test")
                .build();

        return commandGateway.sendAndWait(createDemoCommand);
    }

    @PostMapping("{aggregateId}")
    public void update(@PathVariable("aggregateId") String aggregateId) {
        var updateDemoCommand = UpdateDemoCommand.builder()
                .aggregateId(aggregateId)
                .inputValue(UUID.randomUUID().toString())
                .build();

        commandGateway.sendAndWait(updateDemoCommand);
    }

    @GetMapping
    public ResponseEntity<Iterable<DemoProjection>> findAll() {
        return ok(queryGateway.query(new FindAllDemosQuery(), ResponseTypes.multipleInstancesOf(DemoProjection.class))
                .join());
    }

    @GetMapping("{aggregateId}")
    public ResponseEntity<DemoProjection> findByAggregateId(@PathVariable("aggregateId") String aggregateId) {
        return queryGateway.query(new FindDemoByAggregateIdQuery(aggregateId), ResponseTypes.optionalInstanceOf(DemoProjection.class))
                .join()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
