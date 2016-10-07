package com.epam;

public class Stock {

    private DataStore dataStore;

    public Stock(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public DataStore getDataStore() {
        return dataStore;
    }

}
