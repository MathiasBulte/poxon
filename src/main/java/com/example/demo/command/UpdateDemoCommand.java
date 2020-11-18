package com.example.demo.command;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UpdateDemoCommand extends AbstractCommand {
    private final String inputValue;
}
