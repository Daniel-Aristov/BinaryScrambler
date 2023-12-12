package ru.aristov.binaryscrambler;

public class Scrambler {
    public static int[] scrambler_1(String input) {
        String[] inputArrayStr = input.split("");
        int[] inputArrayInt = new int[inputArrayStr.length];
        int[] outputArrayInt = new int[inputArrayInt.length];

        for (int i = 0; i < inputArrayStr.length; i++) {
            inputArrayInt[i] = Integer.parseInt(inputArrayStr[i]);
        }

        for (int i = 0; i < input.length(); i++) {
            if (i < 3) {
                outputArrayInt[i] = inputArrayInt[i];
            } else if (i >= 3 && i < 5) {
                outputArrayInt[i] = (inputArrayInt[i] + outputArrayInt[i-3]) % 2;
            } else {
                outputArrayInt[i] = (inputArrayInt[i] + outputArrayInt[i-3] + outputArrayInt[i-5]) % 2;
            }
        }
        return outputArrayInt;
    }

    public static int[] descrambler_1(int[] outputArrayInt) {
        int[] outputDescramblerInt = new int[outputArrayInt.length];
        for (int i = 0; i < outputArrayInt.length; i++) {
            if (i < 3) {
                outputDescramblerInt[i] += outputArrayInt[i];
            } else if (i >= 3 && i < 5) {
                outputDescramblerInt[i] += (outputArrayInt[i] + outputArrayInt[i - 3]) % 2;
            } else {
                outputDescramblerInt[i] += (outputArrayInt[i] + outputArrayInt[i - 3] + outputArrayInt[i - 5]) % 2;
            }
        }
        return outputDescramblerInt;
    }

    public static int[] scrambler_2(String input) {
        String[] inputArrayStr = input.split("");
        int[] inputArrayInt = new int[inputArrayStr.length];
        int[] outputArrayInt = new int[inputArrayInt.length];
        int[] outputDescramblerInt = new int[inputArrayInt.length];

        for (int i = 0; i < inputArrayStr.length; i++) {
            inputArrayInt[i] = Integer.parseInt(inputArrayStr[i]);
        }

        for (int i = 0; i < input.length(); i++) {
            if (i < 2) {
                outputArrayInt[i] = inputArrayInt[i];
            } else if (i == 2) {
                outputArrayInt[i] = (inputArrayInt[i] + outputArrayInt[i-2]) % 2;
            } else {
                outputArrayInt[i] = (inputArrayInt[i] + outputArrayInt[i-2] + outputArrayInt[i-3]) % 2;
            }
        }
        return outputArrayInt;
    }

    public static int[] descrambler_2(int[] outputArrayInt) {
        int[] outputDescramblerInt = new int[outputArrayInt.length];
        for (int i = 0; i < outputArrayInt.length; i++) {
            if (i < 2) {
                outputDescramblerInt[i] += outputArrayInt[i];
            } else if (i == 2) {
                outputDescramblerInt[i] += (outputArrayInt[i] + outputArrayInt[i-2]) % 2;
            } else {
                outputDescramblerInt[i] += (outputArrayInt[i] + outputArrayInt[i-2] + outputArrayInt[i-3]) % 2;
            }
        }
        return outputDescramblerInt;
    }

    public static int[] UnitZeroStatistic(int[] outputArrayInt) {
        int maxCountZero = 1;
        int maxCountOne = 1;
        int[] UnitZeroStatistic = new int[]{1, 1};

        for (int i = 1; i < outputArrayInt.length; i++) {
            if ((outputArrayInt[i] == outputArrayInt[i-1]) && (outputArrayInt[i] == 1)) {
                maxCountOne++;
            } else {
                if (maxCountOne > UnitZeroStatistic[1]) UnitZeroStatistic[1] = maxCountOne;
                maxCountOne = 1;
            }

            if (outputArrayInt[i] == outputArrayInt[i-1] && outputArrayInt[i] == 0) {
                maxCountZero++;
            } else if (outputArrayInt[i] == 0){
                if (maxCountZero > UnitZeroStatistic[0]) UnitZeroStatistic[0] = maxCountZero;
                maxCountZero = 1;
            }
        }
        return UnitZeroStatistic;
    }
}
