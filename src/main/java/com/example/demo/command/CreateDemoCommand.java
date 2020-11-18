package com.example.demo.command;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CreateDemoCommand extends AbstractCommand {
    private final String inputValue;
}
