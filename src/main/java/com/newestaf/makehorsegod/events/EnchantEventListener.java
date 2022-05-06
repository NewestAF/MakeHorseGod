package com.newestaf.makehorsegod.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.*;

public class EnchantEventListener implements Listener {

    final ArrayList<Material> horseArmorList = new ArrayList<>(Arrays.asList(Material.DIAMOND_HORSE_ARMOR, Material.GOLDEN_HORSE_ARMOR, Material.IRON_HORSE_ARMOR, Material.LEATHER_HORSE_ARMOR));

    @EventHandler
    public void onItemEnchant(PrepareItemEnchantEvent event) {
        if (horseArmorList.contains(event.getItem().getType())) {
            event.setCancelled(false);



        }
    }

}
