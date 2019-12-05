package com.gagezilla100.eggcapture.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class eggThrow implements Listener {
    @EventHandler
    public void onEggThrow(PlayerEggThrowEvent e) {
        e.setHatching(false);
    }
}
