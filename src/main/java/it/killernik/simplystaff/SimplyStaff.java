package it.killernik.simplystaff;

import it.killernik.simplystaff.Commands.Gamemodes.GamemodeCreative;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplyStaff extends JavaPlugin {

    private static SimplyStaff instance;

    public SimplyStaff() {
        instance = this;
    }

    public static SimplyStaff getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        //Bukkit.getPluginManager().registerEvents((Listener) new it.dragonpvp.dragonsecurity.Listener.CommandPreprocessListener(), (Plugin) this);
        getCommand("gmc").setExecutor(new GamemodeCreative());


        Bukkit.getLogger().info("SimlyStaff by killernik");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("SimlyStaff by killernik");
    }
}
