package com.reactive.programming.ReactiveProgramming.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@Import(EmbeddedMongoAutoConfiguration.class)
public class DataConfig  {
   public static final String DATABASE_NAME = "reservations";

   @Bean
   public ReactiveMongoDatabaseFactory mongoDatabaseFactory(MongoClient mongoClient){
      return new SimpleReactiveMongoDatabaseFactory(mongoClient,DATABASE_NAME);
   }


   @Bean
   public ReactiveMongoOperations reactiveMongoTemplate(ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory){
      return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory);
   }
}
