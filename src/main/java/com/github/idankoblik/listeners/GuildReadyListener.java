package com.github.idankoblik.listeners;

import com.github.idankoblik.Main;
import com.github.idankoblik.commands.ReflactiveCommandLoader;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GuildReadyListener extends ListenerAdapter {

    private ReflactiveCommandLoader commandLoader;

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        System.out.println("API is ready!");
        event.getGuild().getTextChannelById(1175168530749083748L).sendMessage("hey").queue();
        commandLoader = new ReflactiveCommandLoader(event.getJDA(), event.getGuild().getIdLong(), Main.class.getPackageName() + ".commands");
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        commandLoader.handleCommands(event);
    }

}
