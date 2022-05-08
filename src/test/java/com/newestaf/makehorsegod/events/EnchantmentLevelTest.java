package com.newestaf.makehorsegod.events;

import com.newestaf.makehorsegod.enchant.EnchantmentLevel;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnchantmentLevelTest {
    @Test
    public void testGetBaseEnchantLevel() {
        //given
        final int book = 15;
        final int slot = 0;

        final int min = 2;
        final int max = 10;

        int failed = 0;

        //when
        for (int i = 0; i < 1000; i++) {
            double level = EnchantmentLevel.getBaseEnchantLevel(book, slot);
            if (!(level >= min && level <=max)) {
                failed++;
            }
        }

        //then
        assertThat(failed).isEqualTo(0);
    }

}
