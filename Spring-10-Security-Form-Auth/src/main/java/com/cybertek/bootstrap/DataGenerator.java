package com.cybertek.bootstrap;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataGenerator implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    // it will complain bc its missing bean its only interface to inject it we need bean( no java class to creat bean) can be found in confuguration class
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        //Delete All
        this.userRepository.deleteAll();

        //Create users
        User employee = new User("ozzy", passwordEncoder.encode("ozzy123"), "USER","");
        User admin = new User("admin", passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(employee,admin,manager);

        userRepository.saveAll(users);
    }


}
