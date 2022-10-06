import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SolveService extends Remote {
    String solve(int a, int b, int c) throws RemoteException;
}
