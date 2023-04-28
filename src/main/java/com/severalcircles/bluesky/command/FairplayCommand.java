package com.severalcircles.bluesky.command;

import com.severalcircles.bluesky.fairplay.FairplayManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FairplayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (FairplayManager.fairplayEnabled) {
            sender.sendMessage("This server is &aprotected&f by &l&4Fairplay&r&f.");
            sender.sendMessage("&lWhat does this mean?");
            sender.sendMessage("Fairplay protects the server from accidental (or intentional) tampering/cheating by operators and players.");
        } else {
            sender.sendMessage("This server is &cnot protected&f by &l&4Fairplay&r&f.");
            sender.sendMessage("&lWhat does this mean?");
            sender.sendMessage("&4Fairplay is not protecting this server. Operators are able to use commands that could potentially break the server. Players may be able to interact with the server in ways that could potentially break the server.");
        }
        return true;
    }
}
