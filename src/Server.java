import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        try {
            SolveService service = new SolveServiceImpl();
            Registry registry = LocateRegistry.createRegistry(8080);
            Remote stub = UnicastRemoteObject.exportObject(service, 0);
            registry.bind("server.solveService", stub);
            System.out.println("Server started!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
