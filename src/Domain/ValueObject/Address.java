package Domain.ValueObject;

public class Address {
    private String state;
    private String address;

    public Address(String state, String address) {
        this.state = state;
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Address = [" +
                "state: '" + state + '\'' +
                ", address: '" + address + '\'' +
                ']';
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
