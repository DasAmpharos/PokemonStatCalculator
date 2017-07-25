package com.meadowsapps.pkmn;

import com.meadowsapps.pkmn.ui.MainView;
import com.meadowsapps.pkmn.util.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by dmeadows on 2/21/2015
 */
public class PokemonStatCalculator extends Application {

    private static final String DEBUG_ARG = "debug";

    @Override
    public void start(final Stage primaryStage) throws Exception {
        long start = System.currentTimeMillis();
        Parent node = MainView.getInstance();
        long stop = System.currentTimeMillis();
        Logger.getLogger().debug("MainView: " + (stop - start));

        Scene scene = new Scene(node);
        URL style = getClass().getClassLoader().getResource("style/default.css");
        scene.getStylesheets().add(style.toExternalForm());
        primaryStage.setScene(scene);

        double width = 1120;
        double height = 775;
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setMinWidth(width);

        primaryStage.setTitle("Pokemon Stat Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // set debugging flag
        boolean debug = false;
        if (args.length > 0) {
            for (String arg : args) {
                if (arg.contains(DEBUG_ARG)) {
                    String[] s = arg.split("=");
                    if (s.length > 1) {
                        Boolean value = Boolean.valueOf(s[1]);
                        if (value != null) {
                            debug = value;
                        }
                    }
                }
            }
        }
        Logger.getLogger().setDebugging(debug);

        launch(args);
    }
}