package day06;

import day06.Part1Solver;
import org.junit.jupiter.api.Test;
import utils.Solver;

import java.io.*;

public class Part1SolverTest {

    @Test
    void Test() throws IOException {
        Solver solver = new Part1Solver();
//        InputStream input = Inputs.getInputForProblem(day);
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/test/day06/test06.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(input));

        String line ;
        while ((line = in.readLine()) != null) {
            solver.addInputLine(line);
        }
        System.out.println(solver.getSolution());
    }

}
