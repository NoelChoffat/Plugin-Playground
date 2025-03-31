package me.Coach_Steve__.deathScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class DeatheventListerner implements Listener {
    private final DeathScoreboard plugin;

    public DeatheventListerner(DeathScoreboard plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
                plugin.incrementDeathCounter(event.getEntity());
    }
}
