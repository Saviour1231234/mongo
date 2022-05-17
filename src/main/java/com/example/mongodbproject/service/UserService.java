package com.example.mongodbproject.service;

import com.example.mongodbproject.entity.User;
import com.example.mongodbproject.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;
    MongoTemplate mongoTemplate;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(String id){
        return userRepository.findById(id);
    }

    public User findBy(String filter, String criteria){

        Query query = new Query();
        query.addCriteria(Criteria.where(criteria).is(filter));
        return mongoTemplate.findOne(query, User.class);
    }

    public List<User> findAllByCriteriaAndRemove(String filter, String criteria){

        Query query = new Query();
        query.addCriteria(Criteria.where(criteria).is(filter));
        return mongoTemplate.findAllAndRemove(query,User.class);
    }
}
