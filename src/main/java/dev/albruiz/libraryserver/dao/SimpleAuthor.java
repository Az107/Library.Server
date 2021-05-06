package dev.albruiz.libraryserver.dao;

import dev.albruiz.libraryserver.Model.Author;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("inMemory")
public class SimpleAuthor extends SimpleDataHelper<Author>{
}
