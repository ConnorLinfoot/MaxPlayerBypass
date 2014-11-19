package com.connorlinfoot.maxplayerbypass.Listeners;

import com.connorlinfoot.maxplayerbypass.MaxPlayerBypass;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Ping implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        event.setMaxPlayers(MaxPlayerBypass.maxPlayers);
    }

}
