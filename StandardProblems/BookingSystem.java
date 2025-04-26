import java.util.*;

public class BookingSystem {

    static class User {
        String id, name, email, password;

        User(String name, String email, String password) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }

    static class Booking {
        String id, userId, slot;

        Booking(String userId, String slot) {
            this.id = UUID.randomUUID().toString();
            this.userId = userId;
            this.slot = slot;
        }
    }

    static class BookingApp {
        Map<String, User> usersByEmail = new HashMap<>();
        List<Booking> bookings = new ArrayList<>();
        User currentUser = null;

        boolean signUp(String name, String email, String password) {
            if (usersByEmail.containsKey(email)) return false;
            usersByEmail.put(email, new User(name, email, password));
            return true;
        }

        boolean login(String email, String password) {
            User user = usersByEmail.get(email);
            if (user != null && user.password.equals(password)) {
                currentUser = user;
                return true;
            }
            return false;
        }

        boolean bookSlot(String slot) {
            if (currentUser == null) return false;
            bookings.add(new Booking(currentUser.id, slot));
            return true;
        }

        void showMyBookings() {
            for (Booking b : bookings) {
                if (b.userId.equals(currentUser.id)) {
                    System.out.println("Booked: " + b.slot);
                }
            }
        }
    }

    public static void main(String[] args) {
        BookingApp app = new BookingApp();

        app.signUp("Alice", "alice@example.com", "1234");
        if (app.login("alice@example.com", "1234")) {
            app.bookSlot("10:00 AM");
            app.bookSlot("2:00 PM");
            app.showMyBookings();
        } else {
            System.out.println("Login failed");
        }
    }
}
