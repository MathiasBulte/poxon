package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "DEMO")
@AllArgsConstructor
@NoArgsConstructor
public class DemoProjection {

    @Id
    private String id;
    private String inputValue;

}
