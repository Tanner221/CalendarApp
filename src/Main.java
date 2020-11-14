import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int month = getMonth();
	    int year = getYear();
	    int offset = computeOffset(year, month);
	    System.out.print(offset);
	    display(year, month, offset);
    }

/**********************************************************************
    * Get month asks the user for the month and then does and error check
    * with a do - while loop
 ***********************************************************************/
    public static int getMonth() {
        int month;
        do {
            Scanner getMonth = new Scanner(System.in);
            System.out.print("Enter a month number: ");

            month = getMonth.nextInt();
            if(month > 12 || month < 1)
            {
                System.out.println("Month must be between 1 and 12.");
            }
        }
        while(month > 12 || month <= 0);

        return month;
    }

 /**********************************************************************
   * Get year asks the user for the year and then does and error check
   * with a do - while loop
 ***********************************************************************/
    public static int getYear(){
        int year;
        do {
            Scanner getMonth = new Scanner(System.in);
            System.out.print("Enter year: ");

            year = getMonth.nextInt();
            if(year < 1753)
            {
                System.out.println("Year must be 1753 or later.");
            }
        }
        while(year < 1753);

        return year;
    }
    public static int computeOffset(int year, int month){
        int sumOfDays = 0;

        for(int currentYear = 1753; currentYear < year; currentYear++)
        {
            sumOfDays += numDaysInYear(currentYear);
        }
        for(int currentMonth = 1; currentMonth < month; currentMonth++)
        {
            sumOfDays += numDaysInMonth(year, currentMonth);
        }
        return (sumOfDays % 7);
    }
    public static int numDaysInYear(int year){
        return 365 + isLeapYear(year);
    }
    public static int numDaysInMonth(int year, int month){
        int numDays = 0;
        //no returning inside a switch statement?
        switch (month){
            case 3: case 5: case 7: case 8: case 10: case 12:
                numDays = 31;
            break;
            case 2:
                numDays = 28 + isLeapYear(year);
                break;
            case 4, 6, 9, 11:
                numDays = 30;
                break;
            default:
                numDays = 0;
        }
        return numDays;
    }
    public static int isLeapYear(int year){

        if (year % 400 == 0) //when year is divisible by 400
            return 1; //it will always be a leap year
        else if (year % 100 == 0)
            return 0;
        else if (year % 4 == 0) //every 4th year, is a leap year.
            return 1;
        else
            return 0;
    }
    public static void display(int year, int month, int offset) {
        int numDays = numDaysInMonth(year, month);
        displayHeader(year, month);
        displayTable(numDays, offset, year);
        return;
    }
    public static void displayTable(int numDays, int offset, int year){
        System.out.println("  Su  Mo  Tu  We  Th  Fr  Sa");
        if (isLeapYear(year) == 1){
            offset -= 1;
        }
        for(int i = 0; i <= offset; i++){
            System.out.print("   "); //4 spaces per offset
        }
        for(int j = 0; j < numDays; j++){
            int newLine = j + offset;
            if (newLine % 7 == 0)
                System.out.print("\n");
            int day = j + 1;
            if(j + 1 < 10)
            {
                System.out.print("   " + day);
            }
            else if(j + 1 >= 10)
            {
                System.out.print("  " + day);
            }

        }
        if((numDays + offset + 1) % 7 != 0)
            System.out.println();
    }

    public static void displayHeader(int year, int month){
        System.out.println();
        if (month == 1)
            System.out.println("January, " + year);
        else if (month == 2)
            System.out.println("February, " + year);
        else if (month == 3)
            System.out.println("March, " + year);
        else if (month == 4)
            System.out.println("April, " + year);
        else if (month == 5)
            System.out.println("May, " + year);
        else if (month == 6)
            System.out.println("June, " + year);
        else if (month == 7)
            System.out.println("July, " + year);
        else if (month == 8)
            System.out.println("August, " + year);
        else if (month == 9)
            System.out.println("September, " + year);
        else if (month == 10)
            System.out.println("October, " + year);
        else if (month == 3)
            System.out.println("November, " + year);
        else
            System.out.println("December, " + year);
        return;
    }
}
