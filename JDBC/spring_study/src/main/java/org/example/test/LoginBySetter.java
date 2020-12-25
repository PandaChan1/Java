package org.example.test;

public class LoginBySetter {
    private Person person;

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        System.out.println("LoginBySetter: Person = " + person);
        this.person = person;
    }
}
