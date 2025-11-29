package academy.tochkavhoda.introduction;

public class ZeroSteps3 {

    public int sum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public int mul(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            result *= array[i];
        }
        return result;
    }

    public int min(int[] array) {
        if (array.length == 0) {
            return Integer.MAX_VALUE;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public int max(int[] array) {
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public double average(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public void replaceBySquare(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                break;
            }
            array[i] = array[i] * array[i];
        }
    }

    public int mulNonZero(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                result *= array[i];
            }
        }
        return result;
    }

    public boolean allPositive(int[] array) {
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean allEqual(int[] array) {
        if (array.length == 0) {
            return true;
        }
        int first = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != first) {
                return false;
            }
        }
        return true;
    }

    public int greaterThanNeighbours(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public boolean neighboursAverage(double[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            double avg = (array[i - 1] + array[i + 1]) / 2.0;
            if (array[i] == avg) {
                return true;
            }
        }
        return false;
    }

    public int sumBetween2Zeros(int[] array) {
        int firstZero = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                firstZero = i;
                break;
            }
        }
        int secondZero = -1;
        for (int i = firstZero + 1; i < array.length; i++) {
            if (array[i] == 0) {
                secondZero = i;
                break;
            }
        }
        int sum = 0;
        for (int i = firstZero + 1; i < secondZero; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    public int sameAtPosition(int[] array1, int[] array2) {
        int count = 0;
        int minLength = array1.length;
        if (array2.length < minLength) {
            minLength = array2.length;
        }

        for (int i = 0; i < minLength; i++) {
            if (array1[i] == array2[i]) {
                count++;
            }
        }
        return count;
    }

    public boolean bothZeroAtPosition(int[] array1, int[] array2) {
        int minLength = array1.length;
        if (array2.length < minLength) {
            minLength = array2.length;
        }

        for (int i = 0; i < minLength; i++) {
            if (array1[i] == 0 && array2[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public void accumulatedSum(int[] array) {
        int runningSum = 0;

        for (int i = 0; i < array.length; i++) {
            runningSum = runningSum + array[i];
            array[i] = runningSum;
        }
    }

    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }

        for (; i < array1.length; i++, k++) {
            result[k] = array1[i];
        }

        for (; j < array2.length; j++, k++) {
            result[k] = array2[j];
        }

        return result;
    }

    public int insideCircle(int[] x, int[] y, int radius) {
        int pointsInside = 0;
        int radiusSquared = radius * radius;

        for (int i = 0; i < x.length; i++) {
            int xSquared = x[i] * x[i];
            int ySquared = y[i] * y[i];
            int distanceSquared = xSquared + ySquared;

            if (distanceSquared <= radiusSquared) {
                pointsInside++;
            }
        }

        return pointsInside;
    }

    public double scalarProduct(double[] array1, double[] array2) {
        double result = 0;

        for (int i = 0; i < array1.length; i++) {
            double product = array1[i] * array2[i];
            result = result + product;
        }

        return result;
    }
}