package com.twks.ws.utilities;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utility {
    public String getRandomUserId(){
        return UUID.randomUUID().toString();
    }
}
