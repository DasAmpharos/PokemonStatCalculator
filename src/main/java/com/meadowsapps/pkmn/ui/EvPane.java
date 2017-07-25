package com.meadowsapps.pkmn.ui;

import com.meadowsapps.pkmn.data.Stat;
import com.meadowsapps.pkmn.ui.control.EvEditor;
import com.meadowsapps.pkmn.ui.control.SliderGroup;
import com.meadowsapps.pkmn.util.PkmnUtils;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ResourceBundle;

/**
 * Created by dmeadows on 10/20/2016
 */
public class EvPane extends UIPane {

    private int[] evs;

    private Label hpLbl;
    private EvEditor hpEvEditor;
    private Label attackLbl;
    private EvEditor attackEvEditor;
    private Label defenseLbl;
    private EvEditor defenseEvEditor;
    private Label spAttackLbl;
    private EvEditor spAttackEvEditor;
    private Label spDefenseLbl;
    private EvEditor spDefenseEvEditor;
    private Label speedLbl;
    private EvEditor speedEvEditor;
    private GridPane evTotalLayout;
    private Label evTotalLbl;
    private Label evTotalValue;
    private SliderGroup evTotalGroup;

    public EvPane() {
        evs = new int[6];
    }

    @Override
    protected void initComponents() {
        ResourceBundle bundle = PkmnUtils.getResources(getClass());

        hpLbl = new Label();
        hpEvEditor = new EvEditor(Stat.HP);
        attackLbl = new Label();
        attackEvEditor = new EvEditor(Stat.Attack);
        defenseLbl = new Label();
        defenseEvEditor = new EvEditor(Stat.Defense);
        spAttackLbl = new Label();
        spAttackEvEditor = new EvEditor(Stat.SpAttack);
        spDefenseLbl = new Label();
        spDefenseEvEditor = new EvEditor(Stat.SpDefense);
        speedLbl = new Label();
        speedEvEditor = new EvEditor(Stat.Speed);
        evTotalGroup = new SliderGroup(510);
        evTotalLayout = new GridPane();
        evTotalLbl = new Label();
        evTotalValue = new Label();

        //======== this ========
        setHeaderText(bundle.getString("header.text"));
        setShowBorder(false);
        setLayoutGap(10.0, 10.0);

        //---- hpLbl ----
        hpLbl.setText(Stat.HP.toString() + ":");
        add(hpLbl, 0, 0);

        //---- hpEvEditor ----
        hpEvEditor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        hpEvEditor.setSliderGroup(evTotalGroup);
        hpEvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onEvEditorValueChanged(observable);
        });
        add(hpEvEditor, 1, 0);

        //---- attackLbl ----
        attackLbl.setText(Stat.Attack.toString() + ":");
        add(attackLbl, 0, 1);

        //---- attackEvEditor ----
        attackEvEditor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        attackEvEditor.setSliderGroup(evTotalGroup);
        attackEvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onEvEditorValueChanged(observable);
        });
        add(attackEvEditor, 1, 1);

        //---- defenseLbl ----
        defenseLbl.setText(Stat.Defense.toString() + ":");
        add(defenseLbl, 0, 2);

        //---- defenseEvEditor ----
        defenseEvEditor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        defenseEvEditor.setSliderGroup(evTotalGroup);
        defenseEvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onEvEditorValueChanged(observable);
        });
        add(defenseEvEditor, 1, 2);

        //---- spAttackLbl ----
        spAttackLbl.setText(Stat.SpAttack.toString() + ":");
        add(spAttackLbl, 0, 3);

        //---- spAttackEvEditor ----
        spAttackEvEditor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        spAttackEvEditor.setSliderGroup(evTotalGroup);
        spAttackEvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onEvEditorValueChanged(observable);
        });
        add(spAttackEvEditor, 1, 3);

        //---- spDefenseLbl ----
        spDefenseLbl.setText(Stat.SpDefense.toString() + ":");
        add(spDefenseLbl, 0, 4);

        //---- spDefenseEvEditor ----
        spDefenseEvEditor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        spDefenseEvEditor.setSliderGroup(evTotalGroup);
        spDefenseEvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onEvEditorValueChanged(observable);
        });
        add(spDefenseEvEditor, 1, 4);

        //---- speedLbl ----
        speedLbl.setText(Stat.Speed.toString() + ":");
        add(speedLbl, 0, 5);

        //---- speedEvEditor ----
        speedEvEditor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        speedEvEditor.setSliderGroup(evTotalGroup);
        speedEvEditor.valueProperty().addListener((observable, oldValue, newValue) -> {
            onEvEditorValueChanged(observable);
        });
        add(speedEvEditor, 1, 5);

        //======== evTotalLayout ========
        {
            evTotalLayout.setHgap(10.0);
            evTotalLayout.setVgap(10.0);
            add(evTotalLayout, 1, 6);
            // Constraints
            {
                // ColumnConstraints
                ObservableList<ColumnConstraints> columns = evTotalLayout.getColumnConstraints();
                {
                    HPos[] alignment = {HPos.RIGHT, HPos.LEFT};
                    Priority[] grow = {Priority.NEVER, Priority.SOMETIMES};
                    for (int i = 0; i < 2; i++) {
                        ColumnConstraints column = new ColumnConstraints();
                        column.setHalignment(alignment[i]);
                        column.setHgrow(grow[i]);
                        column.setMinWidth(10.0);
                        if (i == 1) {
                            column.setPrefWidth(100.0);
                        }
                        columns.add(column);
                    }
                }
                // RowConstraints
                {
                    RowConstraints row = new RowConstraints();
                    row.setVgrow(Priority.SOMETIMES);
                    row.setMinHeight(10.0);
                    evTotalLayout.getRowConstraints().add(row);
                }
            }

            //---- evTotalLbl ----
            evTotalLbl.getStyleClass().add("value");
            evTotalLbl.setText(bundle.getString("evTotalLbl.text") + ":");
            evTotalLayout.add(evTotalLbl, 0, 0);

            //---- evTotalValue ----
            evTotalValue.getStyleClass().add("value");
            evTotalValue.setText(Integer.toString(510));
            evTotalLayout.add(evTotalValue, 1, 0);
        }
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

    private EvEditor getEvEditor(Stat stat) {
        EvEditor rv = null;
        switch (stat) {
            case HP:
                rv = hpEvEditor;
                break;
            case Attack:
                rv = attackEvEditor;
                break;
            case Defense:
                rv = defenseEvEditor;
                break;
            case SpAttack:
                rv = spAttackEvEditor;
                break;
            case SpDefense:
                rv = spDefenseEvEditor;
                break;
            case Speed:
                rv = speedEvEditor;
                break;
        }
        return rv;
    }

    private EvEditor getEvEditor(Observable observable) {
        EvEditor rv = null;
        if (observable instanceof ReadOnlyProperty) {
            Slider bean = (Slider) ((ReadOnlyProperty) observable).getBean();
            rv = (EvEditor) bean.getParent();
        }
        return rv;
    }

    private void onEvEditorValueChanged(Observable observable) {
        int sum = evTotalGroup.getSum();
        evTotalValue.setText(Integer.toString(evTotalGroup.getTotal() - sum));

        EvEditor editor = getEvEditor(observable);
        if (editor != null) {
            Stat stat = editor.getStat();
            evs[stat.ordinal()] = editor.getValue();
            MainView.getInstance().getResultPane().update(stat);
        }
    }

    public int[] getEvs() {
        return evs;
    }

    public int getEv(Stat stat) {
        return evs[stat.ordinal()];
    }

    public void setEvs(int[] evs) {
        this.evs = evs;
        for (Stat stat : Stat.values()) {

        }
    }

    public void setEv(Stat stat, int ev) {
        evs[stat.ordinal()] = ev;
        EvEditor editor = getEvEditor(stat);
        editor.setValue(ev);
    }
}
