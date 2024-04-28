package com.github.idankoblik;

import com.github.idankoblik.listeners.ReflactiveListenerLoader;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main {

    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        Dotenv config = Dotenv.configure().load();

        JDA jda = JDABuilder.createDefault(config.get("TOKEN")).build();

        ReflactiveListenerLoader listenerLoader = new ReflactiveListenerLoader(jda);
        System.out.println(Main.class.getPackageName());
        listenerLoader.registerListener(Main.class.getPackageName() + ".listeners");

        jda.getRegisteredListeners().forEach(System.out::println);
        jda.awaitReady();
    }

}