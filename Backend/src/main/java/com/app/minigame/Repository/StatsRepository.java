package com.app.minigame.Repository;

import com.app.minigame.Model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StatsRepository extends JpaRepository<Stats, String> {
	
	public Stats findById(Integer id);
	
	public Stats findByUsername(String username);

	@Modifying
	@Query(value = "UPDATE stats s SET s.gamesPlayed = :addedGames WHERE s.id = :statId", nativeQuery = true)
	void addGamesPlayedTotal(@Param("statId") Integer statId, @Param("addedGames") Integer addedGames);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game1score = :gameHighScore, s.game1played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame1Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game2score = :gameHighScore, s.game2played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame2Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game3score = :gameHighScore, s.game3played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame3Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game4score = :gameHighScore, s.game4played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame4Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game5score = :gameHighScore, s.game5played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame5Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game6score = :gameHighScore, s.game6played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame6Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game7score = :gameHighScore, s.game7played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame7Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game8score = :gameHighScore, s.game8played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame8Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);

	@Modifying
	@Query(value = "UPDATE stats s SET s.game9score = :gameHighScore, s.game9played = :addedGamesPlayed WHERE s.id = :statId", nativeQuery = true)
	void updateGame9Stats(@Param("statId") Integer statId, @Param("gameHighScore") Integer gameHighScore, @Param("addedGamesPlayed") Integer addedGamesPlayed);


}
