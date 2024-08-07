package wel.devjava.picoledrone.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import wel.devjava.picoledrone.domain.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static List<Anime> animes;

    static {
        animes = new ArrayList<>( List.of( new Anime( 1L, "Boku No Hero" ), new Anime( 2L, "Berserk" ) ) );
    }

    public List<Anime> listAll() {
        return List.of( new Anime( 1L, "Boku No Hero" ), new Anime( 2L, "Berserk" ) );

    }

    public Anime findById(Long id) {
        return animes.stream()
                .filter( anime -> anime.getId().equals( id ) )
                .findFirst()
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.BAD_REQUEST, "Anime not Found" ) );

    }

    public Anime save(Anime anime) {
        anime.setId( ThreadLocalRandom.current().nextLong(3, 1000000) );
        animes.add( anime );
        return anime;
    }

    public void delete(long id) {
        animes.remove( findById( id ) );

    }

    public void replace(Anime anime) {
        delete( anime.getId() );
        animes.add(anime);
    }
}
