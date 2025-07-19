package MongoFormulario;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Conexion {

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDatabase conectar() {
        try {
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("testdb");
            System.out.println("Conexión exitosa a MongoDB");
            return database;
        } catch (Exception e) {
            System.out.println("Error al conectar con MongoDB:");
            e.printStackTrace();
            return null;
        }
    }
}
