package com.newestaf.makehorsegod.events;

import com.newestaf.makehorsegod.enchant.EnchantLevel;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EnchantLevelTest {
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
            double level = EnchantLevel.getBaseEnchantLevel(book, slot);
            if (!(level >= min && level <=max)) {
                failed++;
            }
        }

        //then
        assertThat(failed).isEqualTo(0);
    }

}
