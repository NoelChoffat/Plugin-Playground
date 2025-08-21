package me.Coach_Steve__.deathScoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class JoinEventListener implements Listener {
    private final DeathScoreboard plugin;

    public JoinEventListener(DeathScoreboard plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Scoreboard scoreboard = plugin.getScoreboard();

        // Create Scoreboard-Object
        Objective objective = scoreboard.getObjective("deaths");
        if (objective == null) {
            objective = scoreboard.registerNewObjective("deaths", "dummy", "DeathStatistics");
            objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        }

        // Show scoreboard to the Player
        player.setScoreboard(scoreboard);
        plugin.updateScoreboard();
    }
}


