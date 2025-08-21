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

        // Creating scoreboard
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        if (manager != null) {
            scoreboard = manager.getNewScoreboard();
        }

        // register Eventlistener
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
        // Check, if object exists
        Objective objective = scoreboard.getObjective("deaths");
        if (objective == null) {
            objective = scoreboard.registerNewObjective("deaths", "dummy", "DeathStatistics");
            objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        }

        // Set Current death count for all players
        for (Player player : Bukkit.getOnlinePlayers()) {
            int deaths = player.getStatistic(Statistic.DEATHS);
            objective.getScore(player.getName()).setScore(deaths);
        }
    }
    
    public void incrementDeathCounter(Player player) {
        Objective objective = scoreboard.getObjective("deaths");
        if (objective != null) {
            int currentScore = objective.getScore(player.getName()).getScore();
            objective.getScore(player.getName()).setScore(currentScore + 1);
        }
    }
}
