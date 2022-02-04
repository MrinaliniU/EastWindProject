package MyInterviews.Microsoft.NewGradInterview;
/*
    You are hired at a hotel with infinite number of rooms. You are to write two function one for check-in and
    another for check-out. When someone wants to check-in you return the smallest room number available.
    When anyone checks-out you return the room number back to the pool of rooms available.
    Bit-manipulation.
 */
public class HotelProblem {
    int roomNumber;
    HotelProblem(){
        roomNumber = 0;
    }
    int checkIn(){
        return 0;
    }

    void checkOut(int roomNumber){

    }

    public static void main(String[] args){
        HotelProblem hotel = new HotelProblem();
        System.out.println(hotel.checkIn()); //0
        System.out.println(hotel.checkIn());//1
        System.out.println(hotel.checkIn()); //2
        System.out.println(hotel.checkIn()); //3
        System.out.println(hotel.checkIn()); //4
        System.out.println(hotel.checkIn()); //5
        System.out.println(hotel.checkIn()); //6
        hotel.checkOut(2);
        System.out.println(hotel.checkIn()); // 2
        hotel.checkOut(3);
        System.out.println(hotel.checkIn()); // 3
    }
}
