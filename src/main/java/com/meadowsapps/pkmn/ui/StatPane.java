package com.meadowsapps.pkmn.ui;

import com.meadowsapps.pkmn.data.Stat;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * Created by dmeadows on 10/19/2016
 */
public class StatPane extends UIPane {

    private EvPane evPane;

    private Separator separator;

    private IvPane ivPane;

    @Override
    protected void initComponents() {
        evPane = new EvPane();
        separator = new Separator();
        ivPane = new IvPane();

        //======== this ========
        setShowBorder(true);
        setShowHeader(false);
        setLayoutPadding(new Insets(10.0, 15.0, 0.0, 15.0));
        setLayoutGap(10.0, 10.0);

        //---- evPane ----
        add(evPane, 0, 0, 3, 1);

        //---- separator ----
        separator.setOrientation(Orientation.VERTICAL);
        separator.setPadding(new Insets(25.0, 0.0, 25.0, 0.0));
        separator.setPrefHeight(200.0);
        add(separator, 3, 0);

        //---- ivPane ----
        add(ivPane, 4, 0);
    }

    @Override
    protected void setupColumnConstraints(ObservableList<ColumnConstraints> constraints) {
        // Column 0
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.RIGHT);
            column.setHgrow(Priority.ALWAYS);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
        // Column 1
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.RIGHT);
            column.setHgrow(Priority.ALWAYS);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
        // Column 2
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.RIGHT);
            column.setHgrow(Priority.ALWAYS);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
        // Column 3
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.CENTER);
            column.setHgrow(Priority.NEVER);
            column.setMinWidth(10.0);
            column.setMaxWidth(100.0);
            column.setPrefWidth(25.0);
            constraints.add(column);
        }
        // Column 4
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
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            constraints.add(row);
        }
    }

    public int[] getEvs() {
        return evPane.getEvs();
    }

    public int getEv(Stat stat) {
        return evPane.getEv(stat);
    }

    public void setEvs(int[] evs) {
        evPane.setEvs(evs);
    }

    public void setEv(Stat stat, int ev) {
        evPane.setEv(stat, ev);
    }

    public int[] getIvs() {
        return ivPane.getIvs();
    }

    public int getIv(Stat stat) {
        return ivPane.getIv(stat);
    }

    public void setIvs(int[] ivs) {
        ivPane.setIvs(ivs);
    }

    public void setIv(Stat stat, int iv) {
        ivPane.setIv(stat, iv);
    }
}
