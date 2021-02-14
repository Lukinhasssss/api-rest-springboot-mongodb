package com.lucasmonteiro.apimongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucasmonteiro.apimongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
