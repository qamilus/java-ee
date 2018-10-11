package pl.swislowski.kamil.javaee.cwiczenia.wynagrodzenie;


import static pl.swislowski.kamil.javaee.cwiczenia.wynagrodzenie.WorkTime.EXTRA_TIME_MONEY;
import static pl.swislowski.kamil.javaee.cwiczenia.wynagrodzenie.WorkTime.MONEY_HOUR;

public class WorkTimeMain {

    public static void main(String[] args) {

        WorkTime workTime1 = new WorkTime(WorkTime.STANDARD_WORK_TIME, MONEY_HOUR, 0, EXTRA_TIME_MONEY);
        workTime1.ordinarySalaryCalculate(workTime1);

        WorkTime workTime2 = new WorkTime(WorkTime.STANDARD_WORK_TIME, MONEY_HOUR, 80, EXTRA_TIME_MONEY);
        workTime2.extraHoursSalaryCalculate(workTime2);

    }
}