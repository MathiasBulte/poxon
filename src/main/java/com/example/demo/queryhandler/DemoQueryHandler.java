package com.example.demo.queryhandler;


import com.example.demo.entity.DemoProjection;
import com.example.demo.query.FindAllDemosQuery;
import com.example.demo.query.FindDemoByAggregateIdQuery;
import com.example.demo.repository.DemoProjectionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DemoQueryHandler {

    private final DemoProjectionRepository demoProjectionRepository;

    @QueryHandler
    public Iterable<DemoProjection> handle(FindAllDemosQuery findAllDemosQuery) {
        return demoProjectionRepository.findAll();
    }

    @QueryHandler
    public Optional<DemoProjection> handle(FindDemoByAggregateIdQuery findDemoByAggregateIdQuery) {
        return demoProjectionRepository.findById(findDemoByAggregateIdQuery.getAggregateId());
    }

}
