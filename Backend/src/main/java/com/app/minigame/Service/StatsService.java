package com.app.minigame.Service;

import com.app.minigame.Model.Stats;
import com.app.minigame.Repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatsService {
	
	@Autowired
    private StatsRepository statsRepository;
	
	public List<Stats> getAllStats() {
		List<Stats> stats = new ArrayList<>();
		statsRepository.findAll().forEach(stats::add);
		return stats;
	}

	
	public Stats getStatsByID(Integer id) {
	    return statsRepository.findById(id);
	}
	
	public Stats getUsername(String username) {
	    return statsRepository.findByUsername(username);
	}

	
	public Stats createStats(String username, Integer id){
		Stats s = new Stats(username, id);
        if(statsRepository.findByUsername(username).getUsername() == username){
        	return null;
        }
		statsRepository.save(s);
        return s;
    }

	public void updateGamesPlayed(Integer id, Integer gameNumber, Integer gamesPlayed, Integer gameHighScore) {
		Stats s = statsRepository.findById(id);
		statsRepository.addGamesPlayedTotal(id, s.getTotalGamesPlayed() + gamesPlayed);

		Integer highScore = s.getGameHighScore(gameNumber);
		if(highScore == null){
			highScore = 0;
		}

		switch(gameNumber){
			case 1:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame1Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);

				break;
			case 2:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame2Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);
				break;
			case 3:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame3Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);
				break;
			case 4:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame4Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);
				break;
			case 5:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame5Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);
				break;
			case 6:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame6Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);
				break;
			case 7:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame7Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);
				break;
			case 8:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame8Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);
				break;
			case 9:
				if(s.getGameHighScore(gameNumber) != null || gameHighScore > s.getGameHighScore(gameNumber)) {
					highScore = gameHighScore;
				}
				statsRepository.updateGame9Stats(id, highScore, s.getGamesPlayed(gameNumber) + gamesPlayed);
				break;

				default:
					break;
		}
	}
}
