package day07;

import day07.Part1Solver;
import org.junit.jupiter.api.Test;
import utils.Solver;

import java.io.*;

public class Part1SolverTest {

    @Test
    void Test() throws IOException {
//        Solver solver = new Part1Solver();
        Solver solver = new Part2Solver();
//        InputStream input = Inputs.getInputForProblem(day);
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/test/day07/test07.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(input));

        String line ;
        while ((line = in.readLine()) != null) {
            solver.addInputLine(line);
        }
        System.out.println(solver.getSolution());
    }

}
