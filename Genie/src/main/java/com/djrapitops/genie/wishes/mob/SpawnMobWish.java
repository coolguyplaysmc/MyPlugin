/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.djrapitops.genie.wishes.mob;

import com.djrapitops.genie.wishes.Wish;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/**
 *
 * @author Rsl1122
 */
public class SpawnMobWish extends Wish {

    private final EntityType mobToSpawn;

    public SpawnMobWish(EntityType mobToSpawn) {
        super(getProperMobname(mobToSpawn.name()));
        this.mobToSpawn = mobToSpawn;
    }

    private static String getProperMobname(String mobName) {
        String replacedWSpace = mobName.replace("_", " ");
        return replacedWSpace;
    }

    @Override
    public boolean fulfillWish(Player p) {
        Location aboveHead = p.getLocation().add(new Location(p.getWorld(), 0, 2, 0));
        p.getWorld().spawnEntity(aboveHead, mobToSpawn);
        return true;
    }
}
