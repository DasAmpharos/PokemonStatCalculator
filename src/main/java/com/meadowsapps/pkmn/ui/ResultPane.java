package com.meadowsapps.pkmn.ui;

import com.meadowsapps.pkmn.data.Nature;
import com.meadowsapps.pkmn.data.Stat;
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
public class ResultPane extends UIPane {

    private Label hpLbl;
    private Label hpValue;
    private Label attackLbl;
    private Label attackValue;
    private Label defenseLbl;
    private Label defenseValue;
    private Label spAttackLbl;
    private Label spAttackValue;
    private Label spDefenseLbl;
    private Label spDefenseValue;
    private Label speedLbl;
    private Label speedValue;

    @Override
    protected void initComponents() {
        ResourceBundle bundle = PkmnUtils.getResources(getClass());

        hpLbl = new Label();
        hpValue = new Label();
        attackLbl = new Label();
        attackValue = new Label();
        defenseLbl = new Label();
        defenseValue = new Label();
        spAttackLbl = new Label();
        spAttackValue = new Label();
        spDefenseLbl = new Label();
        spDefenseValue = new Label();
        speedLbl = new Label();
        speedValue = new Label();

        //======== this ========
        setHeaderText(bundle.getString("header.text"));
        setShowBorder(true);
        setLayoutPadding(new Insets(10.0));
        setLayoutGap(20.0, 10.0);

        //---- hpLbl ----
        hpLbl.setText(Stat.HP.toString() + ":");
        add(hpLbl, 0, 0);

        //---- hpValue ----
        add(hpValue, 1, 0);

        //---- attackLbl ----
        attackLbl.setText(Stat.Attack.toString() + ":");
        add(attackLbl, 0, 1);

        //---- attackValue ----
        add(attackValue, 1, 1);

        //---- defenseLbl ----
        defenseLbl = new Label();
        defenseLbl.setText(Stat.Defense.toString() + ":");
        add(defenseLbl, 0, 2);

        //---- defenseValue ----
        add(defenseValue, 1, 2);

        //---- spAttackLbl ----
        spAttackLbl.setText(Stat.SpAttack.toString() + ":");
        add(spAttackLbl, 0, 3);

        //---- spAttackValue ----
        add(spAttackValue, 1, 3);

        //---- spDefenseLbl ----
        spDefenseLbl.setText(Stat.SpDefense.toString() + ":");
        add(spDefenseLbl, 0, 4);

        //---- spDefenseValue ----
        add(spDefenseValue, 1, 4);

        //---- speedLbl ----
        speedLbl.setText(Stat.Speed.toString() + ":");
        add(speedLbl, 0, 5);

        //---- speedValue ----
        add(speedValue, 1, 5);
    }

    @Override
    protected void setupColumnConstraints(ObservableList<ColumnConstraints> constraints) {
        // Column 0
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.RIGHT);
            column.setHgrow(Priority.SOMETIMES);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
        // Column 1
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.LEFT);
            column.setHgrow(Priority.SOMETIMES);
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
    }

    private Label getResultValue(Stat stat) {
        Label rv = null;
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

    public void setResults(int[] results) {
        for (Stat stat : Stat.values()) {
            setResult(stat, results[stat.ordinal()]);
        }
    }

    public void setResult(Stat stat, int result) {
        String s = Integer.toString(result);
        getResultValue(stat).setText(s);
    }

    public void update() {
        for (Stat stat : Stat.values()) {
            update(stat);
        }
    }

    public void update(Stat stat) {
        MainView instance = MainView.getInstance();
        int baseStat = instance.getBaseStatPane().getBaseStat(stat);
        int iv = instance.getStatPane().getIv(stat);
        int ev = instance.getStatPane().getEv(stat);
        int level = instance.getInfoPane().getLevel();
        Nature nature = instance.getInfoPane().getNature();

        int result = PkmnUtils.calculateStat(stat, baseStat, iv, ev, level, nature);
        getResultValue(stat).setText(Integer.toString(result));
    }

}
