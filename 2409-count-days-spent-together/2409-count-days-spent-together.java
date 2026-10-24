class Solution {
    // Days in each month for a non-leap year
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Find the start and end of the overlap
        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        // If start date is after end date, there's no overlap
        if (start.compareTo(end) > 0) {
            return 0;
        }

        // Return inclusive number of days between start and end
        return countDaysOfYear(end) - countDaysOfYear(start) + 1;
    }

    private int countDaysOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += DAYS_IN_MONTH[i];
        }

        return dayOfYear;
    }
}