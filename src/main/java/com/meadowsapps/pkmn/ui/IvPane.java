package com.meadowsapps.pkmn.ui;

import com.meadowsapps.pkmn.data.Nature;
import com.meadowsapps.pkmn.data.Stat;
import com.meadowsapps.pkmn.ui.control.IvEditor;
import com.meadowsapps.pkmn.util.PkmnUtils;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ResourceBundle;

/**
 * Created by dmeadows on 10/20/2016
 */
public class IvPane extends UIPane {

    private int[] ivs;

    private IvEditor hpIvEditor;
    private IvEditor attackIvEditor;
    private IvEditor defenseIvEditor;
    private IvEditor spAttackIvEditor;
    private IvEditor spDefenseIvEditor;
    private IvEditor speedIvEditor;

    public IvPane() {
        ivs = new int[6];
        for (int i = 0; i < ivs.length; i++) {
            ivs[i] = 31;
        }
    }

    @Override
    protected void initComponents() {
        ResourceBundle bundle = PkmnUtils.getResources(getClass());

        hpIvEditor = new IvEditor(Stat.HP);
        attackIvEditor = new IvEditor(Stat.Attack);
        defenseIvEditor = new IvEditor(Stat.Defense);
        spAttackIvEditor = new IvEditor(Stat.SpAttack);
        spDefenseIvEditor = new IvEditor(Stat.SpDefense);
        speedIvEditor = new IvEditor(Stat.Speed);

        //======== this ========
        setHeaderText(bundle.getString("header.text"));
        setShowBorder(false);
        setLayoutGap(10.0, 10.0);

        //---- hpIvEditor ----
        hpIvEditor.setEditable(true);
        hpIvEditor.setMaxWidth(Double.MAX_VALUE);
        hpIvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onIvEditorValueChanged(observable);
        });
        add(hpIvEditor, 0, 0);

        //---- attackIvEditor ----
        attackIvEditor.setEditable(true);
        attackIvEditor.setMaxWidth(Double.MAX_VALUE);
        attackIvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onIvEditorValueChanged(observable);
        });
        add(attackIvEditor, 0, 1);

        //---- defenseIvEditor ----
        defenseIvEditor.setEditable(true);
        defenseIvEditor.setMaxWidth(Double.MAX_VALUE);
        defenseIvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onIvEditorValueChanged(observable);
        });
        add(defenseIvEditor, 0, 2);

        //---- spAttackIvEditor ----
        spAttackIvEditor.setEditable(true);
        spAttackIvEditor.setMaxWidth(Double.MAX_VALUE);
        spAttackIvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onIvEditorValueChanged(observable);
        });
        add(spAttackIvEditor, 0, 3);

        //---- spDefenseIvEditor ----
        spDefenseIvEditor.setEditable(true);
        spDefenseIvEditor.setMaxWidth(Double.MAX_VALUE);
        spDefenseIvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onIvEditorValueChanged(observable);
        });
        add(spDefenseIvEditor, 0, 4);

        //---- speedIvEditor ----
        speedIvEditor.setEditable(true);
        speedIvEditor.setMaxWidth(Double.MAX_VALUE);
        speedIvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onIvEditorValueChanged(observable);
        });
        add(speedIvEditor, 0, 5);
    }

    @Override
    protected void setupColumnConstraints(ObservableList<ColumnConstraints> constraints) {
        // Column 0
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
            row.setValignment(VPos.CENTER);
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 2
        {
            RowConstraints row = new RowConstraints();
            row.setValignment(VPos.CENTER);
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 3
        {
            RowConstraints row = new RowConstraints();
            row.setValignment(VPos.CENTER);
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 4
        {
            RowConstraints row = new RowConstraints();
            row.setValignment(VPos.CENTER);
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 5
        {
            RowConstraints row = new RowConstraints();
            row.setValignment(VPos.CENTER);
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
        // Row 6
        {
            RowConstraints row = new RowConstraints();
            row.setValignment(VPos.CENTER);
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
    }

    private IvEditor getIvEditor(Stat stat) {
        IvEditor rv = null;
        switch (stat) {
            case HP:
                rv = hpIvEditor;
                break;
            case Attack:
                rv = attackIvEditor;
                break;
            case Defense:
                rv = defenseIvEditor;
                break;
            case SpAttack:
                rv = spAttackIvEditor;
                break;
            case SpDefense:
                rv = spDefenseIvEditor;
                break;
            case Speed:
                rv = speedIvEditor;
                break;
        }
        return rv;
    }

    private IvEditor getIvEditor(Observable observable) {
        IvEditor rv = null;
        if (observable instanceof ReadOnlyProperty) {
            rv = (IvEditor) ((ReadOnlyProperty) observable).getBean();
        }
        return rv;
    }

    private void onIvEditorValueChanged(Observable observable) {
        IvEditor editor = getIvEditor(observable);
        if (editor != null) {
            Stat stat = editor.getStat();
            ivs[stat.ordinal()] = editor.getValue();
            MainView.getInstance().getResultPane().update(stat);
        }
    }

    public int[] getIvs() {
        return ivs;
    }

    public int getIv(Stat stat) {
        return ivs[stat.ordinal()];
    }

    public void setIvs(int[] ivs) {
        this.ivs = ivs;
    }

    public void setIv(Stat stat, int iv) {
        ivs[stat.ordinal()] = iv;
    }
}
