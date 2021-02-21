package ua.frogsteam.cord.commands.admin;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Collection;

public class CommandClear extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals(".!clear")) {
            MessageChannel channel = event.getChannel();
            event.getMessage().getChannel().sendMessage("test");

        }
    }

    private Collection<Message> onGuildMessageDelete() {
        return null;
    }
}
