package com.meadowsapps.pkmn.data;

import com.meadowsapps.pkmn.util.PkmnUtils;
import javafx.scene.paint.Color;

import java.util.ResourceBundle;

/**
 * Created by Dylan on 9/13/16.
 */
public enum Stat {
    HP(Color.valueOf("#FF0000")),
    Attack(Color.valueOf("#F08232")),
    Defense(Color.valueOf("#FAD232")),
    SpAttack(Color.valueOf("#6E90F0")),
    SpDefense(Color.valueOf("#78C850")),
    Speed(Color.valueOf("#FA5A8C"));

    private Color fill;

    private static ResourceBundle bundle = PkmnUtils.getResources(Stat.class);

    Stat(Color fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        return bundle.getString(name());
    }

    public Color getFill() {
        return fill;
    }
}
