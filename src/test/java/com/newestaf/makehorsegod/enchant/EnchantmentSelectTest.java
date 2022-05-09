package com.newestaf.makehorsegod.enchant;

import org.assertj.core.error.ShouldNotBeNull;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.assertThat;

public class EnchantmentSelectTest {

    @Test
    public void testGetPossibleEnchantByLevel() {
//        given
        final EnchantmentEnum[] enchantments = {EnchantmentEnum.PROTECTION,
                EnchantmentEnum.FIRE_PROTECTION, EnchantmentEnum.PROJECTILE_PROTECTION, EnchantmentEnum.EXPLOSIONS_PROTECTION};

        final EnchantmentEnum[] expected = {EnchantmentEnum.PROTECTION};

        final int fixedLevel = 42;

//        when
        EnchantmentEnum[] selected = EnchantmentSelect.getPossibleEnchantByLevel(fixedLevel, enchantments);
//        then
        assertThat(selected).contains(expected);

    }

    @Test
    public void testSelectEnchantmentByWeight() {
//        given
        final EnchantmentEnum[] enchantments = {EnchantmentEnum.PROTECTION, EnchantmentEnum.FIRE_PROTECTION, EnchantmentEnum.PROJECTILE_PROTECTION, EnchantmentEnum.EXPLOSIONS_PROTECTION};

        final int trial = 22000;

        int selected1 = 0;
        int selected2 = 0;
        int selected3 = 0;
        int selected4 = 0;

//        when
        for (int i = 0; i < trial; i++) {
            EnchantmentEnum selectedEnchant = EnchantmentSelect.selectEnchantmentByWeight(enchantments);
            if (selectedEnchant != null) {
                switch (selectedEnchant) {
                    case PROTECTION -> selected1++;
                    case FIRE_PROTECTION -> selected2++;
                    case PROJECTILE_PROTECTION -> selected3++;
                    case EXPLOSIONS_PROTECTION -> selected4++;
                }
            }
        }
//        then
        System.out.println(selected1 + " " + selected2 + " " + selected3 + " " + selected4);

    }
}
