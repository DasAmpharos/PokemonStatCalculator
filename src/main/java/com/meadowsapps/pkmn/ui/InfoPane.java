package com.meadowsapps.pkmn.ui;

import com.meadowsapps.pkmn.data.DataTable;
import com.meadowsapps.pkmn.data.Nature;
import com.meadowsapps.pkmn.ui.control.ModelViewer;
import com.meadowsapps.pkmn.util.PkmnUtils;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ResourceBundle;

/**
 * Created by dmeadows on 10/19/2016
 */
public class InfoPane extends UIPane {

    private ModelViewer modelViewer;
    private Label pokemonLbl;
    private ComboBox pokemonField;
    private Label natureLbl;
    private ComboBox natureField;
    private Label levelLbl;
    private Spinner levelField;
    private Label formLbl;
    private ComboBox formField;

    @Override
    protected void initComponents() {
        ResourceBundle bundle = PkmnUtils.getResources(getClass());

        modelViewer = new ModelViewer();
        pokemonLbl = new Label();
        pokemonField = new ComboBox();
        natureLbl = new Label();
        natureField = new ComboBox();
        levelLbl = new Label();
        levelField = new Spinner();
        formLbl = new Label();
        formField = new ComboBox();

        //======== this ========
        setHeaderText(bundle.getString("header.text"));
        setShowBorder(true);
        setLayoutPadding(new Insets(10.0));
        setLayoutGap(10.0, 10.0);

        //---- modelViewer ----
        setMargins(modelViewer, new Insets(10, 10, 10, 10));
        add(modelViewer, 0, 0, 2, 4);

        //---- pokemonLbl ----
        pokemonLbl.setText(bundle.getString("pokemonLbl.text") + ":");
        add(pokemonLbl, 2, 0);

        //---- pokemonField ----
        pokemonField.setMaxWidth(Double.MAX_VALUE);
        pokemonField.setPrefWidth(150.0);
        String[] pokemon = DataTable.getPokemonTable().getPokemon();
        pokemonField.getItems().addAll(pokemon);
        pokemonField.valueProperty().addListener((observable, oldValue, newValue) -> {
            onPokemonChanged();
        });
        add(pokemonField, 3, 0);

        //---- natureLbl ----
        natureLbl.setText(bundle.getString("natureLbl.text") + ":");
        add(natureLbl, 2, 1);

        //---- natureField ----
        natureField.setMaxWidth(Double.MAX_VALUE);
        natureField.setPrefWidth(150.0);
        String[] natures = DataTable.getNatureTable().getNatures();
        natureField.getItems().addAll(natures);
        natureField.getSelectionModel().selectFirst();
        natureField.valueProperty().addListener((observable, newValue, oldValue) -> {
            onNatureChanged();
        });
        add(natureField, 3, 1);

        //---- levelLbl ----
        levelLbl.setText(bundle.getString("levelLbl.text") + ":");
        add(levelLbl, 2, 2);

        //---- levelEditor ----
        levelField.setEditable(true);
        levelField.setMaxWidth(Double.MAX_VALUE);
        levelField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 50));
        levelField.valueProperty().addListener((observable, oldValue, newValue) -> {
            onLevelChanged();
        });
        add(levelField, 3, 2);

        //---- formLbl ----
        formLbl.setText(bundle.getString("formLbl.text") + ":");
        add(formLbl, 2, 3);

        //---- formField ----
        formField.setMaxWidth(Double.MAX_VALUE);
        formField.setPrefWidth(150.0);
        formField.getItems().addAll(new String[0]);
        formField.setDisable(true);
        formField.valueProperty().addListener((observable, oldValue, newValue) -> {
            onFormChanged();
        });
        add(formField, 3, 3);
    }

    @Override
    protected void setupColumnConstraints(ObservableList<ColumnConstraints> constraints) {
        // Column 0
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.CENTER);
            column.setHgrow(Priority.NEVER);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
        // Column 1
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.CENTER);
            column.setHgrow(Priority.NEVER);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
        // Column 2
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.RIGHT);
            column.setHgrow(Priority.NEVER);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            constraints.add(column);
        }
        // Column 3
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.SOMETIMES);
            column.setMinWidth(10.0);
            column.setPrefWidth(200.0);
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
    }

    private void onPokemonChanged() {
        // update forms
        String pokemon = (String) pokemonField.getSelectionModel().getSelectedItem();
        String[] forms = DataTable.getFormTable().getForms(pokemon);
        formField.getItems().setAll(forms);
        if (forms.length > 0) {
            formField.getSelectionModel().select(0);
        }
        formField.setDisable(forms.length == 0);

        updateModel();
        updateBaseStats();
        MainView.getInstance().getResultPane().update();
    }

    private void onNatureChanged() {
        MainView.getInstance().getResultPane().update();
    }

    private void onLevelChanged() {
        MainView.getInstance().getResultPane().update();
    }

    private void onFormChanged() {
        updateModel();
        updateBaseStats();
        MainView.getInstance().getResultPane().update();
    }

    private void updateModel() {
        String pokemon = (String) pokemonField.getSelectionModel().getSelectedItem();
        String form = (String) formField.getSelectionModel().getSelectedItem();
        modelViewer.setModel(pokemon, form);
    }

    private void updateBaseStats() {
        Integer[] baseStats = DataTable.getBaseStatTable().getBaseStats(getPokemon(), getForm());
        MainView.getInstance().getBaseStatPane().setBaseStats(baseStats);
    }

    public String getPokemon() {
        return (String) pokemonField.getSelectionModel().getSelectedItem();
    }

    public void setPokemon(String pokemon) {
        pokemonField.getSelectionModel().select(pokemon);
    }

    public Nature getNature() {
        String nature = (String) natureField.getSelectionModel().getSelectedItem();
        return Nature.valueOf(nature);
    }

    public void setNature(Nature nature) {
        natureField.getSelectionModel().select(nature.toString());
    }

    public int getLevel() {
        return (Integer) levelField.getValueFactory().getValue();
    }

    public void setLevel(int level) {
        levelField.getValueFactory().setValue(level);
    }

    public String getForm() {
        return (String) formField.getSelectionModel().getSelectedItem();
    }

    public void setForm(String form) {
        formField.getSelectionModel().select(form);
    }

}
