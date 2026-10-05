package com.campus.safety;

import com.campus.safety.entity.Escort;
import com.campus.safety.entity.EscortRequest;
import com.campus.safety.repository.EscortRepository;
import com.campus.safety.repository.EscortRequestRepository;
import com.campus.safety.entity.RequestStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampusSafetyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusSafetyApplication.class, args);
    }

    @Bean
    CommandLineRunner seed( EscortRepository escortRepository) {
        return args -> {
            if (escortRepository.count() == 0) {
                escortRepository.save(new Escort(null, "Ravi Kumar", "ESC-014", "9876543210", true));
                escortRepository.save(new Escort(null, "Suresh Reddy", "ESC-021", "9876501234", true));
                escortRepository.save(new Escort(null, "Arjun Singh", "ESC-028", "9876512345", true));
            }
        };
    }
}
