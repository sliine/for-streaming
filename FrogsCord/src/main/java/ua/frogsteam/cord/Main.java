package ua.frogsteam.cord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import ua.frogsteam.cord.commands.admin.*;
import ua.frogsteam.cord.commands.info.*;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("Nzk0ODAyNjcyMTU4Mzc1OTU2.X_AHqw.UXf0gbExVTUYQ7D0wvZN5UC4Jm4").build();
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.getPresence().setActivity(Activity.watching("Help for bots .!help"));
        jda.addEventListener(new CommandInfo());
        jda.addEventListener(new CommandPing());
        jda.addEventListener(new CommandHelp());
        jda.addEventListener(new CommandClear());
    }
}
