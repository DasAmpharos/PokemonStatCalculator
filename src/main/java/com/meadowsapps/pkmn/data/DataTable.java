package com.meadowsapps.pkmn.data;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.meadowsapps.pkmn.util.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Dylan on 9/14/16.
 */
public abstract class DataTable {

    private static Gson gson = new Gson();

    // <editor-fold desc="Table Instances">

    private static PokemonTable pokemonTable = new PokemonTable();

    private static FormTable formTable = new FormTable();

    private static BaseStatTable baseStatTable = new BaseStatTable();

    private static NatureTable natureTable = new NatureTable();

    private static ModelMap modelMap = new ModelMap();

    // </editor-fold>

    protected DataTable(String path) {
        try {
            long start = System.currentTimeMillis();
            InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder builder = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                if (getClass() != ModelMap.class) {
                    builder.append("\n");
                }
            }
            process(builder.toString());
            long stop = System.currentTimeMillis();
            String message = "Data Table finished loading (" + getClass().getSimpleName() + "); Total time: " + (stop - start);
            Logger.getLogger().debug(message);
        } catch (IOException e) {
            Logger.getLogger().error(e);
            System.exit(-1);
        }
    }

    protected abstract void process(String contents);

    // <editor-fold desc="Table Getters">

    public static PokemonTable getPokemonTable() {
        return pokemonTable;
    }

    public static FormTable getFormTable() {
        return formTable;
    }

    public static BaseStatTable getBaseStatTable() {
        return baseStatTable;
    }

    public static NatureTable getNatureTable() {
        return natureTable;
    }

    public static ModelMap getModelMap() {
        return modelMap;
    }

    // </editor-fold>

    // <editor-fold desc="Data Table Classes">

    public static class PokemonTable extends DataTable {

        private List<String> pokemon;

        private final String[] EMPTY_ARRAY = new String[0];

        private PokemonTable() {
            super("pokemon.json");
        }

        @Override
        protected void process(String contents) {
            pokemon = gson.fromJson(contents, ArrayList.class);
        }

        public String[] getPokemon() {
            return pokemon.toArray(EMPTY_ARRAY);
        }

        public String getPokemon(int dexNumber) {
            return pokemon.get(dexNumber - 1);
        }

        public int getDexNumber(String pokemon) {
            int rv = this.pokemon.indexOf(pokemon);
            if (rv != -1) {
                rv++;
            }
            return rv;
        }
    }

    public static class FormTable extends DataTable {

        private HashMap<Integer, ArrayList<String>> forms;

        private FormTable() {
            super("forms.json");
        }

        @Override
        protected void process(String contents) {
            forms = gson.fromJson(contents, HashMap.class);
        }

        public String[] getForms(String pokemon) {
            String[] forms = new String[0];
            int dexNumber = DataTable.getPokemonTable().getDexNumber(pokemon);
            String key = Integer.toString(dexNumber);
            if (this.forms.containsKey(key)) {
                ArrayList<String> list = this.forms.get(key);
                forms = list.toArray(forms);
            }
            return forms;
        }
    }

    public static class BaseStatTable extends DataTable {

        private HashMap<Integer, LinkedTreeMap<String, ArrayList<Double>>> stats;

        private BaseStatTable() {
            super("stats.json");
        }

        @Override
        protected void process(String contents) {
            stats = gson.fromJson(contents, HashMap.class);
        }

        public Integer[] getBaseStats(String pokemon, String form) {
            Integer[] rv = new Integer[6];
            String key = Integer.toString(DataTable.getPokemonTable().getDexNumber(pokemon));
            if (stats.containsKey(key)) {
                LinkedTreeMap<String, ArrayList<Double>> forms = stats.get(key);
                ArrayList<Double> stats = (forms.containsKey(form)) ? forms.get(form) : forms.get("");
                for (int stat = 0; stat < stats.size(); stat++) {
                    rv[stat] = stats.get(stat).intValue();
                }
            }
            return rv;
        }
    }

    public static class NatureTable extends DataTable {

        private HashMap<String, ArrayList<Double>> natures;

        private NatureTable() {
            super("natures.json");
        }

        @Override
        protected void process(String contents) {
            natures = gson.fromJson(contents, HashMap.class);
        }

        public String[] getNatures() {
            Set<String> natures = this.natures.keySet();
            List<String> naturesList = new ArrayList<String>(natures);
            Collections.sort(naturesList);
            return naturesList.toArray(new String[0]);
        }

        public Double[] getModifiers(Nature nature) {
            Double[] rv = new Double[6];
            ArrayList<Double> list = natures.get(nature.name());
            return list.toArray(rv);
        }

        public Double getModifier(Nature nature, Stat stat) {
            return getModifiers(nature)[stat.ordinal() - 1];
        }
    }

    public static class ModelMap extends DataTable {

        private HashMap<Integer, LinkedTreeMap<String, String>> modelMap;

        private ModelMap() {
            super("models.json");
        }

        @Override
        protected void process(String contents) {
            modelMap = gson.fromJson(contents, HashMap.class);
        }

        public String getModelPath(String pokemon, String form) {
            String result = "images/unknown.png";
            String key = Integer.toString(DataTable.getPokemonTable().getDexNumber(pokemon));
            if (modelMap.containsKey(key)) {
                result = "images/models/";
                LinkedTreeMap<String, String> mappings = modelMap.get(key);
                if (form == null || form.equals("")) {
                    result += mappings.get("") + ".gif";
                } else {
                    if (mappings.containsKey(form)) {
                        result += mappings.get(form) + ".gif";
                    } else {
                        result = "images/unknown.png";
                    }
                }
            }
            return result;
        }
    }

    // </editor-fold>
}
