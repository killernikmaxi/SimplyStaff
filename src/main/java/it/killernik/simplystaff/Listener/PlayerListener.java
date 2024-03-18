package it.killernik.simplystaff.Listener;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (!p.hasPermission("ss.staff")) return;
        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("STAFF-ALERTS.join-staff"), p);

    }
}
