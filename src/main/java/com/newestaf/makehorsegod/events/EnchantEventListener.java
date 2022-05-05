package com.newestaf.makehorsegod.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.*;

public class EnchantEventListener implements Listener {

    ArrayList<Material> horseArmorList = new ArrayList<>(Arrays.asList(Material.DIAMOND_HORSE_ARMOR, Material.GOLDEN_HORSE_ARMOR, Material.IRON_HORSE_ARMOR, Material.LEATHER_HORSE_ARMOR));

    @EventHandler
    public void onItemEnchant(PrepareItemEnchantEvent event) {
        if (horseArmorList.contains(event.getItem().getType())) {
            event.setCancelled(false);



        }
    }

    private double getBaseEnchantLevel(int book, int slot) {
        double base = (ThreadLocalRandom.current().nextInt(2, 9) + floor(book/2) + ThreadLocalRandom.current().nextInt(1, book + 1));
        switch (slot) {
            case 0 : {
                return floor(max(base / 3, 1));
            }
            case 1 : {
                return floor((base * 2) / 3 + 1);
            }
            case 2 : {
                return floor(max(base, book * 2));
            }
            default: return 0;
        }
    }

    private double getFixedEnchantLevel(int base, int enchantability) {
        double randEnchantability = 1 + ThreadLocalRandom.current().nextInt(0, (enchantability / 4) + 1) + ThreadLocalRandom.current().nextInt(0, (enchantability / 4) + 1);
        double originLevel = base + randEnchantability;
        double randBonusPercent = 1 + (ThreadLocalRandom.current().nextFloat(0, 1) + ThreadLocalRandom.current().nextFloat(0, 1) + 1) * 0.15;

        double fixedLevel = (int) round(originLevel * randBonusPercent);
        if (fixedLevel < 1) {
            fixedLevel = 1;
        }
        return fixedLevel;
    }


}
