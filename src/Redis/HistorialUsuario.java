package Redis;

import redis.clients.jedis.Jedis;
import java.util.List;

public class HistorialUsuario {

    private Jedis jedis;

    public HistorialUsuario(String host, int port, String password) {
        jedis = new Jedis(host, port);
        jedis.auth(password);
    }

    public void registrarActividad(String correoUsuario, String mensaje) {
        String clave = "actividad:" + correoUsuario;
        jedis.lpush(clave, mensaje);
        jedis.ltrim(clave, 0, 9);
    }

    public List<String> obtenerHistorial(String correoUsuario) {
        return jedis.lrange("actividad:" + correoUsuario, 0, 9);
    }

    public void cerrarConexion() {
        jedis.close();
    }
}
