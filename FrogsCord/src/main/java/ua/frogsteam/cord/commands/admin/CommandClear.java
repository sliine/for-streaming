package ua.frogsteam.cord.commands.admin;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Collection;
import java.util.List;

public class CommandClear extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        Message msg = e.getMessage();
        if (msg.getContentRaw().equals("!clear")) {
            MessageChannel channel = e.getChannel();
            channel.sendMessage("deleted").queue(response -> {
                channel.purgeMessages(e.getMessage()).clear();
            });
        }
    }
}
