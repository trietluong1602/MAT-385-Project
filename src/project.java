import java.util.Arrays;
import java.util.Scanner;

public class project {
    public static int r;
    static long a[] = new long[10000];
    static long b[] = new long[10000];
    static long c[] = new long[10000];

    public static void generateTable(long[] a, long[] b, long[] c, int r, table t) {
        for(int i = 0; i < r; i++)
        {
            a[i] = 1;
            for(int j = 0; j <= i; j++) {
                b[t.counter] = a[i];
                c[t.counter] = i;
                t.counter++;
                a[i] = a[i] * (i - j) / (j + 1);
            }
        }
    }

    public static void printTable(long[] b, long[] c, int r, table t) {
        for (int i = 0; i < r; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < t.counter; i++) {
            System.out.print(b[i]);
            if (c[i] != c[i + 1]) {
                System.out.println();
                r--;
                for (int j = 0; j < r; j++) {
                    System.out.print(" ");
                }
            }
            else {
                System.out.print(" ");
            }
        }
    }

    public static void bioexp (long[] b, int n, table t) {
        int count = 0;
        System.out.print("(x + y)^" + n + " = ");
        for (int i = t.counter - n - 1; i < t.counter; i++) {
            if (n == 0) {
                System.out.println("1");
                break;
            }
            if (n == 1) {
                System.out.println("x + y");
                break;
            }
            if (b[i] == 1) {
                if (count == 0) {
                    System.out.print("x^" + n + " + ");
                }
                else {
                    System.out.print("y^" + n);
                }
            }
            else if (count == 1) {
                if (n - 1 > 1) {
                    System.out.print(b[i] + "x^" + (n-1) + "y + ");
                }
                else {
                    System.out.print(b[i] + "xy + ");
                }
            }
            else if (count == n - 1) {
                if (n - 1 > 1) {
                    System.out.print(b[i] + "xy^" + (n-1) + " + ");
                }
                else {
                    System.out.print(b[i] + "xy + ");
                }
            }
            else {
                System.out.print(b[i] + "x^" + (n - count) + "y^" + count + " + ");
            }
            count++;

        }
        System.out.println();
    }

    public static void fibo(long[] b, int n, table t) {
        int count = 0, counter = 0;
        int temp = 1;
        int begin = 0, end = 0;
        int sum = 0;
        int check1 = 1, check2 = 0;
        while (count < n) {
            int i = 0;
            sum = 0;
            end = begin;
            int j = check2;
            while (i < temp) {
                sum += b[end];
                end += j;
                j++;
                i++;
            }
            counter++;
            if (counter > 1) {
                counter = 0;
                temp++;
                begin++;
            }
            else {
                begin += check1;
                check1++;
                check2++;
            }
            count++;
            System.out.print(sum + " ");
        }
        System.out.println();
    }

    public static void powerof2(long[] b, int n, table t) {
        long sum = 0;
        System.out.print("2^" + n + " = ");
        for (int i = t.counter - n - 1; i < t.counter; i++) {
            System.out.print(b[i]);
            sum += b[i];
            if (i == t.counter - 1) {
                System.out.print(" = ");
            }
            else {
                System.out.print(" + ");
            }
        }
        System.out.println(sum);
    }

    public static void probability(long[] b, int n, table t) {
        System.out.println("If a coin tossed for " + n + " times, the possibilities of combinations are:");
        int count = 0;
        for (int i = t.counter - n - 1; i < t.counter; i++) {
            System.out.print("\t" + b[i]);
            if (b[i] == 1) {
                System.out.print(" combination ");
            }
            else {
                System.out.print(" combinations ");
            }
            System.out.print("between " + (n - count));
            if (n - count > 1) {
                System.out.print(" heads ");
            }
            else {
                System.out.print(" head ");
            }
            System.out.print("and " + count);
            if (count > 1) {
                System.out.print(" tails ");
            }
            else {
                System.out.print(" tail ");
            }
            count++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("WELCOME TO PASCAL TRIANGLE APPLICATION");
        table t = new table();
        while (t.check) {
            Arrays.fill(a, 0);
            Arrays.fill(b, 0);
            Arrays.fill(c, 0);
            t.counter = 0;
            System.out.println("Here are some applications that I can use Pascal Trangle for:");
            System.out.println("1. Print the first nth rows of Pascal Triangle");
            System.out.println("2. Binomial Expansion ((x + y)^n)");
            System.out.println("3. Print the first nth Fibonacci numbers");
            System.out.println("4. Calculate 2^n");
            System.out.println("5. Calculate the probability of any combination of head and tail after n tosses");
            System.out.println("6. Calculate combination C(n,k)");
            System.out.print("Choose any number you want or -1 to quit: ");
            int userNum = input.nextInt();
            String userIn;
            if (userNum == -1) {
                t.check = false;
            }
            else {
                if (userNum == 1) {
                    System.out.print("Enter the number of rows: ");
                    r = input.nextInt();
                    generateTable(a, b, c, r, t);
                    printTable(b, c, r, t);
                }
                else if (userNum == 2) {
                    System.out.print("Enter n: ");
                    int n = input.nextInt();
                    generateTable(a, b, c, n + 1, t);
                    bioexp(b, n, t);
                }
                else if (userNum == 3) {
                    System.out.print("Enter n: ");
                    int n = input.nextInt();
                    generateTable(a, b, c, n + 1, t);
                    fibo(b, n, t);
                }
                else if (userNum == 4) {
                    System.out.print("Enter n: ");
                    int n = input.nextInt();
                    generateTable(a, b, c, n + 1, t);
                    powerof2(b, n, t);
                }
                else if (userNum == 5) {
                    System.out.print("Enter n: ");
                    int n = input.nextInt();
                    generateTable(a, b, c, n + 1, t);
                    probability(b, n, t);
                }
                else if (userNum == 6) {
                    System.out.print("Enter n: ");
                    int n = input.nextInt();
                    System.out.print("Enter k: ");
                    int k = input.nextInt();
                    generateTable(a, b, c, n + 1, t);
                    System.out.println("C(" + n + ", " + k + ") = " + b[t.counter - (n - k) - 1]);
                }
                System.out.print("Do you want to continue to use other option (Y/N)? ");
                userIn = input.next().toLowerCase();
                if (userIn.equals("n")) {
                    t.check = false;
                }
                else {
                    System.out.println();
                }
            }
        }
    }
}

class table {
    public static int counter = 0;
    public static boolean check = true;
}