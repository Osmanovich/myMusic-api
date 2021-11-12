package Softray.MyMusic.song;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Configuration
public class SongConfig {
    LocalDate localDate = LocalDate.now();
    @Bean
    CommandLineRunner commandLineRunner(SongRepository songRepository){
        return args ->{
            Song hit = new Song(
                    "Biser",
                    "Lala",
                    "www.yt.ba",
                    5,
                    true
                    );

            Song top = new Song(
                    "Zlato",
                    "Tulipan",
                    "www.ytt.ba",
                    4,
                    false


            );
            songRepository.saveAll(
                    List.of(hit,top)
            );
        };
    }
}
