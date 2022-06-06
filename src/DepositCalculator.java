import java.util.Scanner;

public class DepositCalculator {
    double CalculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }

    double CalculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateProfits() {
        int period;
        int action;
        int amount;
        double outProfits = 0;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = userInput.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = userInput.nextInt();
        if (action == 1) {
            outProfits = CalculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outProfits = CalculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outProfits);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateProfits();
    }


}
