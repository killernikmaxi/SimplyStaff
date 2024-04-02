package it.killernik.simplystaff;

import it.killernik.simplystaff.Commands.Advanced.ServerInfoCommand;
import it.killernik.simplystaff.Commands.Advanced.SudoCommand;
import it.killernik.simplystaff.Commands.Basic.*;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportAllCommand;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportCommand;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportHereCommand;
import it.killernik.simplystaff.Commands.Basic.Teleport.TeleportPosCommand;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeAdventure;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeCreative;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeSpectator;
import it.killernik.simplystaff.Commands.Gamemodes.GamemodeSurvival;
import it.killernik.simplystaff.Commands.MainCommand;
import it.killernik.simplystaff.Listener.world.BlockPlaceEvent;
import it.killernik.simplystaff.Manager.FreezeManager;
import it.killernik.simplystaff.Manager.GodModeManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplyStaff extends JavaPlugin {

    public static SimplyStaff INSTANCE;
    public GodModeManager godModeManager;
    public FreezeManager freezeManager;


    @Override
    public void onEnable() {
        long startTime = System.currentTimeMillis();
        INSTANCE = this;
        initManagers();
        saveDefaultConfig();
        registerListeners();
        registerCommands();
        Bukkit.getLogger().info("[SimlyStaff] by killernik enabled in " + (System.currentTimeMillis() - startTime) + "ms!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[SimlyStaff] by killernik disabled");
    }

    private void registerListeners() {
        Bukkit.getLogger().info("- Registering listener...");

        Bukkit.getPluginManager().registerEvents(new it.killernik.simplystaff.Listener.onFoodLevelChangeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new it.killernik.simplystaff.Listener.EntityDamageEvent(), this);

        Bukkit.getPluginManager().registerEvents(new it.killernik.simplystaff.Listener.player.AsyncPlayerChatEvent(), this);
        Bukkit.getPluginManager().registerEvents(new it.killernik.simplystaff.Listener.player.PlayerJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new it.killernik.simplystaff.Listener.player.PlayerCommandPreprocessEvent(), this);
        Bukkit.getPluginManager().registerEvents(new it.killernik.simplystaff.Listener.player.PlayerJoinEvent(), this);

        Bukkit.getPluginManager().registerEvents(new it.killernik.simplystaff.Listener.world.BlockBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(), this);


        Bukkit.getLogger().info("✔ Registered listeners!");
    }

    private void registerCommands() {
        Bukkit.getLogger().info("- Registering commands...");
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
        getCommand("teleportall").setExecutor(new TeleportAllCommand());
        getCommand("serverinfo").setExecutor(new ServerInfoCommand());
        getCommand("sudo").setExecutor(new SudoCommand());
        getCommand("freeze").setExecutor(new FreezeCommand());
        Bukkit.getLogger().info("✔ Registered commands!");
    }

    public void initManagers() {
        godModeManager = new GodModeManager();
        freezeManager = new FreezeManager();
    }

}
