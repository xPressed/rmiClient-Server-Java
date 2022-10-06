import java.rmi.RemoteException;

public class SolveServiceImpl implements SolveService{
    @Override
    public String solve(int a, int b, int c) throws RemoteException {
        try {
            double d = b * b - 4 * a * c;
            if (d > 0) {
                double x1 = (-b - Math.sqrt(d)) / (2 * a);
                double x2 = (-b + Math.sqrt(d)) / (2 * a);
                return "x1 = " + x1 + "\nx2 = " + x2;
            } else if (d == 0) {
                return "x = " + (-b / (2 * a));
            } else {
                return "No solutions!";
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
