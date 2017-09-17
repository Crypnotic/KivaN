package me.crypnotic.kivan;

import java.util.logging.Logger;

import me.crypnotic.kivan.listener.MessageListener;
import me.crypnotic.kivan.manager.CommandManager;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

public class KivaN {

    public static void main(String[] arguments) {
        new KivaN().init(arguments);
    }

    private Logger logger;
    private IDiscordClient client;

    private CommandManager commandManager;

    public KivaN() {
        this.logger = Logger.getLogger("KivaN");
    }

    public void init(String[] arguments) {
        if (arguments.length == 0) {
            logger.severe("No authentication token was received!");
            return;
        }

        this.commandManager = new CommandManager();

        try {
            this.client = new ClientBuilder().withToken(arguments[0]).login();
        } catch (DiscordException exception) {
            exception.printStackTrace();
            return;
        }

        commandManager.init();

        client.getDispatcher().registerListener(new MessageListener(this));
    }

    public Logger getLogger() {
        return logger;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}
