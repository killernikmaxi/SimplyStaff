package it.killernik.simplystaff.Listener.world;

import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBreak(org.bukkit.event.block.BlockBreakEvent e) {
        if (SimplyStaff.INSTANCE.freezeManager.isFrozen(e.getPlayer())) e.setCancelled(true);
    }

}
