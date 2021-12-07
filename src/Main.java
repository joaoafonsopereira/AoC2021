import utils.Inputs;
import utils.Solver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {

    static final int DAY = 1;
    static final int PART = 1;

    static String getPkgName(int day) {
        String res = String.valueOf(day);
        if (day < 10) {
            res = '0' + res;
        }
        return "day" + res;
    }

    static String getSolverName(int part) {
        return String.format("Part%dSolver", part);
    }

    static Solver getSolver(int day, int part) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String pkg = getPkgName(day);
        String solverName = getSolverName(part);
        String qualifiedName = String.format("%s.%s", pkg, solverName);
        Class<?> solver = Class.forName(qualifiedName);
        return (Solver) solver.getDeclaredConstructor().newInstance();
    }

    public static void main(String[] args) throws Exception {
        // get problem nr/ part nr
        int day = DAY;
        int part = PART;
        Solver solver = getSolver(day, part);
        InputStream input = Inputs.getInputForProblem(day);
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = in.readLine()) != null) {
            solver.addInputLine(line);
        }
        System.out.println(solver.getSolution());
    }

}
