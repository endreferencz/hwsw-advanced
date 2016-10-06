package com.epam;

public class Shop {

    private DataStore dataStore;

    public Shop(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public DataStore getDataStore() {
        return dataStore;
    }

}
