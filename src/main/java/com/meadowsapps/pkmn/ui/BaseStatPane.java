package com.meadowsapps.pkmn.ui;

import com.meadowsapps.pkmn.data.Stat;
import com.meadowsapps.pkmn.ui.control.BaseStatBar;
import com.meadowsapps.pkmn.util.PkmnUtils;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ResourceBundle;

/**
 * Created by dmeadows on 10/19/2016
 */
public class BaseStatPane extends UIPane {

    private Integer[] baseStats;

    private Label hpLbl;
    private BaseStatBar hpValue;
    private Label attackLbl;
    private BaseStatBar attackValue;
    private Label defenseLbl;
    private BaseStatBar defenseValue;
    private Label spAttackLbl;
    private BaseStatBar spAttackValue;
    private Label spDefenseLbl;
    private BaseStatBar spDefenseValue;
    private Label speedLbl;
    private BaseStatBar speedValue;
    private Label baseStatTotalLbl;
    private Label baseStatTotalValue;

    @Override
    protected void initComponents() {
        ResourceBundle bundle = PkmnUtils.getResources(getClass());

        hpLbl = new Label();
        hpValue = new BaseStatBar(Stat.HP);
        attackLbl = new Label();
        attackValue = new BaseStatBar(Stat.Attack);
        defenseLbl = new Label();
        defenseValue = new BaseStatBar(Stat.Defense);
        spAttackLbl = new Label();
        spAttackValue = new BaseStatBar(Stat.SpAttack);
        spDefenseLbl = new Label();
        spDefenseValue = new BaseStatBar(Stat.SpDefense);
        speedLbl = new Label();
        speedValue = new BaseStatBar(Stat.Speed);
        baseStatTotalLbl = new Label();
        baseStatTotalValue = new Label();

        //======== this ========
        setHeaderText(bundle.getString("header.text"));
        setShowBorder(true);
        setLayoutPadding(new Insets(10.0));
        setLayoutGap(10.0, 10.0);

        //---- hpLbl ----
        hpLbl.setText(Stat.HP.toString() + ":");
        add(hpLbl, 0, 0);

        //---- hpValue ----
        hpValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(hpValue, 1, 0);

        //---- attackLbl ----
        attackLbl.setText(Stat.Attack.toString() + ":");
        add(attackLbl, 0, 1);

        //---- attackValue ----
        attackValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(attackValue, 1, 1);

        //---- defenseLbl ----
        defenseLbl.setText(Stat.Defense.toString() + ":");
        add(defenseLbl, 0, 2);

        //---- defenseValue ----
        defenseValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(defenseValue, 1, 2);

        //---- spAttackLbl ----
        spAttackLbl.setText(Stat.SpAttack.toString() + ":");
        add(spAttackLbl, 0, 3);

        //---- spAttackValue ----
        spAttackValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(spAttackValue, 1, 3);

        //---- spDefenseLbl ----
        spDefenseLbl = new Label();
        spDefenseLbl.setText(Stat.SpDefense.toString() + ":");
        add(spDefenseLbl, 0, 4);

        //---- spDefenseValue ----
        spDefenseValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(spDefenseValue, 1, 4);

        //---- speedLbl ----
        speedLbl.setText(Stat.Speed.toString() + ":");
        add(speedLbl, 0, 5);

        //---- speedValue ----
        speedValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(speedValue, 1, 5);

        //---- baseStatTotalLbl ----
        baseStatTotalLbl.setText(bundle.getString("baseStatTotalLbl.text") + ":");
        baseStatTotalLbl.getStyleClass().add("value");
        add(baseStatTotalLbl, 0, 6);

        //---- baseStatTotalValue ----
        baseStatTotalValue.setText("0");
        baseStatTotalValue.getStyleClass().add("value");
        add(baseStatTotalValue, 1, 6);
    }

    @Override
    protected void setupColumnConstraints(ObservableList<ColumnConstraints> constraints) {
        // Column 0
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.RIGHT);
            column.setHgrow(Priority.NEVER);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
        // Column 1
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.LEFT);
            column.setHgrow(Priority.ALWAYS);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
    }

    @Override
    protected void setupRowConstraints(ObservableList<RowConstraints> constraints) {
        // Row 0
        {
            RowConstraints row = new RowConstraints();
            row.setValignment(VPos.CENTER);
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 1
        {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 2
        {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 3
        {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 4
        {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 5
        {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 6
        {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
    }

    private BaseStatBar getBaseStatBar(Stat stat) {
        BaseStatBar rv = null;
        switch (stat) {
            case HP:
                rv = hpValue;
                break;
            case Attack:
                rv = attackValue;
                break;
            case Defense:
                rv = defenseValue;
                break;
            case SpAttack:
                rv = spAttackValue;
                break;
            case SpDefense:
                rv = spDefenseValue;
                break;
            case Speed:
                rv = speedValue;
                break;
        }
        return rv;
    }

    public Integer[] getBaseStats() {
        return this.baseStats;
    }

    public Integer getBaseStat(Stat stat) {
        return getBaseStats()[stat.ordinal()];
    }

    public void setBaseStats(Integer[] baseStats) {
        this.baseStats = baseStats;

        int total = 0;
        for (Stat stat : Stat.values()) {
            int value = baseStats[stat.ordinal()];
            getBaseStatBar(stat).setValue(value);
            total += value;
        }
        baseStatTotalValue.setText(Integer.toString(total));
    }
}
