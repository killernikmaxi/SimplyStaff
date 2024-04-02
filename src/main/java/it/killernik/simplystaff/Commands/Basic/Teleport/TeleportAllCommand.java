package it.killernik.simplystaff.Commands.Basic.Teleport;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import it.killernik.simplystaff.Utils.StaffAlert;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportAllCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {

            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.only-player"), null));
            return true;
        }

        if (!commandSender.hasPermission("ss.tpall")) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        Player p = (Player) commandSender;

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.teleport(p.getLocation());
        }

        p.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.teleportall.message"), p));
        StaffAlert.alert(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.teleportall.alert").replaceAll("%staff%", commandSender.getName()), p);


        return true;

    }
}
