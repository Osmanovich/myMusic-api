package Softray.MyMusic.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/song")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getSongs() {
        return songService.getSongs();
    }

    @PostMapping
    public void addSong(@RequestBody Song song){
        songService.addNewSong(song);
    }
    @DeleteMapping(path = "{songId}")
    public void deleteSong(@PathVariable("songId") Long songId) {
        songService.deleteSong(songId);
    }
    @PutMapping(path = {"{songId}"})
    public void editSong(
            @PathVariable("songId") Long songId,
            @RequestParam(required = false) String songName,
            @RequestParam(required = false) String artistName,
            @RequestParam(required = false)String songUrl
            ){
        songService.editSong(songId,songName,artistName,songUrl);
    }

}
