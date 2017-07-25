package com.meadowsapps.pkmn.util;

import com.meadowsapps.pkmn.data.DataTable;
import com.meadowsapps.pkmn.data.Nature;
import com.meadowsapps.pkmn.data.Stat;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dylan on 9/15/16.
 */
public class PkmnUtils {

    public static URL getResource(String path) {
        return PkmnUtils.class.getClassLoader().getResource(path);
    }

    public static InputStream getResourceAsStream(String path) {
        return PkmnUtils.class.getClassLoader().getResourceAsStream(path);
    }

    public static ResourceBundle getResources(Class clazz) {
        return ResourceBundle.getBundle("l10n/" + clazz.getSimpleName() + "Resource");
    }

    public static int calculateStat(Stat stat, int baseStat, int iv, int ev, int level, Nature nature) {
        int value = 0;
        if (stat == Stat.HP) {
            value = (int) Math.floor(((2 * baseStat + iv + Math.floor(ev / 4)) * level) / 100) + level + 10;
        } else {
            double modifier = DataTable.getNatureTable().getModifier(nature, stat);
            value = (int) Math.floor((Math.floor(((2 * baseStat + iv + Math.floor(ev / 4)) * level) / 100) + 5) * modifier);
        }
        return value;
    }
}
