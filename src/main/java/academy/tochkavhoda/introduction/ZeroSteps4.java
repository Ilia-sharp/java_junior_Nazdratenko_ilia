package academy.tochkavhoda.introduction;

public class ZeroSteps4 {

    //  делаем экземпляр доступа к методам ZeroSteps3

    private ZeroSteps3 zs3 = new ZeroSteps3();

    public int min(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int rowMin = zs3.min(matrix[i]); //вызов метода ZS3 для того чтобы найти мин в каждой строке
            if (rowMin < min) {
                min = rowMin;
            }
        }
        return min;
    }

    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int rowMax = zs3.max(matrix[i]);//вызов метода ZS3 для того чтобы найти МАX в каждой строке
            if (rowMax > max) {
                max = rowMax;
            }
        }
        return max;
    }

    public boolean find(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            if (zs3.find(matrix[i], value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!zs3.isSortedDescendant(matrix[i])) {
                return false;
            }
        }
        return true;
    }

    public int hasNoZeroRows(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (!zs3.find(matrix[i], 0)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasFullZeroRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0 && zs3.allEqual(matrix[i]) && matrix[i][0] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isSymmetric(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int mainDiagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (i < matrix[i].length && matrix[i][i] > max) {
                max = matrix[i][i];
            }
        }
        return max;
    }

    public int mainDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i < matrix[i].length && matrix[i][i] > 0) {
                sum += matrix[i][i];
            }
        }
        return sum;
    }

    public int secondaryDiagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (j < matrix[i].length && matrix[i][j] > max) {
                max = matrix[i][j];
            }
        }
        return max;
    }

    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (j < matrix[i].length && matrix[i][j] > 0) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][];
        for (int i = 0; i < matrix1.length; i++) {
            result[i] = new int[matrix1[i].length];
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void interchange(int[][] matrix) {
        for (int i = 0; i < matrix.length; i += 2) {
            int[] temp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = temp;
        }
    }

    public int[] toLinearByRow(int[][] matrix) {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            total += matrix[i].length;
        }
        int[] result = new int[total];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[k++] = matrix[i][j];
            }
        }
        return result;
    }

    public int[] toLinearByColumn(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[n * n];
        int index = 0;

        for (int column = 0; column < n; column++) {
            for (int row = 0; row < n; row++) {
                result[index] = matrix[row][column];
                index++;
            }
        }

        return result;
    }

    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        int n = matrix.length;
        int totalElements = n * (n + 1) / 2;
        int[] result = new int[totalElements];
        int position = 0;

        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                result[position] = matrix[row][col];
                position++;
            }
        }

        return result;
    }

    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        int totalSum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == barrier) {
                    break;
                }
                totalSum = totalSum + matrix[row][col];
            }
        }

        return totalSum;
    }

    public int sumUntilNotFound(int[][] matrix, int barrier) {
        int totalSum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int element = matrix[row][col];

                if (element == barrier) {
                    return totalSum;
                }

                totalSum = totalSum + element;
            }
        }

        return totalSum;
    }
}