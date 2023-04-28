package com.severalcircles.bluesky.fairplay;

import com.severalcircles.bluesky.Bluesky;
import com.severalcircles.bluesky.BlueskyManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.Properties;

public class FairplayManager extends BlueskyManager {
    public static boolean fairplayEnabled = false;
    public static boolean onlineModeWarning = false;
    public static boolean overrideAllowed = false;
    @Override
    public void prepare() {
        FileConfiguration config = Bluesky.instance.getConfig();
        if (!config.getBoolean("smp.fairplay.enabled")) {
            Bukkit.getLogger().info("Fairplay is disabled.");
            return;
        } else {
            fairplayEnabled = true;
            Bukkit.getLogger().info("Fairplay is enabled.");
        }
        if (config.getBoolean("smp.fairplay.override")) {
            Bukkit.getLogger().warning("Fairplay override enabled. That being said, Fairplay will still absolutely rat you out to players if you override it.");
            overrideAllowed = true;
        }
        File serverProperties = new File("server.properties");
        Properties properties = new Properties();
        try {
            properties.load(serverProperties.toURI().toURL().openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (properties.getProperty("online-mode").equals("false")) {
            Bukkit.getLogger().warning("Fairplay is enabled, but online-mode is not. Fairplay will absolutely rat you out to players.");
            onlineModeWarning = true;
        }
    }
}
