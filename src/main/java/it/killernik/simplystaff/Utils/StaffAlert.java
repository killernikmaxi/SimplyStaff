package it.killernik.simplystaff.Utils;

import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class StaffAlert {

    // UTIL FOR MESSAGE SENDING
    public static void alert(String message, Player player) {
        if (SimplyStaff.INSTANCE.getConfig().getBoolean("STAFF-ALERTS.enabled")) {
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.hasPermission("ss.alert")) {
                    online.sendMessage(MessageUtil.message(message, player));
                }
            }
        }
    }
}
