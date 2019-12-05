package com.gagezilla100.eggcapture.events;

import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.inventory.ItemStack;

public class eggHit implements Listener {
    @EventHandler
    public void onEggHit(ProjectileHitEvent e) {
        try {
            if (((Player) e.getEntity().getShooter()).getType() == EntityType.PLAYER && e.getHitEntity().getType() != EntityType.PLAYER && e.getEntity().getType() == EntityType.EGG) {
                String permission = "eggcapture." + e.getHitEntity().getName().toLowerCase().replaceAll("_", "").replaceAll(" ", "");
                if (((Player) e.getEntity().getShooter()).hasPermission(permission)) {
                    ItemStack egg = new ItemStack(Material.valueOf(e.getHitEntity().getName().toUpperCase().replaceAll(" ", "_") + "_SPAWN_EGG"));
                    e.getEntity().getWorld().dropItem(e.getHitEntity().getLocation(), egg);
                    e.getHitEntity().remove();

                    ((Player) e.getEntity().getShooter()).sendMessage("§8[§5EggCapture§8] §d" + e.getHitEntity().getName() + " captured!");
                    e.getEntity().remove();
                }
                else {
                    ((Player) e.getEntity().getShooter()).sendMessage("§8[§5EggCapture§8] §cYou do not have permission to catch " + e.getHitEntity().getName());
                    e
                }
            }
        }
        catch (Exception ignore) { }
    }
}
