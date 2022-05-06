package com.newestaf.makehorsegod.enchant;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.*;

public class EnchantLevel {

    public static double getBaseEnchantLevel(int book, int slot) {
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

    public static double getFixedEnchantLevel(int base, int enchantability) {
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
