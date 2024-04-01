package it.killernik.simplystaff.Listener.player;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("ss.staff")) return;
        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("STAFF-ALERTS.join-staff"), p);

    }

}
