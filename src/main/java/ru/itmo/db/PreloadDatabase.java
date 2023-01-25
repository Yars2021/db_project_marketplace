package ru.itmo.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.util.HashPasswordEncoder;

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
            repository.save(new InternalRarity(0, "Select"));
            repository.save(new InternalRarity(1, "Deluxe"));
            repository.save(new InternalRarity(2, "Premium"));
            repository.save(new InternalRarity(3, "Exclusive"));
            repository.save(new InternalRarity(4, "Ultra"));
        };
    }

    @Bean
    CommandLineRunner preloadUser(UserRepository repository) {
        return args -> {
            repository.save(new InternalUser("Yars",
                    hashPasswordEncoder.encode("yars"),
                    "Yaroslav Sukhovey",
                    999, 999, 1000000));
            repository.save(new InternalUser("Ja_Vani",
                    hashPasswordEncoder.encode("soul"),
                    "Ja Vani",
                    10, 10, 100));
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
            repository.save(new InternalItem(0, "Yars", "RGX 11z Pro Vandal", 3, "RGB lights"));
            repository.save(new InternalItem(0, "Yars", "Prelude to Chaos Shorty", 3, "My favourite"));
            repository.save(new InternalItem(1, "Yars", "Champions 2022 Butterfly Knife", 3, "Exclusive"));
            repository.save(new InternalItem(1, "Yars", "Smite Knife", 0, "It's cursed"));

            repository.save(new InternalItem(0, "Ja_Vani", "Smite Phantom", 0, "It's cursed"));
            repository.save(new InternalItem(0, "Ja_Vani", "Prime Vandal", 2, "One of the best"));
            repository.save(new InternalItem(0, "Ja_Vani", "Reaver Vandal", 2, "Overrated but good"));
            repository.save(new InternalItem(1, "Ja_Vani", "Ego knife", 0, "Why..."));

            repository.save(new InternalItem(0, "val_neon", "Prime 2.0 Bucky", 2, "Clean"));
            repository.save(new InternalItem(0, "val_neon", "Protocol 781-A Bulldog", 4, "It has voicelines"));
            repository.save(new InternalItem(0, "val_neon", "RGX 11z Pro Operator", 3, "RGB lights and great sounds"));
            repository.save(new InternalItem(1, "val_neon", "RGX 11z Pro Firefly", 3, "Just clean"));
            repository.save(new InternalItem(1, "val_neon", "Prism Knife", 0, "From beta"));

            repository.save(new InternalItem(0, "val_skye", "Araxis vandal", 3, "The newest one"));
            repository.save(new InternalItem(0, "val_skye", "Sovereign Marshall", 2, "The sounds are just the best"));
            repository.save(new InternalItem(1, "val_skye", "Luxe Spectre", 0, "Old and weird"));
        };
    }

    @Bean
    CommandLineRunner testService(OfferRepository repository) {
        return args -> {
//            repository.save(new InternalOffer("Ja_Vani", "", 1500, "16.02.2002", 0));
//            repository.save(new InternalOffer("Yars", "val_neon", 1600, "09.11.2019", 1));
//            repository.save(new InternalOffer("Yars", "", 1500, "24.01.2022", 0));
//            repository.save(new InternalOffer("val_neon", "Yars", 1000, "24.01.2022", 1));
        };
    }
}
