package me.crypnotic.kivan.api;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

@FunctionalInterface
public interface ICommand {

    boolean handle(IGuild guild, IChannel channel, IUser user, IMessage message);
}
