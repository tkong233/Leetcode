package Interviews.Google;

public class MostBookedHotelRoom {
    /*
        Given a hotel which has 10 floors [0-9] and each floor has 26 rooms [A-Z].
        You are given a sequence of rooms, where + suggests room is booked, - room is freed.
        You have to find which room is booked maximum number of times.

        Exmaple:

        Input: ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]
        Output: "1A"
        Explanation: 1A as it has been booked 2 times.

     */
    String mostBookedHotelRoom(String[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        int[] counter = new int[260];
        String mostBooked = input[0];
        int maxCount = 0;

        for (String curRoom : input) {
            int id = getId(curRoom);
            if (curRoom.charAt(0) == '-') {
                continue;
            }
            counter[id] += 1;
            if (counter[id] == maxCount) {
                mostBooked = mostBooked.compareTo(curRoom) < 0 ? mostBooked : curRoom;
                continue;
            }
            if (counter[id] > maxCount) {
                maxCount = counter[id];
                mostBooked = curRoom;
            }
        }

        return mostBooked.substring(1);
    }

    int getId(String room) {
        return (room.charAt(1) - '0') * 26 + (room.charAt(2) - 'A');
    }

    public static void main(String[] args) {
        MostBookedHotelRoom solution = new MostBookedHotelRoom();
        for (char i = '0'; i <= '9'; i++) {
            for (char j = 'A'; j <= 'Z'; j++) {
                String cur = new String(new char[] {'+', i, j});
                System.out.println(cur + " " + solution.getId(cur));
            }
        }
    }
}
