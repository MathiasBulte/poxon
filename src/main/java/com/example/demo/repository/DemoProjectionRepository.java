package com.example.demo.repository;

import com.example.demo.entity.DemoProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoProjectionRepository extends CrudRepository<DemoProjection, String> {
}
