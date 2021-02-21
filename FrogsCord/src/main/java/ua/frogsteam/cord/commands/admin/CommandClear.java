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
        Message objMsg = e.getMessage();
        String[] args = objMsg.getContentRaw().split("");
        if (args[0].equalsIgnoreCase(("!gg"))){
            if (args.length <= 2){
            }
            else {
                e.getMessage().delete().queue();
                boolean target = e.getTextChannel().delete().equals(objMsg);
                purgeMessages(target, Integer.parseInt(args[2]));
            }
        }
    }

    private void purgeMessages(boolean target, int i) {
        MessageChannel channel = null;
        MessageHistory history = new MessageHistory(channel);
        List<Message> msgs;

        int numberofMessages = 0;
        msgs = history.retrievePast(numberofMessages).complete();
        channel.deleteMessageById(String.valueOf(msgs)).queue();
    }

    /*public void onGuildReceived(GuildMessageReceivedEvent event) {
        Message objMsg = event.getMessage();
        String[] args = objMsg.getContentRaw().split("");
        if(args[0].equalsIgnoreCase( "!purge")) {
            if(args.length <= 2) {
                //TODO
            }else {
                event.getMessage().delete().queue();
                TextChannel target = event.getMessage().getMentionedChannels().get(0);
                purgeMessages(target, Integer.parseInt(args[2]));
            }
        }
    }
    private void purgeMessages(TextChannel channel, int numberofMessages) {
        MessageHistory history = new MessageHistory(channel);
        List<Message> msgs;

        msgs = history.retrievePast(numberofMessages).complete();
        channel.deleteMessages(msgs).queue();

    }*/
}
