package Softray.MyMusic.song;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

    @Query("SELECT s FROM Song s WHERE s.songName=?1")
    Optional<Song> findSongBySongName(String songName);
}


