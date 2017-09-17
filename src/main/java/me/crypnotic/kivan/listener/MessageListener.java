package me.crypnotic.kivan.listener;

import me.crypnotic.kivan.KivaN;
import me.crypnotic.kivan.api.ICommand;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.MissingPermissionsException;

public class MessageListener {

    private KivaN kivan;

    public MessageListener(KivaN kivan) {
        this.kivan = kivan;
    }

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {
        IMessage message = event.getMessage();
        String content = message.getContent();

        if (!content.startsWith(".")) {
            return;
        }

        String name = content.split(" ")[0].substring(1);
        ICommand command = kivan.getCommandManager().getCommand(name);

        if (command != null) {
            boolean delete = command.handle(event.getGuild(), event.getChannel(), event.getAuthor(), message);

            if (delete && !message.isDeleted()) {
                try {
                    message.delete();
                } catch (MissingPermissionsException exception) {
                    kivan.getLogger().warning("Failed to delete message due to missing permissons!");
                }
            }
        }
    }
}
