import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws NotBoundException, RemoteException {
        SolveService service = null;
        try {
            Registry registry = LocateRegistry.getRegistry(8080);
            service = (SolveService) registry.lookup("server.solveService");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(228);
        }

        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 0, c = 0;

        System.out.println("ax^2 + bx + c = 0");
        while (true) {
            try {
                System.out.print("a = ");
                a = Integer.parseInt(scanner.nextLine());

                System.out.print("b = ");
                b = Integer.parseInt(scanner.nextLine());

                System.out.print("c = ");
                c = Integer.parseInt(scanner.nextLine());

                System.out.println(service.solve(a, b, c) + "\n");
            } catch (Exception e) {
                System.err.println("\n" + e);
            }
        }
    }
}
