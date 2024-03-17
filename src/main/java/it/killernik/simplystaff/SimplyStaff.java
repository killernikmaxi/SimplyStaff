package it.killernik.simplystaff;

import it.killernik.simplystaff.Commands.Advanced.ServerInfoCommand;
import it.killernik.simplystaff.Commands.Basic.*;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportCommand;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportHereCommand;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportPosCommand;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeAdventure;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeCreative;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeSpectator;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeSurvival;
import it.killernik.simplystaff.Commands.MainCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
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

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents((Listener) new it.killernik.simplystaff.Listener.PlayerListener(), (Plugin) this);
        Bukkit.getPluginManager().registerEvents((Listener) new it.killernik.simplystaff.Commands.Basic.GodmodeCommand(), (Plugin) this);
        getCommand("gmc").setExecutor(new GamemodeCreative());
        getCommand("gma").setExecutor(new GamemodeAdventure());
        getCommand("gmsp").setExecutor(new GamemodeSpectator());
        getCommand("gms").setExecutor(new GamemodeSurvival());
        getCommand("ss").setExecutor(new MainCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("godmode").setExecutor(new GodmodeCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("teleport").setExecutor(new TeleportCommand());
        getCommand("teleportpos").setExecutor(new TeleportPosCommand());
        getCommand("teleporthere").setExecutor(new TeleportHereCommand());
        getCommand("serverinfo").setExecutor(new ServerInfoCommand());

        Bukkit.getLogger().info("[SimlyStaff] enabled with success");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[SimlyStaff] disabled with success");
    }
}
