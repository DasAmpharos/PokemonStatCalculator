package com.meadowsapps.pkmn.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * Created by dmeadows on 10/19/2016
 */
public class MainView extends UIPane {

    private InfoPane infoPane;

    private BaseStatPane baseStatPane;

    private ResultPane resultPane;

    private StatPane statPane;

    private static MainView instance = new MainView();

    private MainView() {
        super();
    }

    @Override
    protected void initComponents() {
        //======== this ========
        getLayout().setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        getLayout().setMinSize(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        getLayout().setPrefSize(860.0, 732.0);
        setShowHeader(false);

        //---- infoPane ----
        infoPane = new InfoPane();
        GridPane.setMargin(infoPane, new Insets(10.0, 0.0, 0.0, 0.0));
        add(infoPane, 0, 0);

        //---- baseStatPane ----
        baseStatPane = new BaseStatPane();
        GridPane.setMargin(baseStatPane, new Insets(10.0, 0.0, 0.0, 0.0));
        add(baseStatPane, 1, 0);

        //---- resultPane ----
        resultPane = new ResultPane();
        GridPane.setMargin(resultPane, new Insets(10.0, 0.0, 0.0, 0.0));
        add(resultPane, 2, 0);

        //---- statPane ----
        statPane = new StatPane();
        add(statPane, 0, 1, 3, 1);
    }

    @Override
    protected void setupColumnConstraints(ObservableList<ColumnConstraints> constraints) {
        // Column 0
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.NEVER);
            constraints.add(column);
        }
        // Column 1
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.ALWAYS);
            constraints.add(column);
        }
        // Column 2
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.NEVER);
            constraints.add(column);
        }
    }

    @Override
    protected void setupRowConstraints(ObservableList<RowConstraints> constraints) {
        // Row 0
        {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.NEVER);
            constraints.add(row);
        }
        // Row 1
        {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(Priority.SOMETIMES);
            constraints.add(row);
        }
    }

    public InfoPane getInfoPane() {
        return infoPane;
    }

    public BaseStatPane getBaseStatPane() {
        return baseStatPane;
    }

    public ResultPane getResultPane() {
        return resultPane;
    }

    public StatPane getStatPane() {
        return statPane;
    }

    public static MainView getInstance() {
        return instance;
    }
}
