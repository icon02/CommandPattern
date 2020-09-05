package com.github.icon02.commands;

import com.github.icon02.model.Stock;

public class SellCommand implements Command {

    private int amount;
    private Stock stock;

    public SellCommand(int amount, Stock stock) {
        this.amount = amount;
        this.stock = stock;
    }


    @Override
    public void execute() {
        int curAmount = stock.getStock();
        stock.setStock(curAmount - amount);
    }

    @Override
    public void undo() {
        int curAmount = stock.getStock();
        stock.setStock(curAmount + amount);
    }

    @Override
    public void redo() {
        execute();
    }
}
