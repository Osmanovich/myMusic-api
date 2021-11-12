package Softray.MyMusic.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(Softray.MyMusic.song.SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getSongs() {
        return songRepository.findAll();

    }

    public void addNewSong(Song song) {
        Optional<Song> songOptional = songRepository.findSongBySongName(song.getSongName());
        if (songOptional.isPresent()) {
            throw new IllegalStateException("Song with this name already exist");
        }
        songRepository.save(song);
    }

    public void deleteSong(Long songId) {
        boolean existsId = songRepository.existsById(songId);
        if(!existsId){
            throw new IllegalStateException("Song not found");
        }
        songRepository.deleteById(songId);
    }
    @Transactional
    public void editSong(Long songId,
                         String songName,
                         String artistName,
                         String songURL) {
        Song song = songRepository.findById(songId).orElseThrow(() -> new IllegalStateException("Song not found"));

        Optional<Song> songOptional = songRepository.findSongBySongName(songName);
        if (songOptional.isPresent()){
            throw new IllegalStateException("Song with this name already exists");
        }
        else if(songName != null &&
                songName.length()>0 &&
                !Objects.equals(song.getSongName(),songName )){

            song.setSongName(songName);}


        if (artistName != null &&
                artistName.length() > 0 &&
                !Objects.equals(song.getArtistName(), artistName)
        ) {
            song.setArtistName(artistName);
        }
        if (songURL != null &&
                songURL.length() > 0 &&
                !Objects.equals(song.getUrl(), songURL)
        ) {
            song.setUrl(songURL);
        }
        song.setDateLastEdited(LocalDateTime.now());
    }

    }







