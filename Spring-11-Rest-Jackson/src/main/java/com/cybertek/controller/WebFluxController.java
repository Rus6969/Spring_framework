package com.cybertek.controller;

import com.cybertek.entity.Genre;
import com.cybertek.entity.MovieCinema;
import com.cybertek.repository.GenreRepository;
import com.cybertek.repository.MovieCinemaRepository;
import com.cybertek.repository.MovieRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/*/ must be added first to work with mono and flux
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        In Spring WebFlux, the data returned from any operation is packed into a reactive stream.
        There are two types that embody this approach and are the building blocks in WebFlux applications - Mono and Flux.
Mono is a stream which returns zero items or a single item (0..1), whereas Flux is a stream which returns zero or more items (0..N).
 */
@RestController
public class WebFluxController {
    // baseUrl("http://localhost:8080").build(); api which we are trying to consume ( as an example we consume our api)
    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();


    private MovieCinemaRepository movieCinemaRepository;
    private GenreRepository genreRepository;

    public WebFluxController(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    //I nreactive Programming if metjod return 0.1 if more than 1 flux
    // REGULAR
//    @GetMapping
//    public List<MovieCinema> readAllCinemasFlux(){
//
//    }

    // here since repository returns list we need make changes in return statement list is converted to flux structure
    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readyById(@PathVariable("id") Long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema> readByIdRequestParam(@RequestParam("id") Long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @PostMapping("create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre) {
        Genre createdgenre = genreRepository.save(genre);
        return Mono.just(createdgenre);
        //      return Mono.just(genreRepository.save(genre));
    }

    @PutMapping("/update-genre")
    public Mono<Genre> updatedGenre(@RequestBody Genre genre){
        Genre updatedGenre= genreRepository.save(genre);
        return Mono.just(updatedGenre);
    }

    @DeleteMapping("/delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
        return Mono.empty();
    }

}
