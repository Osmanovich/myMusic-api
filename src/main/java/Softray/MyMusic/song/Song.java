package Softray.MyMusic.song;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Song {
    @Id
    @SequenceGenerator(
            name = "songs_sequence",
            sequenceName = "songs_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "songs_sequence"
    )


    private long id;
    private String songName;
    private String artistName;
    private String url;
    private Integer rating;
    private boolean favourite;
    private LocalDate dateEntered=LocalDate.now();
    private LocalDateTime dateLastEdited=LocalDateTime.now();

    public Song() {
    }

    public Song(long id,
                String songName,
                String artistName,
                String url,
                Integer rating,
                boolean favourite,
                LocalDate dateEntered,
                LocalDateTime dateLastEdited) {
        this.id = id;
        this.songName = songName;
        this.artistName = artistName;
        this.url = url;
        this.rating = rating;
        this.favourite = favourite;
        this.dateEntered = dateEntered;
        this.dateLastEdited = dateLastEdited;
    }

    public Song(String songName,
                String artistName,
                String url,
                Integer rating,
                boolean favourite) {


        this.songName = songName;
        this.artistName = artistName;
        this.url = url;
        this.rating = rating;
        this.favourite = favourite;

    }

    public Song(String songName,
                String artistName,
                String url,
                Integer rating,
                boolean favourite,
                LocalDate dateEntered,
                LocalDateTime dateLastEdited
    )

    {
        this.songName = songName;
        this.artistName = artistName;
        this.url = url;
        this.rating = rating;
        this.favourite = favourite;
        ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public LocalDate getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(LocalDate dateEntered) {
        this.dateEntered = dateEntered;
    }

    public LocalDateTime getDateLastEdited() {
        return dateLastEdited;
    }

    public void setDateLastEdited(LocalDateTime dateLastEdited) {
        this.dateLastEdited = dateLastEdited;
    }



    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", url='" + url + '\'' +
                ", rating=" + rating +
                ", favourite=" + favourite +
                ", dateEntered=" + dateEntered +
                ", dateLastEdited=" + dateLastEdited +
                '}';
    }
}

