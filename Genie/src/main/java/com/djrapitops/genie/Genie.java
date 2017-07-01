package com.djrapitops.genie;

import com.djrapitops.genie.command.GenieCommand;
import com.djrapitops.genie.file.LampStorage;
import com.djrapitops.genie.file.WishLog;
import com.djrapitops.genie.lamp.LampManager;
import com.djrapitops.javaplugin.RslPlugin;
import com.djrapitops.javaplugin.api.ColorScheme;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;

/**
 * Main class.
 *
 * @author Rsl1122
 */
public class Genie extends RslPlugin<Genie> {

    private LampManager lampManager;
    private WishLog wishLog;

    @Override
    public void onEnable() {
        super.setInstance(this);
        super.setLogPrefix("[Genie]");
        super.setUpdateCheckUrl("https://raw.githubusercontent.com/Rsl1122/Genie/master/Genie/src/main/resources/plugin.yml");
        super.setColorScheme(new ColorScheme(ChatColor.DARK_AQUA, ChatColor.GRAY, ChatColor.AQUA));
        super.setDebugMode("console");
        super.onEnableDefaultTasks();
        processStatus().startExecution("onEnable");
        wishLog = new WishLog(this);
        try {
            LampStorage lampStorage = new LampStorage(this);
            lampManager = new LampManager(this, lampStorage);
        } catch (IOException | InvalidConfigurationException ex) {
            Log.toLog(this.getClass().getName(), ex);
            Log.error("Could not create 'lamps' storage file");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        registerListener(new ChatListener(this));
        registerCommand(new GenieCommand(this));
        processStatus().finishExecution("onEnable");
        Log.info("Plugin Enabled.");
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        taskStatus().cancelAllKnownTasks();
        Log.info("Plugin Disabled.");
    }

    public static Genie getInstance() {
        return (Genie) getPluginInstance();
    }

    public WishLog getWishLog() {
        return wishLog;
    }

    public LampManager getLampManager() {
        return lampManager;
    }
}
