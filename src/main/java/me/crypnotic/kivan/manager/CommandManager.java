package me.crypnotic.kivan.manager;

import me.crypnotic.kivan.api.ICommand;
import me.crypnotic.kivan.api.Multiset;
import me.crypnotic.kivan.command.SayCommand;

public class CommandManager {

    private final Multiset<String, ICommand> commands;

    public CommandManager() {
        this.commands = Multiset.empty();
    }

    public void init() {
        commands.put("say", new SayCommand());
    }

    public ICommand getCommand(String name) {
        return commands.get(name);
    }
}
