package com.newestaf.makehorsegod.enchant;

import org.bukkit.enchantments.EnchantmentOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EnchantmentSelect {

    public static EnchantmentEnum[] getPossibleEnchantByLevel(int level, EnchantmentEnum... enchantments) {
        EnchantmentEnum[] output = new EnchantmentEnum[enchantments.length];
        for (int i = 0; i < enchantments.length; i++) {
            if (level >= enchantments[i].getMin(4) && level <= enchantments[i].getMin(1)) {
                output[i] = enchantments[i];
            }
        }
        return output;
    }

    public static EnchantmentEnum selectEnchantmentByWeight(EnchantmentEnum[] enchantments) {
//        Calculate sum of every weight of enchant
        int totalWeight = 0;
        for (EnchantmentEnum enchantment : enchantments) {
            totalWeight += enchantment.getWeight();
        }

//        Sort list by weight
        List<EnchantmentEnum> enchantmentList = new ArrayList<>(List.of(enchantments));
        enchantmentList.sort(Comparator.comparing(EnchantmentEnum::getWeight));

//        Set random pivot
        final int pivot = ThreadLocalRandom.current().nextInt(0, totalWeight);

//        Accumulate weight as traversal element
        double accumulated = 0;

        EnchantmentEnum selectedEnchantment;

        for (EnchantmentEnum enchantment : enchantmentList) {
            accumulated += enchantment.getWeight();

//           if weight is more than pivot
            if (accumulated >= pivot) {
                return enchantment;
            }
        }

        return null;
    }


}
