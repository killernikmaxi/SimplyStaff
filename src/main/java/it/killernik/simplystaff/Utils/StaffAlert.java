package it.killernik.simplystaff.Utils;

import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class StaffAlert {
        private final SimplyStaff plugin;
        private final it.killernik.simplystaff.Utils.StaffAlert staffalert;

        public StaffAlert(SimplyStaff plugin) {
            this.plugin = plugin;
            this.staffalert = new it.killernik.simplystaff.Utils.StaffAlert(plugin);
        }

        // UTIL FOR MESSAGE SENDING
        public static void alert(String message, Player player) {

            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.hasPermission("ss.alert")) {
                    online.sendMessage(MessageUtil.message(message, player));

                }
            }
        }
}
