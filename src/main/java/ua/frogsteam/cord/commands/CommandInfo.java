package ua.frogsteam.cord.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandInfo extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals(".!info")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Information of bot!").queue(response -> {
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("FrogsTeam Info");
                info.setDescription("Information of bot");
                info.addField("Created by", "Frogs Team (FT)", true);
                info.addField("Help for commands", ".!help", false);
                info.setColor(0xF7FF00);

                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
            });
        }
    }
}
