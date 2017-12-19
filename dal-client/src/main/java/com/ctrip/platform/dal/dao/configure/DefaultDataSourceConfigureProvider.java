package com.ctrip.platform.dal.dao.configure;

import java.util.Map;
import java.util.Set;

public class DefaultDataSourceConfigureProvider implements DataSourceConfigureProvider {

    @Override
    public void initialize(Map<String, String> settings) throws Exception {
        DataSourceConfigureParser.getInstance();
    }

    @Override
    public DataSourceConfigure getDataSourceConfigure(String dbName) {
        DataSourceConfigure dataSourceConfigure =
                DataSourceConfigureLocator.getInstance().getDataSourceConfigureCollection(dbName).getConfigure();
        if (dataSourceConfigure == null)
            return new DataSourceConfigure(dbName);

        return new DataSourceConfigure(dbName, dataSourceConfigure.getMap());
    }

    @Override
    public void setup(Set<String> dbNames) {}

    @Override
    public void register(String dbName, DataSourceConfigureChangeListener listener) {}

}
