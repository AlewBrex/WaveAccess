package main.service;

import lombok.extern.log4j.Log4j2;
import main.api.request.UserRequest;
import main.model.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class UserService
{
    private Map<String, Integer> sessionIdAndUserId = new HashMap<>();
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User regUser(UserRequest userRequest)
    {
        String email = userRequest.getEmail();
        User userRepo = userRepository.findByEmail(email);

        if (userRepo != null)
        {
            log.info("Error. User exist! Try again.");
        }
        User user = new User();
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setPatronymic(userRequest.getPatronymic());

        userRepository.save(user);
        log.info("Registered user: " + user);
        return user;
    }

    public User updateUser(UserRequest ur)

    {
        User user = userRepository.findByLogin(ur.getLogin());
        user.setLogin(ur.getLogin());
        user.setPassword(ur.getPassword());
        user.setEmail(ur.getEmail());
        user.setName(ur.getName());
        user.setSurname(ur.getSurname());
        user.setPatronymic(ur.getPatronymic());

        log.info("Data user: " + user + "changed");
        return user;
    }

    public void deleteUser(String login)
    {
        userRepository.findByLogin(login);
        log.info("User: " + login + "deleted");
    }

//    public Set<User.Roles> getRoles()
//    {
//        return userRepository.findAll().stream().map(User::getRoleUsers).collect(Collectors::toSet);
//    }
}