package pl.swislowski.kamil.javaee.cwiczenia.wynagrodzenie;


public class WorkTime {
    public static final int EXTRA_TIME_MONEY = 18;
    public static final int MONEY_HOUR = 12;
    public static final int STANDARD_WORK_TIME = 160;
    private int timeMonthly;
    private int moneyHour;
    private int extraTime;
    private int extraTimeMoney;

    public WorkTime() {
    }

    public WorkTime(int timeMonthly, int moneyHour, int extraTime, int extraTimeMoney) {
        this.timeMonthly = timeMonthly;
        this.moneyHour = moneyHour;
        this.extraTime = extraTime;
        this.extraTimeMoney = extraTimeMoney;
    }

    public int ordinarySalaryCalculate(WorkTime workTime) {
        int totalSalary = 0;
        if (workTime.getTimeMonthly() <= STANDARD_WORK_TIME) {
            totalSalary = workTime.getTimeMonthly() * workTime.getMoneyHour();
            System.out.println("Pracownik nie ma przepracowanych żadnych nadgodzin " +
                    "i jego stawka godzinowa wynosi " + MONEY_HOUR + " zł. Wypłata ogółem za ten miesiąc wynosi : " +
                    totalSalary);

        }
        return totalSalary;
    }

    public int extraHoursSalaryCalculate(WorkTime workTime) {
        int totalSalary = 0;

        int extraTime = workTime.getTimeMonthly() + workTime.getExtraTime();
        int standardSalary = workTime.getTimeMonthly() * workTime.getMoneyHour();
        int extraSalary = workTime.getExtraTime() * workTime.getExtraTimeMoney();

        if (extraTime > STANDARD_WORK_TIME) {
            totalSalary = standardSalary + extraSalary;
            System.out.println("\n Pracownik przepracował pewną ilość ( " + workTime.getExtraTime() + " )" +
                    " godzin nadliczbowych. Jego pensja wzrosła i " +
                    "w tym miesiącu wyniesie: " + totalSalary);
        }

        return totalSalary;
    }

    public int getTimeMonthly() {
        return timeMonthly;
    }

    public void setTimeMonthly(int timeMonthly) {
        this.timeMonthly = timeMonthly;
    }

    public int getMoneyHour() {
        return moneyHour;
    }

    public void setMoneyHour(int moneyHour) {
        this.moneyHour = moneyHour;
    }

    public int getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(int extraTime) {
        this.extraTime = extraTime;
    }

    public int getExtraTimeMoney() {
        return extraTimeMoney;
    }

    public void setExtraTimeMoney(int extraTimeMoney) {
        this.extraTimeMoney = extraTimeMoney;
    }
}
