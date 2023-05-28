package Domain.ValueObject;

public class Contact{
    private int phone;
    private String email;

    public Contact(int phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact [" +
                "Phone: " + phone +
                ", Email: '" + email + '\'' +
                ']';
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
