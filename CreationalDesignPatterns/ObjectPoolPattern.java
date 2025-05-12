import java.util.ArrayList;
import java.util.List;

class Connection {
    private String id;

    public Connection(String id) {
        this.id = id;
    }

    public void connect() {
        System.out.println("Connection " + id + " is in use.");
    }
}

class ConnectionPool {
    private List<Connection> available = new ArrayList<>();
    private List<Connection> inUse = new ArrayList<>();

    public ConnectionPool(int size) {
        for (int i = 1; i <= size; i++) {
            available.add(new Connection("Conn" + i));
        }
    }

    public Connection acquire() {
        if (available.isEmpty()) {
            System.out.println("No available connections.");
            return null;
        }
        Connection connection = available.remove(0);
        inUse.add(connection);
        return connection;
    }

    public void release(Connection connection) {
        inUse.remove(connection);
        available.add(connection);
    }
}

public class ObjectPoolDemo {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(2);

        Connection c1 = pool.acquire();
        c1.connect();

        Connection c2 = pool.acquire();
        c2.connect();

        pool.release(c1);

        Connection c3 = pool.acquire();
        c3.connect();
    }
}
