package std.standard.chunks.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.language.Language;

public class ChunkSave implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_TRY_CHUNK_SAVE));

        return true;
    }
}
