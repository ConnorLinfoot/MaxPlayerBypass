package com.connorlinfoot.maxplayerbypass.Commands;

import com.connorlinfoot.maxplayerbypass.MaxPlayerBypass;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MPBCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.AQUA + "\"" + MaxPlayerBypass.getPlugin().getDescription().getName() + "\" - Version: " + MaxPlayerBypass.getPlugin().getDescription().getVersion());
        return true;
    }

}
