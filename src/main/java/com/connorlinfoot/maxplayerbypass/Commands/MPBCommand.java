package com.connorlinfoot.maxplayerbypass.Commands;

import com.connorlinfoot.maxplayerbypass.MaxPlayerBypass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MPBCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1 && args[0].equalsIgnoreCase("set")) {
            if (args.length == 1) {
                sender.sendMessage(ChatColor.RED + "/mpb set <amount>");
                return false;
            }

            if (Integer.valueOf(args[1]) >= 0) {
                MaxPlayerBypass.maxPlayers = Integer.valueOf(args[1]);
            } else if (Integer.valueOf(args[1]) == 0) {
                MaxPlayerBypass.maxPlayers = Bukkit.getMaxPlayers();
            }
            MaxPlayerBypass.getPlugin().getConfig().set("Max Players", args[1]);
            sender.sendMessage(ChatColor.GREEN + "Max players has been set to " + args[1]);
            return true;
        }
        sender.sendMessage(ChatColor.AQUA + "\"" + MaxPlayerBypass.getPlugin().getDescription().getName() + "\" - Version: " + MaxPlayerBypass.getPlugin().getDescription().getVersion());
        return true;
    }

}
