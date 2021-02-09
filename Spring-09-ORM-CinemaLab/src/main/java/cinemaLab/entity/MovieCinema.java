package cinemaLab.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
// used to change table name
//@Table("movie_cinema")
public class MovieCinema extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;


    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;


    public MovieCinema(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

}
