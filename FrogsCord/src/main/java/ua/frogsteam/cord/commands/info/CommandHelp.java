package ua.frogsteam.cord.commands.info;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandHelp extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals(".!help")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Help for commands!").queue(response -> {
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("Help");
                info.setDescription("Information or commands of bot");
                info.addField("Command: .!ping", "Check your ping", true);
                info.addField("Command: .!info", "Full information of bot", true);
                info.setColor(0x32F029);

                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
            });
        }
    }
}
