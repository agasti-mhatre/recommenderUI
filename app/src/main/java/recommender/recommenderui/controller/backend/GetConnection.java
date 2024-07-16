package recommender.recommenderui.controller.backend;

public class GetConnection {

    private final StringBuilder backendConn;
    public GetConnection() {

        backendConn = new StringBuilder();
        backendConn.append("https://01d0d2d5-fc57-4226-89c5-95ffc3903931.mock.pstmn.io");
    }

    public String createNewAccount() {

        return getEndpoint("/newAccount");
    }

    private String getEndpoint(String endpoint) {

        backendConn.append(endpoint);

        String connString = backendConn.toString();

        int length = backendConn.length();
        backendConn.delete(length - endpoint.length(), length);

        return connString;
    }

}
