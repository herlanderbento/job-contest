package Domain.Entity;

import Domain.ValueObject.Address;
import Domain.ValueObject.Contact;

public class Applicant {
    private String name;
    private int age;
    private Address address;
    private Contact contact;


    public Applicant(String name, int age, Address address, Contact contact) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Applicant{ " +
                "Name: '" + name + '\'' +
                ", Age: " + age +
                ", Address: " + address +
                ", contact: " + contact +
                '}';
    }
}
