package com.example.projectevent;


import com.example.projectevent.model.AppUser;
import com.example.projectevent.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {


        if (userRepository.findByUsername("admin").isEmpty()) {
            AppUser admin = new AppUser(null, "admin", passwordEncoder.encode("admin123"), "ADMIN");
            userRepository.save(admin);

        }

        if (userRepository.findByUsername("user").isEmpty()) {
            AppUser user = new AppUser(null, "user", passwordEncoder.encode("user123"), "USER");
            user = new AppUser(null, "user2", passwordEncoder.encode("user123"),"USER");
            userRepository.save(user);
        }
    }
}
