package com.kodilla.good.patterns.challenges;

public class EmailInformationService implements InformationService {
    public void inform(User user) {
        System.out.println("Sending email to: " + user.getEmail());
    }
}
