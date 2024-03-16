package it.killernik.simplystaff.Utils;

import it.killernik.simplystaff.SimplyStaff;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageUtil {

    private final SimplyStaff plugin;
    private final MessageUtil messageUtil;

    public MessageUtil(SimplyStaff plugin) {
        this.plugin = plugin;
        this.messageUtil = new MessageUtil(plugin);
    }

    // UTIL FOR MESSAGE SENDING
    public static String message(String message, Player player) {

        // TRANSLATE COLOR
        message = ChatColor.translateAlternateColorCodes('&', message);

        // REPLACE PLACHEHOLDERS
        message = message.replace("%player%", player.getName());

        return message;
    }
}
