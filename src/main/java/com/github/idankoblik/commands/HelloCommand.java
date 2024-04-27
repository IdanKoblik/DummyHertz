package com.github.idankoblik.commands;

import lombok.NonNull;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class HelloCommand extends Command {

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("hello"))
            return;

        event.reply("Hey").queue();
    }

    @Override
    public @NonNull CommandData commandData() {
        return Commands.slash("hello", "hello, World!");
    }

    @Nullable
    @Override
    public Map<String, String[]> autoCompletion() {
        return null;
    }

}
