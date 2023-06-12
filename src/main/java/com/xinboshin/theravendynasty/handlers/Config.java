package com.xinboshin.theravendynasty.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
    private static final String GENERIC_CATEGORY = "Generic Config";

    public static int exampleInt = 512;
    public static boolean exampleBoolean = false;

    public static void load(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "TheRavenDynasty.cfg"), "1.1", true);
        config.load();

        config.addCustomCategoryComment(GENERIC_CATEGORY, "Config for The Raven Dynasty, created by Xinboshin.");

        exampleInt = config.getInt("TheRavenDynastyInt", GENERIC_CATEGORY, 512, Short.MIN_VALUE, Short.MAX_VALUE,
                "The Raven Dynasty int property");

        exampleBoolean = config.getBoolean("TheRavenDynastyBoolean", GENERIC_CATEGORY, false,
                "The Raven Dynasty boolean property");

        config.save();
    }

}
