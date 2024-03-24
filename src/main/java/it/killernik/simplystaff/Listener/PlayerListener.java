package it.killernik.simplystaff.Listener;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("ss.staff")) return;
        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("STAFF-ALERTS.join-staff"), p);

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(PlayerMoveEvent e) {
        if (!SimplyStaff.INSTANCE.isFrozen(e.getPlayer())) return;
        Location fromLocation = e.getFrom();
        Location toLocation = e.getTo();
        if (toLocation == null || locCheck(fromLocation, toLocation)) return;
        e.setTo(fromLocation);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        if (SimplyStaff.INSTANCE.isFrozen(player)) e.setCancelled(true);
        if (SimplyStaff.INSTANCE.isInGodmode(player)) e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlace(BlockPlaceEvent e) {
        if (SimplyStaff.INSTANCE.isFrozen(e.getPlayer())) e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBreak(BlockBreakEvent e) {
        if (SimplyStaff.INSTANCE.isFrozen(e.getPlayer())) e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        if (SimplyStaff.INSTANCE.isFrozen(player)) e.setCancelled(true);
        if (SimplyStaff.INSTANCE.isInGodmode(player)) e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommnad(PlayerCommandPreprocessEvent e) {
        if (SimplyStaff.INSTANCE.getConfig().getBoolean("COMMANDS.freeze.block-command.enabled")) return;
        Player p = e.getPlayer();
        if (!SimplyStaff.INSTANCE.isFrozen(p)) return;
        e.setCancelled(true);
        p.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.freeze.block-command.message"), p));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e) {
        if (SimplyStaff.INSTANCE.getConfig().getBoolean("COMMANDS.freeze.block-chat.enabled")) return;
        Player p = e.getPlayer();
        if (!SimplyStaff.INSTANCE.isFrozen(p)) return;
        e.setCancelled(true);
        p.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.freeze.block-chat.message"), p));
    }

    private boolean locCheck(Location location1, Location location2) {
        double x1 = location1.getX();
        double y1 = location1.getY();
        double z1 = location1.getZ();
        double x2 = location2.getX();
        double y2 = location2.getY();
        double z2 = location2.getZ();
        return (x1 == x2 && z1 == z2 && y2 <= y1);
    }
}
