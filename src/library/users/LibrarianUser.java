package library.users;

public class LibrarianUser extends User {
    public LibrarianUser(String id, String name, String email, String address, String phoneNumber) {
        super(id, name, email, address, phoneNumber);
    }

    public static LibrarianUser deserialize(String line)
    {
        String[] data = line.split(",");

        return new LibrarianUser(data[0], data[1], data[2], data[3], data[4]);
    }

    public boolean isAdmin()
    {
        return false;
    }
}
