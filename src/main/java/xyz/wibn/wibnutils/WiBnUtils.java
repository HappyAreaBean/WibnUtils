package xyz.wibn.wibnutils;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.wibn.wibnutils.events.NickEvent;
import xyz.wibn.wibnutils.utils.Color;

import java.util.Arrays;

public class WiBnUtils extends JavaPlugin {

	@Getter
	private static WiBnUtils instance;
	private final String prefix = Color.translate("&8[&3WiBnUtils&8] &e");

	@Override
	public void onEnable() {
		instance = this;
		startupMessage();

		registerEvents();
	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new NickEvent(), this);
	}

	public void startupMessage() {
		Arrays.asList(
				"",
				" __        ___ ____                    ",
				" \\ \\      / (_) __ ) _ __              ",
				"  \\ \\ /\\ / /| |  _ \\| '_ \\             ",
				"   \\ V  V / | | |_) | | | |            ",
				"    \\_/\\_/  |_|____/|_| |_|            ",
				"                     _   _ _   _ _     ",
				"                    | | | | |_(_) |___ ",
				"                    | | | | __| | / __|",
				"                    | |_| | |_| | \\__ \\",
				"                     \\___/ \\__|_|_|___/",
				"",
				"   &3WiBn Utility",
				"   &fv" + getDescription().getVersion() + " &fMade With &4❤ &fBy HappyAreaBean",
				""
		).forEach((m -> Bukkit.getConsoleSender().sendMessage(Color.translate(prefix + m))));
	}
}
