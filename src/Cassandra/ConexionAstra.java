package Cassandra;

import com.datastax.astra.client.DataAPIClient;
import com.datastax.astra.client.Database;
import com.datastax.astra.client.Collection;
import org.bson.Document;

public class ConexionAstra {

    private static final String TOKEN = "AstraCS:DIJmJxIpQHvObrzqOUoIGkQu:93caffad180a1414eed7a93adcbed8a22f43a2e9738cb169b6d976161f4cb536";
    private static final String DB_URL = "https://686614be-4328-4ffd-aff9-158a9ba7f71c-us-east1.apps.astra.datastax.com";

    private static DataAPIClient cliente;
    private static Database baseDatos;

    static {
        try {
            cliente = new DataAPIClient(TOKEN);
            baseDatos = cliente.getDatabase(DB_URL);
            System.out.println("Conexión exitosa a Astra DB (Document API)");
        } catch (Exception e) {
            System.err.println("Error al conectar con Astra DB: " + e.getMessage());
        }
    }

    public static Collection<Document> getColeccion(String nombreColeccion) {
        return baseDatos.getCollection(nombreColeccion, Document.class);
    }
}

