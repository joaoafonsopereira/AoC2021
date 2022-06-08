package day04;

import org.junit.jupiter.api.Test;
import utils.Solver;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Part1SolverTest {

    @Test
    void Test() throws IOException {
        Solver solver = new Part1Solver();
//        InputStream input = Inputs.getInputForProblem(day);
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/test/day04/test1.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = in.readLine()) != null) {
            solver.addInputLine(line);
        }
        System.out.println(solver.getSolution());
    }

    @Test
    void TestPart2() throws IOException {
        Solver solver = new Part2Solver();
//        InputStream input = Inputs.getInputForProblem(day);
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/test/day04/test1.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = in.readLine()) != null) {
            solver.addInputLine(line);
        }
        System.out.println(solver.getSolution());
    }

}