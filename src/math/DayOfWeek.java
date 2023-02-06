package math;

public class DayOfWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        if (month < 3) { // Jan as 13th month and Feb as 14th month of the previous year
            month += 12;
            year -= 1;
        }

        int c = year / 100;
        int y = year % 100;
        int w = (y + y / 4 + c / 4 - 2 * c + 26 * (month + 1) / 10 + day - 1) % 7; // Zeller formula

        return week[(w + 7) % 7];
    }
}
