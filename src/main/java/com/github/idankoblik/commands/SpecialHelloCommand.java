package com.github.idankoblik.commands;

import lombok.NonNull;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@RequiredRoles(ids = {1117122506449490050L})
public class SpecialHelloCommand extends Command {

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("special"))
            return;

        event.reply("Special hello").queue();
    }

    @Override
    public @NonNull CommandData commandData() {
        return Commands.slash("special", "Im special");
    }

    @Nullable
    @Override
    public Map<String, String[]> autoCompletion() {
        return null;
    }

}
