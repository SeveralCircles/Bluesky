package com.severalcircles.bluesky.events;

import com.severalcircles.bluesky.command.BlueskyCommandManager;
import com.severalcircles.bluesky.fairplay.FairplayException;
import com.severalcircles.bluesky.fairplay.FairplayManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlueskyEventListener implements Listener {
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (BlueskyCommandManager.checkFairplay(event.getMessage().split(" ")[0]) && FairplayManager.fairplayEnabled) {
            event.setCancelled(true);
            throw new FairplayException();
        }
    }
}
