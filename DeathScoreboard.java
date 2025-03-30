package me.Coach_Steve__.deathScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public final class DeathScoreboard extends JavaPlugin {
    private Scoreboard scoreboard;

    @Override
    public void onEnable() {
        getLogger().info("DeathStatsPlugin has been enabled!");

        // Scoreboard erstellen
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        if (manager != null) {
            scoreboard = manager.getNewScoreboard();
        }

        // EventListener registrieren
        getServer().getPluginManager().registerEvents(new JoinEventListener(this), this);
        getServer().getPluginManager().registerEvents(new DeatheventListerner(this), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("DeathStatsPlugin has been disabled!");
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void updateScoreboard() {
        // Sicherstellen, dass das Objective existiert
        Objective objective = scoreboard.getObjective("deaths");
        if (objective == null) {
            objective = scoreboard.registerNewObjective("deaths", "dummy", "Todesstatistiken");
            objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        }

        // Aktuellen Stand der Tode für alle Spieler setzen
        for (Player player : Bukkit.getOnlinePlayers()) {
            int deaths = player.getStatistic(Statistic.DEATHS);
            objective.getScore(player.getName()).setScore(deaths);
        }
    }
}
