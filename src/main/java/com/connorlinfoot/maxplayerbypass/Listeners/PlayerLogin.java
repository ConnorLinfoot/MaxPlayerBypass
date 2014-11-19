package com.connorlinfoot.maxplayerbypass.Listeners;

import com.connorlinfoot.maxplayerbypass.MaxPlayerBypass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            int onlinePlayers = Bukkit.getOnlinePlayers().length;
            if (onlinePlayers < MaxPlayerBypass.maxPlayers) {
                event.setResult(PlayerLoginEvent.Result.ALLOWED);
            }
        }
    }

}
