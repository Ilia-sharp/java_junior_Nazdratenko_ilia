package academy.tochkavhoda.introduction;

public class ZeroSteps1 {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    // Приводим к double, чтобы результат деления не отбрасывал дробную часть
    public double calculateTriangleSquare(int side1, int side2) {
        return (side1 * side2) / 2.0;
    }

    // По Т Пифагора
    public double calculateTrianglePerimeter(int side1, int side2) {
        double hypotenuse = Math.sqrt(side1 * side1 + side2 * side2);
        return side1 + side2 + hypotenuse;
    }

    public int reverseNumber(int number) {
        int result = 0;
        while (number != 0) {
            int digit = number % 10;
            result = result * 10 + digit;
            number = number / 10;
        }
        return result;
    }

    public long calculate15Degree(int number) {
        long n; // Используем long, чтобы избежать переполнения при умножении
        n = number;
        long n2 = n * n;
        long n4 = n2 * n2;
        long n5 = n4 * n;
        long n10 = n5 * n5;

        return n10 * n5;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        // Проверяем, попадает ли X в диапазон ширины и Y в диапазон высоты
        boolean inX = (x >= xLeft) && (x <= xRight);
        boolean inY = (y >= yTop) && (y <= yBottom);
        return inX && inY;
    }

    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }

    // Треугольник существует если сумма любых 2-х сторон больше 3
    public boolean isTriangleExist(int side1, int side2, int side3) {
        return (side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side2 + side3 > side1);
    }

    public int getDigitsProduction(int number) {
        int result = 1;
        number = Math.abs(number);
        if (number == 0) return 0;

        while (number > 0) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    // Диаметр круга должен быть строго меньше стороны квадрата (чтобы не касался)
    public boolean isCircleInsideSquare(int radius, int side) {
        double diameter = radius * 2;
        return diameter < side;
    }

    public char getCharByCode(short code) {
        return (char) code;
    }

    public short getCodeByChar(char character) {
        return (short) character;
    }

    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char) (ch + offset);
    }

    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return ch1 >= ch2;
    }

    // Среднее арифметическое кодов символов
    public char getAverageChar(char ch1, char ch2) {
        int sum = ch1 + ch2;
        return (char) (sum / 2);
    }
}