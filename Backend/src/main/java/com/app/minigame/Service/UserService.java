package com.app.minigame.Service;

import com.app.minigame.Model.Stats;
import com.app.minigame.Model.Users;
import com.app.minigame.Repository.StatsRepository;
import com.app.minigame.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StatsRepository statsRepository;

	public List<Users> getUsers() {
		List<Users> list = new ArrayList<>();
		// for each item in found in findALL add to list
		userRepository.findAll().forEach(list::add);
		return list;
	}

	public Users getUserById(Integer id) {
		return userRepository.findById(id);
	}

	public Users getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Users createUser(String username, String password) {
		Users u = new Users(username, password);
		// check if username already exists
		if (userRepository.existsUsersByUsername(username)) {
			return null;
		}
		userRepository.save(u);
		// get newly generated id
		int id = userRepository.findByUsername(username).getId();
		// make a new stats table entry for new user
		Stats s = new Stats(username, id);
		statsRepository.save(s);

		return u;
	}

	public Users deleteUser(String username, String password) {
		Users u = userRepository.findByUsername(username);
		if (u != null && u.getPassword() == password) {
			userRepository.delete(u);
		}
		return u;
	}

	public void updateUsername(Integer id, Users user) {
		userRepository.save(user);
	}

	public int loginValidation(String username, String password) {
		if (userRepository.existsUsersByUsernameAndPassword(username, password)) {
			return 1;
		}
		return 0;
	}

}
