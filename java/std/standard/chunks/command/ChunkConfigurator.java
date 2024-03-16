package std.standard.chunks.command;

import com.google.common.base.Enums;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import std.standard.chunks.Chunks;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.enums.Settings;
import std.standard.chunks.item.coin;
import std.standard.chunks.language.Language;


public class ChunkConfigurator implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) commandSender;
        if(p.isOp()) {
            if (args[0].equalsIgnoreCase("save")) {
                p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_TRY_CHUNK_SAVE));
                try {
                    Chunks.plugin.getChunkData().save(Chunks.plugin.chunkDataFile);
                    p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_SAVED));
                } catch (Exception e) {
                    p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_SAVE_FAILED));
                }
            } else if (args[0].equalsIgnoreCase("config")) {
                String arg = args[1];
                if (Enums.getIfPresent(Settings.class, arg).isPresent()) {
                    try {
                        if (args[2].equalsIgnoreCase("true")) {
                            Chunks.plugin.getChunkData().set(p.getChunk().getChunkKey() + ".configs." + arg, 1);
                        } else {
                            Chunks.plugin.getChunkData().set(p.getChunk().getChunkKey() + ".configs." + arg, 0);
                        }
                        p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_SETTING_CHANGED));
                        p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_NEED_SAVE));
                    } catch (Exception e) {
                        p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_INVALID));
                    }
                } else {
                    p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_UNDEFINED_SETTING));
                }
            } else if (args[0].equalsIgnoreCase("reset")) {
                try {
                    if (!args[1].isEmpty()) {
                        Chunks.plugin.getChunkData().set(p.getChunk().getChunkKey() + ".configs", null);
                        p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_SETTING_RESETED));
                    }
                } catch (Exception e) {
                    p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CONFIRM_RESET));
                }
            } else if(args[0].equalsIgnoreCase("coin")) {
                p.getInventory().addItem(new coin().getCoin());
            }
            else {
                p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_INVALID_COMMAND));
            }
            return true;
        } else {
            p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_NO_PERMISSION));
        }

        return true;
    }
}
