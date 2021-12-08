package day03;

import utils.Pair;
import utils.Solver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Part2Solver implements Solver {

    int len = -1;
    int[] counts;
    int nLines = 0;

    List<String> binNumbers = new ArrayList<>();

//    @Override
//    public void addInputLine(String line) {
//        String binaryNr = line;
//        if (len == -1) {
//            len = binaryNr.length();
//            counts = new int[len];
//        }
//        for (int i = 0; i < len; i++) {
//            if (binaryNr.charAt(i) == '1') {
//                counts[i]++;
//            }
//        }
//        binNumbers.add(binaryNr);
//        nLines++;
//    }

    @Override
    public void addInputLine(String line) {
        String binaryNr = line;
        binNumbers.add(binaryNr);
    }


    @Override
    public String getSolution() {

        var mostLeast = mostAndLeastCommon(binNumbers, 0);

        var mostCommon = mostLeast._1;
        var leastCommon = mostLeast._2;

        var oxyRatingBin = getOxyRating(mostCommon, 1);
        var co2RatingBin = getCO2Rating(leastCommon, 1);

        var oxyRating = Long.parseLong(oxyRatingBin, 2);
        var co2Rating = Long.parseLong(co2RatingBin, 2);
        var res = oxyRating * co2Rating;

        System.out.printf("oxy = %s (%d)\n", oxyRatingBin, oxyRating);
        System.out.printf("co2 = %s (%d)\n", co2RatingBin, co2Rating);


//        gamma = 000010111110 (190)
//        epsilon = 111101000001 (3905)

        return String.valueOf(res);
    }

    String getOxyRating(List<String> binNumbers, int pos) {
        if (binNumbers.size() == 1) {
            return binNumbers.get(0);
        }

        var mostCommon = mostAndLeastCommon(binNumbers, pos)._1;
        return getOxyRating(mostCommon, pos + 1);

    }

    String getCO2Rating(List<String> binNumbers, int pos) {
        if (binNumbers.size() == 1) {
            return binNumbers.get(0);
        }

        var leastCommon = mostAndLeastCommon(binNumbers, pos)._2;
        return getCO2Rating(leastCommon, pos + 1);
    }


    Pair<List<String>, List<String>> mostAndLeastCommon(List<String> binNumbers, int pos) {
        Map<Boolean, List<String>> collect = binNumbers.stream().collect(Collectors.partitioningBy(binNr -> binNr.charAt(pos) == '1'));
        List<String> oneInPos = collect.get(true);
        List<String> zeroInPos = collect.get(false);

        List<String> mostCommon;
        List<String> leastCommon;

        if (oneInPos.size() >= zeroInPos.size()) {
            mostCommon = oneInPos;
            leastCommon = zeroInPos;
        } else {
            mostCommon = zeroInPos;
            leastCommon = oneInPos;
        }
        return new Pair<>(mostCommon, leastCommon);
    }


}
