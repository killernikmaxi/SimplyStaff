package it.killernik.simplystaff;

import it.killernik.simplystaff.Commands.Advanced.ServerInfoCommand;
import it.killernik.simplystaff.Commands.Advanced.SudoCommand;
import it.killernik.simplystaff.Commands.Basic.*;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportCommand;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportHereCommand;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportPosCommand;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeAdventure;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeCreative;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeSpectator;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeSurvival;
import it.killernik.simplystaff.Commands.MainCommand;
import it.killernik.simplystaff.Utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class SimplyStaff extends JavaPlugin {

    public static SimplyStaff INSTANCE;
    private final Set<Player> godmode = new HashSet<>();
    private final Set<Player> frozen = new HashSet<>();

    public boolean isInGodmode(Player p) {
        return godmode.contains(p);
    }

    public void addGodmode(Player p) {
        godmode.add(p);
    }

    public void removeGodmode(Player p) {
        godmode.remove(p);
    }

    public boolean isFrozen(Player p) {
        return frozen.contains(p);
    }

    public void addFreeze(Player p) {
        frozen.add(p);
        MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("Commands.freeze.freeze-player-message"), p);
    }

    public void removeFreeze(Player p) {
        frozen.remove(p);
    }

    @Override
    public void onEnable() {

        INSTANCE = this;

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents((Listener) new it.killernik.simplystaff.Listener.PlayerListener(), (Plugin) this);
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
        getCommand("sudo").setExecutor(new SudoCommand());
        getCommand("freeze").setExecutor(new FreezeCommand());

        Bukkit.getLogger().info("[SimlyStaff] by killernik enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[SimlyStaff] by killernik disabled");
    }
}
