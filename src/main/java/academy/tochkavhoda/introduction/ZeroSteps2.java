package academy.tochkavhoda.introduction;

public class ZeroSteps2 {

    public int sumSquares(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
        }
        return sum;
    }

    public int sumOdds(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    public double sumInverses(int count) {
        double sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public long factorial(int count) {
        long result = 1;
        for (int i = 1; i <= count; i++) {
            result *= i;
        }
        return result;
    }

    public int prodDigits(int value) {
        int result = 1;
        while (value > 0) {
            result *= value % 10;
            value /= 10;
        }
        return result;
    }

    public int fibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        int prev = 0;
        int current = 1;
        for (int i = 2; i <= number; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    public long sum2Powers(int max) {
        long sum = 0;
        long currentPower = 1; // 2 в степени 0 равно 1
        for (int i = 0; i <= max; i++) {
            sum += currentPower;
            currentPower *= 2;
        }
        return sum;
    }

    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
            if (sum > barrier) {
                break;
            }
        }
        return sum;
    }

    public int sumPairProd(int count1, int count2) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += i * j;
            }
        }
        return sum;
    }

    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int prod = i * j;
                if (prod < barrier) {
                    sum += prod;
                }
            }
        }
        return sum;
    }

    public double sumInversePairProd(int count1, int count2) {
        double sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += 1.0 / (i * j);
            }
        }
        return sum;
    }

    public int sumTripleProd(int count1, int count2, int count3) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    sum += i * j * k;
                }
            }
        }
        return sum;
    }

    public double calculateE() {
        double e = 1.0;
        double currentTerm = 1.0; // Текущий член ряда
        int n = 1;

        while (currentTerm >= 1E-6) {
            currentTerm = currentTerm / n;
            e = e + currentTerm;
            n++;
        }

        return e;
    }

    public double calculatePi() {
        double sum = 0;
        double denominator = 1.0;
        int sign = 1;
        double item;

        // Цикл продолжается, пока модуль очередного члена >= 1E-8
        do {
            item = 1.0 / denominator;
            sum += sign * item;
            denominator += 2;
            sign = -sign; // меняем знак: + - + -
        } while (item >= 1E-8);

        return 4 * sum;
    }

    public double calculateCircleSquare(double length, int count) {
        int hits = 0;
        double radius = length / 2;
        // Центр квадрата и круга
        double centerX = length / 2;
        double centerY = length / 2;

        for (int i = 0; i < count; i++) {
            double x = Math.random() * length;
            double y = Math.random() * length;

            // Проверяем расстояние от точки до центра
            double dx = x - centerX;
            double dy = y - centerY;

            // Если расстояние меньше или равно радиусу, точка внутри круга
            if (dx * dx + dy * dy <= radius * radius) {
                hits++;
            }
        }

        return length * length * hits / count;
    }
}