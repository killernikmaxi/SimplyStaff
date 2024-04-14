package it.killernik.simplystaff.Commands.Basic;

import it.killernik.simplystaff.SimplyStaff;
import it.killernik.simplystaff.Utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {

            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.only-player"), null));
            return true;
        }

        if (!commandSender.hasPermission("ss.skull")) {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.no-permission"), null));
            return true;
        }

        if (args.length == 0) {

            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.specify-player"), null));
            return true;

        } else if (args.length == 1) {

            String pname = args[0];
            Player player = Bukkit.getPlayer(pname);

            if (player == null) {
                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.non-existent-player"), null));
                return true;
            } else {

                commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("COMMANDS.Basic.skull.message"), player));
                ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
                skullItem.setDurability((short) 3);
                SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
                skullMeta.setOwner(args[0]);
                skullItem.setItemMeta(skullMeta);

                ((Player) commandSender).getInventory().addItem(skullItem);

                return true;
            }

        } else {
            commandSender.sendMessage(MessageUtil.message(SimplyStaff.INSTANCE.getConfig().getString("ERROR.incorrect-syntax"), null));
            return true;
        }
    }

}
