package db2;

import java.sql.SQLException;

public abstract class FactoryInformation {

    public abstract String getClientInfo(String id_client) throws SQLException;

    public abstract String getProviderInfo(String id_provider) throws SQLException;

    public abstract String getDelite(String table, String id) throws SQLException;

    public abstract String getClients() throws SQLException;

    public abstract String getProvider() throws SQLException;

    public abstract String getProvideriD() throws SQLException;

    public abstract String getincoming() throws SQLException;
}
