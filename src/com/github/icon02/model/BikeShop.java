package com.github.icon02.model;

import com.github.icon02.commands.BuyCommand;
import com.github.icon02.commands.CommandManager;
import com.github.icon02.commands.SellCommand;

public class BikeShop {

    private Stock stock = new Stock(100);
    private CommandManager commandManager = new CommandManager();

    public BikeShop() {}

    public BikeShop(int stock) {
        this.stock = new Stock(stock);
    }

    public void buy(int amount) {
        BuyCommand command = new BuyCommand(amount, stock);
        commandManager.executeCommand(command);
    }

    public void sell(int amount) {
        SellCommand command = new SellCommand(amount, stock);
        commandManager.executeCommand(command);
    }

    public void undo() {
        commandManager.undo();
    }

    public void redo() {
        commandManager.redo();
    }

    public int getStock() {
        return stock.getStock();
    }
}
