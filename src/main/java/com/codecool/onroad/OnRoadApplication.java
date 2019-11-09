package com.codecool.onroad;

import com.codecool.onroad.model.Place;
import com.codecool.onroad.model.Road;
import com.codecool.onroad.model.UserEntity;
import com.codecool.onroad.repository.PlaceRepository;
import com.codecool.onroad.repository.RoadRepository;
import com.codecool.onroad.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.util.xml.PlatformXmlPropertiesProvider;

import java.time.LocalDateTime;

@SpringBootApplication
public class OnRoadApplication {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RoadRepository roadRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnRoadApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {

            UserEntity user1 = UserEntity.builder()
                    .userName("bazsi2382")
                    .email("balazsmiklos23@gmail.com")
                    .firstName("Balázs")
                    .lastName("Miklós")
                    .build();

            UserEntity user2 = UserEntity.builder()
                    .userName("janos69")
                    .email("janosvagyok@gmail.com")
                    .build();

            userRepository.saveAll(Lists.newArrayList(user1,user2));

            Place place1 = Place.builder()
                    .name("Budapest")
                    .build();

            Place place2 = Place.builder()
                    .name("Szombathely")
                    .build();

            Place place3 = Place.builder()
                    .name("Győr")
                    .build();

            Place place4 = Place.builder()
                    .name("Oberwart")
                    .build();

            placeRepository.saveAll(Lists.newArrayList(place1, place2, place3, place4));

            Road road = Road.builder()
                    .price(1500L)
                    .plannedArrival(LocalDateTime.of(2020, 4, 20, 9, 11))
                    .startTime(LocalDateTime.of(2019, 4, 20, 4, 19))
                    .destination(place4)
                    .start(place2)
                    .passenger(user2)
                    .transporter(user1)
                    .build();

            roadRepository.save(road);
        };
    }

}
