package it.killernik.simplystaff.Listener.player;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AsyncPlayerChatEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(org.bukkit.event.player.AsyncPlayerChatEvent e) {
        if (SimplyStaff.INSTANCE.getConfig().getBoolean("COMMANDS.freeze.block-chat.enabled")) return;
        Player p = e.getPlayer();
        if (!SimplyStaff.INSTANCE.freezeManager.isFrozen(p)) return;
        e.setCancelled(true);
        p.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.freeze.block-chat.message"), p));
    }

}
