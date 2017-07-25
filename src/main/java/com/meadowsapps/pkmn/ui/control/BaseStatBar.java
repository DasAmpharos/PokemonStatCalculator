package com.meadowsapps.pkmn.ui.control;

import com.meadowsapps.pkmn.data.Stat;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Created by Dylan on 9/16/16.
 */
public class BaseStatBar extends GridPane {

    private int value;

    private HBox barPane;

    private Label label;

    private ResizeableRectangle bar;

    public BaseStatBar(Stat stat) {
        initComponents();
        bar.setFill(stat.getFill());
    }

    private void initComponents() {
        setGridLinesVisible(false);
        setHgap(10);
        setVgap(10);

        Text text = new Text("000");
        Bounds bounds = text.getLayoutBounds();

        // Label
        {
            ColumnConstraints constraints = new ColumnConstraints();
            constraints.setMinWidth(10);
            constraints.setMaxWidth(bounds.getWidth());
            constraints.setPrefWidth(bounds.getWidth());
            getColumnConstraints().add(constraints);

            label = new Label();
            GridPane.setConstraints(label, 0, 0, 1, 1,
                    HPos.RIGHT, VPos.CENTER, Priority.NEVER, Priority.ALWAYS);
            getChildren().add(label);
        }

        // Bar
        {
            ColumnConstraints constraints = new ColumnConstraints();
            constraints.setMinWidth(10);
            constraints.setPrefWidth(100);
            getColumnConstraints().add(constraints);

            bar = new ResizeableRectangle();
            barPane = new HBox();
            barPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            barPane.widthProperty().addListener((observable, oldValue, newValue) -> {
                updateBarSize();
            });
            barPane.heightProperty().addListener((observable, oldValue, newValue) -> {
                updateBarSize();
            });
            BorderPane.setAlignment(bar, Pos.CENTER_LEFT);
            barPane.getChildren().add(bar);
            GridPane.setConstraints(barPane, 1, 0, 1, 1,
                    HPos.LEFT, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
            getChildren().add(barPane);
        }
    }

    private void updateBarSize() {
        bar.setWidth((barPane.getWidth() / 255) * value);
        bar.setHeight(barPane.getHeight());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        label.setText(Integer.toString(value));
        updateBarSize();
    }

    /**
     * http://stackoverflow.com/questions/28908800/binding-rectangle-widthproperty-to-its-parent-width-does-not-work
     */
    class ResizeableRectangle extends Rectangle {

        @Override
        public boolean isResizable() {
            return true;
        }

        @Override
        public double minWidth(double height) {
            return 0.0;
        }
    }
}
