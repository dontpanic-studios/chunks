package std.standard.chunks;

import com.destroystokyo.paper.utils.PaperPluginLogger;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import std.standard.chunks.command.ChunkSave;

import java.util.Objects;
import java.util.logging.Logger;

public final class Chunks extends JavaPlugin {

    public Logger log = PaperPluginLogger.getLogger("Chunks: ");
    public static Chunks plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        log.info("Loading");
        Objects.requireNonNull(getCommand("save")).setExecutor(new ChunkSave());
    }

    @Override
    public void onDisable() {
        log.info("Disabling");
    }


}
