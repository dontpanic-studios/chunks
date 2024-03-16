package std.standard.chunks.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.language.Language;

public class coin {

    public ItemStack getCoin() {
        ItemStack stack = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_ITEM_COIN));

        stack.setItemMeta(meta);
        return stack;
    }

}
