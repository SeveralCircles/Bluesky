package com.severalcircles.bluesky.command;

import com.severalcircles.bluesky.Bluesky;
import com.severalcircles.bluesky.BlueskyManager;
import com.severalcircles.bluesky.fairplay.FairplayProtected;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.defaults.HelpCommand;

import java.util.List;
import java.util.Map;

public class BlueskyCommandManager extends BlueskyManager {
    static final Map<String, CommandExecutor> commands = Map.of(
            "test", new TestCommand(),
            "fairplay", new FairplayCommand()
    );
    @Override
    public void prepare() {
        commands.forEach((name, command) -> {
            Bluesky.instance.getCommand(name).setExecutor(command);
        });
    }
    public static boolean checkFairplay(String command) {
        if (commands.containsKey(command)) {
            return command.getClass().getAnnotation(FairplayProtected.class).value();
        }
        return false;
    }
}
