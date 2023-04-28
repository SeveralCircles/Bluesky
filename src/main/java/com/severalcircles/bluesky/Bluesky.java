package com.severalcircles.bluesky;

import com.severalcircles.bluesky.command.BlueskyCommandManager;
import com.severalcircles.bluesky.command.TestCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Bluesky extends JavaPlugin {
    public static Bluesky instance;
    @Override
    public void onEnable() {
        super.onEnable();
        this.saveDefaultConfig();
        instance = this;
//        BlueskyCommandExecutor.registerCommands();
        new BlueskyCommandManager().prepare();
        Bukkit.getLogger().info("Successfully enabled Bluesky");
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
