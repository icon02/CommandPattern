package com.github.icon02.commands;

public interface Command {

    void execute();
    void undo();
    void redo();

}
