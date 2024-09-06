public class TrainReservationSystem {
    private static final int MAX_SEATS = 100;
    private static boolean[] seats = new boolean[MAX_SEATS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Check Seat Availability");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookTicket(scanner);
                    break;
                case 2:
                    cancelTicket(scanner);
                    break;
                case 3:
                    checkSeatAvailability();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookTicket(Scanner scanner) {
        System.out.print("Enter the number of seats to book: ");
        int numSeats = scanner.nextInt();

        if (numSeats > getAvailableSeats()) {
            System.out.println("Sorry, only " + getAvailableSeats() + " seats are available.");
            return;
        }

        System.out.print("Enter the seat numbers (separated by spaces): ");
        for (int i = 0; i < numSeats; i++) {
            int seat = scanner.nextInt();
            if (seat < 1 || seat > MAX_SEATS || seats[seat - 1]) {
                System.out.println("Seat " + seat + " is not available.");
            } else {
                seats[seat - 1] = true;
                System.out.println("Seat " + seat + " booked successfully.");
            }
        }
    }

    private static void cancelTicket(Scanner scanner) {
        System.out.print("Enter the seat number to cancel: ");
        int seat = scanner.nextInt();

        if (seat < 1 || seat > MAX_SEATS || !seats[seat - 1]) {
            System.out.println("Seat " + seat + " is not booked.");
        } else {
            seats[seat - 1] = false;
            System.out.println("Seat " + seat + " canceled successfully.");
        }
    }

    private static void checkSeatAvailability() {
        System.out.println("Available seats:");
        for (int i = 0; i < MAX_SEATS; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    private static int getAvailableSeats() {
        int available = 0;
        for (boolean seat : seats) {
            if (!seat) {
                available++;
            }
        }
        return available;
    }
}