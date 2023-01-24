package ru.itmo.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.service.OfferService;
import ru.itmo.util.HashPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class PreloadDatabase {
    private final HashPasswordEncoder hashPasswordEncoder = new HashPasswordEncoder();
    public PreloadDatabase() {
    }

    @Bean
    CommandLineRunner preloadStatus(StatusRepository repository) {
        return args -> {
            repository.save(new InternalStatus(0, "Active"));
            repository.save(new InternalStatus(1, "Closed"));
        };
    }

    @Bean
    CommandLineRunner preloadType(TypeRepository repository) {
        return args -> {
            repository.save(new InternalType(0, "Gun"));
            repository.save(new InternalType(1, "Melee"));
        };
    }

    @Bean
    CommandLineRunner preloadRarity(RarityRepository repository) {
        return args -> {
            repository.save(new InternalRarity(0, "Common"));
            repository.save(new InternalRarity(1, "Rare"));
            repository.save(new InternalRarity(2, "Epic"));
            repository.save(new InternalRarity(3, "Legendary"));
        };
    }

    @Bean
    CommandLineRunner preloadUser(UserRepository repository) {
        return args -> {
            repository.save(new InternalUser("Yars",
                    hashPasswordEncoder.encode("yars"),
                    "Yaroslav Sukhovey",
                    999, 999, 1000000));
            repository.save(new InternalUser("val_neon",
                    hashPasswordEncoder.encode("overdrive"),
                    "Neon",
                    5, 5, 1000));
            repository.save(new InternalUser("val_raze",
                    hashPasswordEncoder.encode("showstopper"),
                    "Raze",
                    5, 5, 1000));
            repository.save(new InternalUser("val_jett",
                    hashPasswordEncoder.encode("bladestorm"),
                    "Jett",
                    5, 5, 1000));
            repository.save(new InternalUser("val_reyna",
                    hashPasswordEncoder.encode("empress"),
                    "Reyna",
                    5, 5, 1000));
            repository.save(new InternalUser("val_skye",
                    hashPasswordEncoder.encode("seekers"),
                    "Skye",
                    5, 5, 1000));
        };
    }

    @Bean
    CommandLineRunner preloadItem(ItemRepository repository) {
        return args -> {
            repository.save(new InternalItem(0, "Yars", "Test item", 3, "Nothing"));
            repository.save(new InternalItem(1, "Yars", "A gun", 2, "123"));
            repository.save(new InternalItem(1, "Yars", "A knife", 1, "456"));
            repository.save(new InternalItem(0, "Yars", "Something", 0, "gg"));
            for (int i = 0; i < 30; i++) {
                repository.save(new InternalItem(ThreadLocalRandom.current().nextInt(0, 2),
                        "user" + ThreadLocalRandom.current().nextInt(0, 6), "item " + i,
                        ThreadLocalRandom.current().nextInt(0, 2), "description " + i));
            }
        };
    }

    @Bean
    CommandLineRunner testService(OfferRepository repository) {
        return args -> {
            repository.save(new InternalOffer("user2", "user4", 1241, "12.12.2012", 0));
            repository.save(new InternalOffer("Yars", "val_neon", 1600, "09.11.2019", 1));
            repository.save(new InternalOffer("Yars", "", 1500, "24.01.22", 0));
            repository.save(new InternalOffer("val_neon", "Yars", 1000, "24.01.22", 1));
        };
    }
}
