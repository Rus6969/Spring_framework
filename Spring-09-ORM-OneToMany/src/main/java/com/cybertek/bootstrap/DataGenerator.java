package com.cybertek.bootstrap;

import com.cybertek.entity.Address;
import com.cybertek.entity.Person;
import com.cybertek.repository.Addressrepository;
import com.cybertek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    Addressrepository addressRepository;


    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person("Ruslan", "Samatov");
        Person p2 = new Person("Inna","Gorbunova");
        Person p3 = new Person("Miho","Erohin");


        Address a1 = new Address("King St","22042");
        Address a2 = new Address("Elm St","22102");
        Address a3 = new Address("Java St","22036");

       // case1
       // p1.setAddresses(Arrays.asList(a1,a2));

       // personRepository.save(p1);




        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p1);

        addressRepository.save(a1);
        addressRepository.save(a2);
        addressRepository.save(a3);


    }
}
