package com.github.idankoblik;

import com.github.idankoblik.commands.ReflactiveCommandLoader;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Main extends ListenerAdapter {

    private static ReflactiveCommandLoader commandLoader;

    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        Dotenv config = Dotenv.configure().load();

        JDA jda = JDABuilder.createDefault(config.get("TOKEN"))
                .addEventListeners(new Main())
                .build();

        jda.awaitReady();
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        System.out.println("API is ready!");
        commandLoader = new ReflactiveCommandLoader(event.getJDA(), event.getGuild().getIdLong(), Main.class.getPackageName() + ".commands");
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        commandLoader.handleCommands(event);
    }
}