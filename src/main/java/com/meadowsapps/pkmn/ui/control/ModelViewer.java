package com.meadowsapps.pkmn.ui.control;

import com.meadowsapps.pkmn.data.DataTable;
import com.meadowsapps.pkmn.util.PkmnUtils;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.InputStream;

/**
 * Created by Dylan on 9/15/16.
 */
public class ModelViewer extends StackPane {

    private ImageView modelView;

    private ImageView backgroundView;

    public ModelViewer() {
        initComponents();
    }

    private void initComponents() {
        getStyleClass().addAll("view");
        setPadding(new Insets(5, 5, 5, 5));

        {
            backgroundView = new ImageView();
            InputStream stream = PkmnUtils.getResourceAsStream("images/pokeball.gif");
            Image backgroundImage = new Image(stream);
            backgroundView.setImage(backgroundImage);
            getChildren().add(backgroundView);
            setPrefSize(backgroundImage.getWidth(), backgroundImage.getHeight());
        }

        {
            modelView = new ImageView();
            modelView.setSmooth(true);
            getChildren().add(modelView);
        }
    }

    public void setModel(String pokemon, String form) {
        String path = DataTable.getModelMap().getModelPath(pokemon, form);
        InputStream stream = PkmnUtils.getResourceAsStream(path);
        Image model = new Image(stream);
        double bgWidth = backgroundView.getImage().getWidth();
        double width = (model.getWidth() > bgWidth) ? bgWidth : 0.0;
        modelView.setPreserveRatio(width != 0.0);
        modelView.setFitWidth(width);
        modelView.setImage(model);
    }

}
