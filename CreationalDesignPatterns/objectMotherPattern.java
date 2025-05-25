// Sample domain class
class User {
    private String username;
    private String email;
    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "', age=" + age + "}";
    }

    // Getters/setters omitted for brevity
}

// Object Mother class
class UserMother {
    public static User defaultUser() {
        return new User("defaultUser", "default@example.com", 30);
    }

    public static User teenageUser() {
        return new User("teenUser", "teen@example.com", 16);
    }

    public static User userWithEmail(String email) {
        return new User("customUser", email, 25);
    }
}

// Usage example
public class TestExample {
    public static void main(String[] args) {
        User user1 = UserMother.defaultUser();
        User user2 = UserMother.teenageUser();
        User user3 = UserMother.userWithEmail("custom@example.com");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}
