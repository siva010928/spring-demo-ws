package com.twks.ws.services;

import com.twks.ws.ui.model.requests.UpdateUserDetailsRequest;
import com.twks.ws.ui.model.requests.UserDetailsRequest;
import com.twks.ws.ui.model.responses.UserRest;

import java.util.List;

public interface UserService {
    List<UserRest> getUsers(int page, int limit, String sort);
    UserRest getUser(String userId);
    UserRest createUser(UserDetailsRequest userBody);
    UserRest updateUser(String userId, UpdateUserDetailsRequest userBody);
    void deleteUser(String userId);
}
