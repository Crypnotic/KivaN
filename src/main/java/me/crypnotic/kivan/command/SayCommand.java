package me.crypnotic.kivan.command;

import me.crypnotic.kivan.api.ICommand;
import me.crypnotic.kivan.api.Strings;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Permissions;

public class SayCommand implements ICommand {

    @Override
    public boolean handle(IGuild guild, IChannel channel, IUser user, IMessage message) {
        if (!user.getPermissionsForGuild(guild).contains(Permissions.SEND_MESSAGES)) {
            channel.sendMessage("`You do not have permission to use this command!`");
            return true;
        }

        channel.sendMessage(Strings.join(message.getContent().split(" "), 1));

        return true;
    }
}
