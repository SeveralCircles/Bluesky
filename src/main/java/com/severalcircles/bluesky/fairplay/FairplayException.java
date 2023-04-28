package com.severalcircles.bluesky.fairplay;

import org.bukkit.Bukkit;

public class FairplayException extends RuntimeException {
    public FairplayException() {
        super("Fairplay violation detected. Action cancelled.");
        Bukkit.getLogger().severe("A Fairplay violation was detected, and the action was cancelled.");
    }
}
