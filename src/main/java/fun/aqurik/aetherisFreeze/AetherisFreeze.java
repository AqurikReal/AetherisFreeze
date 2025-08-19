package fun.aqurik.aetherisFreeze;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.Title.Times;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public final class AetherisFreeze extends JavaPlugin implements Listener {
    Logger logger = Bukkit.getLogger();
    public static final Set<String> plohie = ConcurrentHashMap.newKeySet(); // я эту хуйню 30 минут делал блять


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("freeze").setExecutor(new FreezeCMD(this));
        getCommand("unfreeze").setExecutor(new UnFreezeCMD(this));
        logger.info("Запускаюсь");


    }

    @Override
    public void onDisable() {
        logger.info("Выключаюсь");
    }

    @EventHandler
    public void move(PlayerMoveEvent event){
        if (plohie.contains(event.getPlayer().getName())){
            event.setCancelled(true);
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_GLASS_BREAK, 3, -12);
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 10, true, false));
        }

    }

    @EventHandler
    public void move2(PlayerDropItemEvent event){
        if (plohie.contains(event.getPlayer().getName())){
            event.setCancelled(true);
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_GLASS_BREAK, 3, -12);
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 10, true, false));
        }

    }






}
