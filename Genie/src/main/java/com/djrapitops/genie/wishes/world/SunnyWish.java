/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.djrapitops.genie.wishes.world;

import com.djrapitops.genie.wishes.Wish;
import org.bukkit.entity.Player;

/**
 *
 * @author Rsl1122
 */
public class SunnyWish extends Wish {

    public SunnyWish() {
        super("Sunny", "Clear", "Not Rain");
    }
    
    @Override
    public boolean fulfillWish(Player p) {
        p.getWorld().setStorm(false);
        p.getWorld().setThundering(false);
        return true;
    }

}
