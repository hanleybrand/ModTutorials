package mcjty.modtut;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";

    public static boolean isThisAGoodTutorial = true;
    public static String yourRealName = "Steve";

    public static void readConfig() {
        Configuration cfg = ModTut.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e1) {
            ModTut.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        isThisAGoodTutorial = cfg.getBoolean("goodTutorial", CATEGORY_GENERAL, isThisAGoodTutorial, "Set to false if you don't like this tutorial");
        yourRealName = cfg.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
    }

    private static void initDimensionConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");

    }
}