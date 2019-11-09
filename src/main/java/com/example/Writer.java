package com.example;

/**
 * @author Akash Deep
 * @date 11/10/2019
 **/
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Writer implements ItemWriter<Users>{

    @Autowired
    private UsersRepository repo;

    @Override
    @Transactional
    public void write(List<? extends Users> users) throws Exception {

        System.out.println(users);
        repo.saveAll(users);
    }

}
