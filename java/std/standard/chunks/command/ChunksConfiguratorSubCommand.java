package std.standard.chunks.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import std.standard.chunks.enums.Settings;

import java.util.ArrayList;
import java.util.List;

public class ChunksConfiguratorSubCommand implements TabCompleter {

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(args.length == 2) {
            List<String> avaConfigs = new ArrayList<>();
            if(args[0].equalsIgnoreCase("config")) {
                for (int i = 0; i < Settings.values().length; i++) {
                    avaConfigs.add(String.valueOf(Settings.values()[i]));
                }
            } else {
                avaConfigs.add("confirm");
            }
            return avaConfigs;
        } else if(args.length == 1) {
            List<String> set = new ArrayList<>();
            set.add("config");
            set.add("reset");
            set.add("save");
            set.add("coin");

            return set;
        } else if(args.length == 3) {
            List<String> tf = new ArrayList<>();
            tf.add("true");
            tf.add("false");
            return tf;
        }
        return null;
    }
}
