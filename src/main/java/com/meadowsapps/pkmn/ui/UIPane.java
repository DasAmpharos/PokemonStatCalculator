package com.meadowsapps.pkmn.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * Created by dmeadows on 10/20/2016
 */
public abstract class UIPane extends BorderPane {

    private Label header;

    private GridPane layout;

    public UIPane() {
        header = new Label();
        header.getStyleClass().add("header");
        BorderPane.setAlignment(header, Pos.CENTER);
        setTop(header);

        layout = new GridPane();
        setupColumnConstraints(layout.getColumnConstraints());
        setupRowConstraints(layout.getRowConstraints());
        setCenter(layout);

        initComponents();
    }

    protected abstract void setupColumnConstraints(ObservableList<ColumnConstraints> constraints);

    protected abstract void setupRowConstraints(ObservableList<RowConstraints> constraints);

    protected abstract void initComponents();

    public Label getHeader() {
        return header;
    }

    public String getHeaderText() {
        return header.getText();
    }

    public void setHeaderText(String text) {
        header.setText(text);
    }

    public boolean isShowHeader() {
        return getTop() != null;
    }

    public void setShowHeader(boolean showHeader) {
        if (showHeader) {
            setTop(header);
        } else {
            setTop(null);
        }
    }

    public GridPane getLayout() {
        return layout;
    }

    public double getLayoutHgap() {
        return layout.getHgap();
    }

    public double getLayoutVgap() {
        return layout.getVgap();
    }

    public void setLayoutGap(double hGap, double vGap) {
        layout.setHgap(hGap);
        layout.setVgap(vGap);
    }

    public boolean isShowBorder() {
        return layout.getStyleClass().contains("view");
    }

    public void setShowBorder(boolean showBorder) {
        if (showBorder) {
            if (!layout.getStyleClass().contains("view")) {
                layout.getStyleClass().add("view");
            }
        } else {
            if (layout.getStyleClass().contains("view")) {
                layout.getStyleClass().remove("view");
            }
        }
    }

    public Insets getLayoutPadding() {
        return layout.getPadding();
    }

    public void setLayoutPadding(Insets insets) {
        layout.setPadding(insets);
    }

    public void add(Node node, int column, int row) {
        layout.add(node, column, row);
    }

    public void add(Node node, int column, int row, int colspan, int rowspan) {
        layout.add(node, column, row, colspan, rowspan);
    }

    public Insets getMargins(Node child) {
        return layout.getMargin(child);
    }

    public void setMargins(Node child, Insets margins) {
        layout.setMargin(child, margins);
    }

}
