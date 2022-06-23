package club.zqprime.pool;

public class Foo {

    private final String username;

    public Foo(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "username='" + username + '\'' +
                '}';
    }
}
