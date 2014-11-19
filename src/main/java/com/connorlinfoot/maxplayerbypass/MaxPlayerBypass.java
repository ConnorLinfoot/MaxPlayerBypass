package com.connorlinfoot.maxplayerbypass;

import com.connorlinfoot.maxplayerbypass.Commands.MPBCommand;
import com.connorlinfoot.maxplayerbypass.Listeners.Ping;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class MaxPlayerBypass extends JavaPlugin {
    private static Plugin plugin;
    public static boolean SNAPSHOT = false;
    public static String Prefix = "[MaxPlayerBypass] ";
    public static int maxPlayers = 0;

    public void onEnable() {
        plugin = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        int maxPlayers2 = MaxPlayerBypass.getPlugin().getConfig().getInt("Max Players");
        if (maxPlayers2 == -1) {
            maxPlayers = Bukkit.getMaxPlayers();
        } else {
            maxPlayers = maxPlayers2;
        }

        console.sendMessage("");
        console.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        console.sendMessage("");
        console.sendMessage(ChatColor.AQUA + getDescription().getName());
        console.sendMessage(ChatColor.AQUA + "Version " + getDescription().getVersion());
        if (getDescription().getVersion().contains("SNAPSHOT")) {
            SNAPSHOT = true;
            console.sendMessage(ChatColor.RED + "You are running a snapshot build of " + getDescription().getName() + " please report bugs!");
            console.sendMessage(ChatColor.RED + "NO support will be given if running old snapshot build!");
        }
        console.sendMessage("");
        console.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        console.sendMessage("");

        registerCommands(console);
        registerEvents(console);
    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    private void registerEvents(ConsoleCommandSender console) {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Ping(), this);
        console.sendMessage(Prefix + "Events have been registered");
    }

    private void registerCommands(ConsoleCommandSender console) {
        getCommand("mpb").setExecutor(new MPBCommand());
        console.sendMessage(Prefix + "Commands have been registered");
    }
}
