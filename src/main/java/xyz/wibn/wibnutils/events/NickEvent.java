package xyz.wibn.wibnutils.events;

import net.dev.eazynick.api.NickManager;
import net.dev.eazynick.api.PlayerNickEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.wibn.wibnutils.WiBnUtils;

public class NickEvent implements Listener {

	@EventHandler
	public void onNickEvent(PlayerNickEvent e) {
		Player player = e.getPlayer();
		NickManager nickManager = new NickManager(player);
		Bukkit.getScheduler().runTaskLaterAsynchronously(WiBnUtils.getInstance(), nickManager::updatePlayer, 20L);
	}
}
