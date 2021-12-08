package day03;

import utils.Solver;

import utils.Binary;

public class Part1Solver implements Solver {

    int len = -1;
    int[] counts;
    int nLines = 0;

    @Override
    public void addInputLine(String line) {
        String binaryNr = line;
        if (len == -1) {
            len = binaryNr.length();
            counts = new int[len];
        }
        for (int i = 0; i < len; i++) {
            if (binaryNr.charAt(i) == '1') {
                counts[i]++;
            }
        }
        nLines++;
    }

    @Override
    public String getSolution() {
        String gammaStr = getGamma();
        String epsilonStr = Binary.negate(gammaStr);
        long gammaRate = Long.parseLong(gammaStr, 2);
        long epsilonRate = Long.parseLong(epsilonStr, 2);
        long res = gammaRate * epsilonRate;

        System.out.printf("gamma = %s (%d)\n", gammaStr, gammaRate);
        System.out.printf("epsilon = %s (%d)\n", epsilonStr, epsilonRate);

        return String.valueOf(res);
    }

    public String getGamma() {
        StringBuilder gammaStr = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char next = counts[i] >= (nLines / 2) ? '1' : '0';
            gammaStr.append(next);
        }
        return gammaStr.toString();
    }

}
