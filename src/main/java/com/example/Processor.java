package com.example;

/**
 * @author Akash Deep
 * @date 11/10/2019
 **/
import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Users, Users> {

    @Autowired
    private UsersRepository userRepo;

    @Override
    public Users process(Users user) throws Exception {
        Optional<Users> userFromDb = userRepo.findById(user.getUserId());
        if(userFromDb.isPresent()) {
            user.setAccount(user.getAccount().add(userFromDb.get().getAccount()));
        }
        return user;
    }

}