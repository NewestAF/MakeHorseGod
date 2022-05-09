package com.newestaf.makehorsegod.enchant;

import org.bukkit.enchantments.Enchantment;

public enum EnchantmentEnum {

    PROTECTION (1, 21, 17, 37, 33, 53, 49, 69, -1, -1, 10),
    FIRE_PROTECTION (10, 22, 18, 30, 26, 38, 34, 46, -1, -1, 5),
    EXPLOSIONS_PROTECTION (5, 17, 13, 25, 21, 33, 29, 41, -1, -1, 2),
    PROJECTILE_PROTECTION (3, 18, 9, 24, 15, 30, 21, 36, -1, -1,  5);

//    PROTECTION (Enchantment.PROTECTION_ENVIRONMENTAL, 1, 21, 17, 37, 33, 53, 49, 69, -1, -1, 10),
//    FIRE_PROTECTION (Enchantment.PROTECTION_FIRE,10, 22, 18, 30, 26, 38, 34, 46, -1, -1, 5),
//    EXPLOSIONS_PROTECTION (Enchantment.PROTECTION_EXPLOSIONS, 5, 17, 13, 25, 21, 33, 29, 41, -1, -1, 2),
//    PROJECTILE_PROTECTION (Enchantment.PROTECTION_PROJECTILE, 3, 18, 9, 24, 15, 30, 21, 36, -1, -1,  5);

//    private final Enchantment enchantment;
    private final int minLevelI;
    private final int maxLevelI;
    private final int minLevelII;
    private final int maxLevelII;
    private final int minLevelIII;
    private final int maxLevelIII;
    private final int minLevelIV;
    private final int maxLevelIV;
    private final int minLevelV;
    private final int maxLevelV;
    private final int weight;

//    EnchantmentEnum(Enchantment enchantment, int minLevelI, int maxLevelI,
//                    int minLevelII, int maxLevelII, int minLevelIII, int maxLevelIII,
//                    int minLevelIV, int maxLevelIV, int minLevelV, int maxLevelV,
//                    int weight) {
//        this.enchantment = enchantment;
//        this.minLevelI = minLevelI;
//        this.maxLevelI = maxLevelI;
//        this.minLevelII = minLevelII;
//        this.maxLevelII = maxLevelII;
//        this.minLevelIII = minLevelIII;
//        this.maxLevelIII = maxLevelIII;
//        this.minLevelIV = minLevelIV;
//        this.maxLevelIV = maxLevelIV;
//        this.minLevelV = minLevelV;
//        this.maxLevelV = maxLevelV;
//        this.weight = weight;
//    }

    EnchantmentEnum(int minLevelI, int maxLevelI,
                    int minLevelII, int maxLevelII, int minLevelIII, int maxLevelIII,
                    int minLevelIV, int maxLevelIV, int minLevelV, int maxLevelV,
                    int weight) {
        this.minLevelI = minLevelI;
        this.maxLevelI = maxLevelI;
        this.minLevelII = minLevelII;
        this.maxLevelII = maxLevelII;
        this.minLevelIII = minLevelIII;
        this.maxLevelIII = maxLevelIII;
        this.minLevelIV = minLevelIV;
        this.maxLevelIV = maxLevelIV;
        this.minLevelV = minLevelV;
        this.maxLevelV = maxLevelV;
        this.weight = weight;
    }

//    @Override
//    public String toString() {
//        return this.enchantment.getKey().getKey();
//    }

//    public String getName() {
//        return this.enchantment.getKey().getKey();
//    }

    public int getMin(int power) {
        return switch (power) {
            case 1 -> this.minLevelI;
            case 2 -> this.minLevelII;
            case 3 -> this.minLevelIII;
            case 4 -> this.minLevelIV;
            case 5 -> this.minLevelV;
            default -> -1;
        };
    }

    public int getMax(int power) {
        return switch (power) {
            case 1 -> this.maxLevelI;
            case 2 -> this.maxLevelII;
            case 3 -> this.maxLevelIII;
            case 4 -> this.maxLevelIV;
            case 5 -> this.maxLevelV;
            default -> -1;
        };
    }

    public int[] getPower(int level) {
        int ac = 0;

        boolean I = false, II = false, III = false, IV = false, V = false;

        if (this.checkPower(1, level)) {
            ac++;
            I = true;
        }
        if (this.checkPower(2, level)) {
            ac++;
            II = true;
        }
        if (this.checkPower(3, level)) {
            ac++;
            III = true;
        }
        if (this.checkPower(4, level)) {
            ac++;
            IV = true;
        }
        if (this.checkPower(5, level)) {
            ac++;
            V = true;
        }

        if (!I && !II && !III && !IV && !V) {
            return new int[]{0};
        }

        int[] output = new int[ac];
        int ah = 0;

        if (I) {
            output[ah] = 1;
            ah++;
        }
        if (II) {
            output[ah] = 1;
            ah++;
        }
        if (III) {
            output[ah] = 1;
            ah++;
        }
        if (IV) {
            output[ah] = 1;
            ah++;
        }
        if (V) {
            output[ah] = 1;
        }

        return output;
    }

    public boolean checkPower(int power, int level) {
        return level >= this.getMin(power) && this.getMax(power) <= level;
    }

    public int getWeight() {
        return this.weight;
    }


}
