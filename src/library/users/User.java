package library.users;

import library.database.Savable;

public abstract class User implements Savable {
    protected String id;
    protected String name;
    protected String email;
    protected String address;
    protected String phoneNumber;

    public User(String id, String name, String email, String address, String phoneNumber) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
    }

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
    public String serialize() {
        return this.getId() + "," + this.getName() + "," + this.getEmail() + "," + this.getAddress() + "," + this.getPhoneNumber();
    }
}
