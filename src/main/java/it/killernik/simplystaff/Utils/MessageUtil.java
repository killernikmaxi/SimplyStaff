package it.killernik.simplystaff.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageUtil {

    // UTIL FOR MESSAGE SENDING
    public static String message(String message, Player player) {

        // TRANSLATE COLOR
        message = ChatColor.translateAlternateColorCodes('&', message);

        // REPLACE PLACHEHOLDERS

        if (player == null) {
            return message;
        }

        message = message.replace("%player%", player.getName());
        return message;
    }
}
