package com.app.minigame.Controller;

import com.app.minigame.Model.Stats;
import com.app.minigame.Service.StatsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Player Stats", description = "Operations pertaining to the stats of players")
public class StatsController {
	
	@Autowired
    private StatsService statsService;

    @Operation(description = "Returns the stats of all users")
    @GetMapping("/stats/all")
	List<Stats> getAllStats(){
		return statsService.getAllStats();
	}

    @Operation(description = "Gets the stats of user with a particular id")
	@GetMapping("/stats/{id}")
    Stats getUserByID(@PathVariable Integer id){
        return statsService.getStatsByID(id);
    }

    @Operation(description = "Gets the stats of a user with a particular username")
	@GetMapping("/statsbyuser/{username}")
    Stats getUserByName(@PathVariable String username){
        return statsService.getUsername(username);
    }

    //for testing only, new stats entry will be made when a new user is made
    @Operation(description = "Creates a new stats table entry")
	@PostMapping("/stats/new/{username}/{id}")
    Stats createUser(@PathVariable String username, @PathVariable Integer id){
        return statsService.createStats(username, id);

    }

    @Operation(description = "Updates the stats of the user with the given id, adds the given values to the existing values in the database")
    @PutMapping("/stats/{id}/update/{gameNumber}/{gamesPlayed}/{gameHighScore}")
    void updateGamesPlayed(@PathVariable Integer id, @PathVariable Integer gameNumber, @PathVariable Integer gamesPlayed, @PathVariable Integer gameHighScore){
        statsService.updateGamesPlayed(id, gameNumber, gamesPlayed, gameHighScore);
    }



}
