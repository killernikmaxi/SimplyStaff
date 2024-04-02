package it.killernik.simplystaff.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Objects;

public class MessageUtil {

    public static String message(String message, Player player) {

        message = (message == null) ? null : ChatColor.translateAlternateColorCodes('&', message);
        message = (player != null) ? Objects.requireNonNull(message).replace("%player%", player.getName()) : message;

        return message;
    }
}
