package com.twks.ws.serviceImplementations;

import com.twks.ws.exceptions.UserNotFoundException;
import com.twks.ws.services.UserService;
import com.twks.ws.ui.model.requests.UpdateUserDetailsRequest;
import com.twks.ws.ui.model.requests.UserDetailsRequest;
import com.twks.ws.ui.model.responses.UserRest;
import com.twks.ws.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utility utility;

    public UserServiceImpl() {
        this.users = new HashMap<>();
    }

    @Autowired
    public UserServiceImpl(Utility utility) {
        this.users = new HashMap<>();
        this.utility = utility;
    }


    @Override
    public List<UserRest> getUsers(int page, int limit, String sort) {
        return new ArrayList<>(users.values());
    }

    @Override
    public UserRest getUser(String userId) {
        if (!users.containsKey(userId)){
            throw new UserNotFoundException("User with ID: " + userId + " not found");
        }
        return users.get(userId);
    }

    @Override
    public UserRest createUser(UserDetailsRequest userBody) {
        UserRest user = new UserRest();
        user.setEmail(userBody.getEmail());
        user.setFirstName(userBody.getFirstName());
        user.setLastName(userBody.getLastName());
        String userId = utility.getRandomUserId();
        user.setUserId(userId);
        users.put(userId, user);
        return user;
    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetailsRequest userBody) {
        if (!users.containsKey(userId)){
            throw new UserNotFoundException("User with ID: " + userId + " not found");
        }
        UserRest user = users.get(userId);
        user.setFirstName(userBody.getFirstName());
        user.setLastName(userBody.getLastName());
        users.put(userId, user);
        return user;
    }

    @Override
    public void deleteUser(String userId) {
        if (!users.containsKey(userId)){
            throw new UserNotFoundException("User with ID: " + userId + " not found");
        }
        users.remove(userId);
    }
}
