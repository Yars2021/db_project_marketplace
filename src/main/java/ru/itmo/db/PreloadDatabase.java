package ru.itmo.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.service.OfferService;
import ru.itmo.util.HashPasswordEncoder;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class PreloadDatabase {
    private final HashPasswordEncoder hashPasswordEncoder = new HashPasswordEncoder();
    private OfferService offerService;

    public PreloadDatabase(OfferService offerService) {
        this.offerService = offerService;
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
        };
    }

    @Bean
    CommandLineRunner preloadUser(UserRepository repository) {
        return args -> {
            for (int i = 0; i < 5; i++) {
                repository.save(new InternalUser("user" + i,
                        hashPasswordEncoder.encode("password" + i),
                        "Test User " + i,
                        5, 5, 100));
            }
        };
    }

    @Bean
    CommandLineRunner preloadItem(ItemRepository repository) {
        return args -> {
            for (int i = 0; i < 30; i++) {
                repository.save(new InternalItem(ThreadLocalRandom.current().nextInt(0, 2),
                        "user" + ThreadLocalRandom.current().nextInt(0, 5), "item " + i,
                        ThreadLocalRandom.current().nextInt(0, 2), "description " + i));
            }
        };
    }

    @Bean
    CommandLineRunner testService(OfferRepository repository) {
        return args -> {
//            repository.save(new InternalOffer("user2", "user4", 1241, "12.12.12", 0));
//
//            List<InternalOffer> offers = repository.findByBuyer("user4");
//            for (InternalOffer offer : offers) {
//                System.out.printf(offer.getOid() + " " + offer.getPrice() + " " + offer.getSalesman());
//            }
        };
    }
}
