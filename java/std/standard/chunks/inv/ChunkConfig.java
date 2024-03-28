package std.standard.chunks.inv;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.language.Language;

public class ChunkConfig {

    public Inventory chunkConfigGUI(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9, ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_GUI_TITLE));

        return inv;
    }

}
