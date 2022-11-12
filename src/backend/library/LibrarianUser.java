package backend.library;

import backend.library.database.Item;

public class LibrarianUser implements Item {
    public LibrarianUser(String id, String name, String email, String address, String phoneNumber) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
    }

    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public void setId(String id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String getSearchKey() {
        return this.getId();
    }

    @Override
    public String lineRepresentation() {
        return this.getId() + "," + this.getName() + "," + this.getEmail() + "," + this.getAddress() + "," + this.getPhoneNumber();
    }

    public void print()
    {
        System.out.println(this.lineRepresentation());
    }

    public static LibrarianUser createFromString(String line)
    {
        String[] data = line.split(",");

        return new LibrarianUser(data[0], data[1], data[2], data[3], data[4]);
    }
}
