package fullstacktraining.springboot.react.service;

import fullstacktraining.springboot.react.exception.BadRequestException;
import fullstacktraining.springboot.react.model.Game;
import fullstacktraining.springboot.react.repository.GameRepository;
import fullstacktraining.springboot.react.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final Utils utils;
    private final GameRepository gameRepository;

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    @Transactional
    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    public Game updateGame(Game game){
      return gameRepository.save(game);
    }

    public Game findById(Long id){
        return gameRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Employee not found with id: " + id));
    }

    public void deleteGame(Long id){
        gameRepository.delete(utils.findUserOrThrowNotFound(id, gameRepository));
    }
}
