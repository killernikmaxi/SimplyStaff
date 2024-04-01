package it.killernik.simplystaff.Listener;

import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class EntityDamageEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(org.bukkit.event.entity.EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        if (SimplyStaff.INSTANCE.freezeManager.isFrozen(player)) e.setCancelled(true);
        if (SimplyStaff.INSTANCE.godModeManager.isInGodmode(player)) e.setCancelled(true);
    }

}
