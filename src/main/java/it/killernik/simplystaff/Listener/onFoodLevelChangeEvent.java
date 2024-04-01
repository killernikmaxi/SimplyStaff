package it.killernik.simplystaff.Listener;

import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class onFoodLevelChangeEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        if (SimplyStaff.INSTANCE.freezeManager.isFrozen(player)) e.setCancelled(true);
        if (SimplyStaff.INSTANCE.godModeManager.isInGodmode(player)) e.setCancelled(true);
    }

}
