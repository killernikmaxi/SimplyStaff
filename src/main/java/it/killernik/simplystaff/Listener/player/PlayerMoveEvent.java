package it.killernik.simplystaff.Listener.player;

import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerMoveEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(org.bukkit.event.player.PlayerMoveEvent e) {
        if (!SimplyStaff.INSTANCE.freezeManager.isFrozen(e.getPlayer())) return;
        Location fromLocation = e.getFrom();
        Location toLocation = e.getTo();
        if (toLocation == null || isSameLocation(fromLocation, toLocation)) return;
        e.setTo(fromLocation);
    }

    private boolean isSameLocation(Location location1, Location location2) {
        double x1 = location1.getX();
        double y1 = location1.getY();
        double z1 = location1.getZ();
        double x2 = location2.getX();
        double y2 = location2.getY();
        double z2 = location2.getZ();
        return (x1 == x2 && z1 == z2 && y2 <= y1);
    }

}
