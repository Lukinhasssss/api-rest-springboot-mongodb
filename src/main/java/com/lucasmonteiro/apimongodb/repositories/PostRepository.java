package com.lucasmonteiro.apimongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucasmonteiro.apimongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
