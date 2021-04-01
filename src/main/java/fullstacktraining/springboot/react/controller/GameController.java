package fullstacktraining.springboot.react.controller;

import fullstacktraining.springboot.react.model.Game;
import fullstacktraining.springboot.react.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllEmployees(){
        return ResponseEntity.ok(gameService.findAll());
    }

    @PostMapping
    public ResponseEntity<Game> saveEmployee(@RequestBody Game game){
        return ResponseEntity.ok(gameService.saveGame(game));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Game> updateEmployee(@PathVariable Long id, @RequestBody Game gameDetails){

        Game game = gameService.findById(id);
        game.setTitle(gameDetails.getTitle());
        game.setDescription(gameDetails.getDescription());
        game.setPictureUrl(gameDetails.getPictureUrl());
        game.setGenre(gameDetails.getGenre());
        game.setGameUrl(gameDetails.getGameUrl());

       Game updatedGame =  gameService.updateGame(game);
        return  ResponseEntity.ok(updatedGame);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
