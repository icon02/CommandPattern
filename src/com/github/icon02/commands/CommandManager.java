package com.github.icon02.commands;

import java.util.EmptyStackException;
import java.util.Stack;

public class CommandManager {

    private Stack<Command> executedCommands = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {
        if(command == null) System.out.println("Nothing to execute");
        else {
            command.execute();
            executedCommands.push(command);
            redoStack.clear();
        }
    }

    public void redo() {
        try {
            Command redoCommand = redoStack.pop();
            redoCommand.execute();
            executedCommands.push(redoCommand);
        } catch(EmptyStackException e) {
            System.out.println("Nothing to redo");
        }
    }

    public void undo() {
        try {
            Command undoCommand = executedCommands.pop();
            undoCommand.undo();
            redoStack.push(undoCommand);
        } catch(EmptyStackException e) {
            System.out.println("Nothing to undo");
        }undo();
    }

}
