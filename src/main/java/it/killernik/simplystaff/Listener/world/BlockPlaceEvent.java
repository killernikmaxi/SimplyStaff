package it.killernik.simplystaff.Listener.world;

import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BlockPlaceEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        if (SimplyStaff.INSTANCE.freezeManager.isFrozen(e.getPlayer())) e.setCancelled(true);
    }

}
