package std.standard.chunks;

import com.destroystokyo.paper.utils.PaperPluginLogger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import std.standard.chunks.command.ChunkConfigurator;
import std.standard.chunks.command.ChunksConfiguratorSubCommand;
import std.standard.chunks.events.chunk.*;
import std.standard.chunks.events.player.BuyChunkRightClick;
import std.standard.chunks.events.player.PlayerShiftShowCropTime;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public final class Chunks extends JavaPlugin {

    public Logger log = PaperPluginLogger.getLogger("Chunks");
    public static Chunks plugin;
    public File chunkDataFile;
    private FileConfiguration chunkData;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        log.info("Loading");
        createPlayerDataYml();
        Objects.requireNonNull(getCommand("chunks")).setExecutor(new ChunkConfigurator());
        Objects.requireNonNull(getCommand("chunks")).setTabCompleter(new ChunksConfiguratorSubCommand());

        getServer().getPluginManager().registerEvents(new InteractionEntity(), this);
        getServer().getPluginManager().registerEvents(new PistonHeadMove(), this);
        getServer().getPluginManager().registerEvents(new InteractionChest(), this);
        getServer().getPluginManager().registerEvents(new InteractionPlants(), this);
        getServer().getPluginManager().registerEvents(new InteractionAll(), this);
        //getServer().getPluginManager().registerEvents(new PlayerShiftShowCropTime(), this);
        //getServer().getPluginManager().registerEvents(new BuyChunkRightClick(), this);
        //getServer().getPluginManager().registerEvents(new CheckOwnedChunk(), this);
        //getServer().getPluginManager().registerEvents(new CheckChunkChange(), this);
    }

    @Override
    public void onDisable() {
        log.info("Disabling");
    }

    public void createPlayerDataYml() {
        chunkDataFile = new File(getDataFolder(), "chunk.yml");
        if (!chunkDataFile.exists()) {
            log.warning("파일 만드는중.");
            chunkDataFile.getParentFile().mkdirs();
            saveResource("chunk.yml", false);
            log.info("파일 만들어짐.");
        } else {
            log.info("파일 확인됨.");
        }

        chunkData = new YamlConfiguration();
        try {
            chunkData.load(chunkDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            log.severe("플레이어 데이터을 불러오는중에 오류가 발생했습니다, 파일이 유효한가요?");
            e.printStackTrace();
            plugin.setEnabled(false);
        }
    }

    public FileConfiguration getChunkData() {
        return this.chunkData;
    }

}
