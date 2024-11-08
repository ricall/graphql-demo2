package au.com.ricall.graphql.store

import graphql.com.google.common.collect.ImmutableList

data class Author(val id: String, val name: String, val age: Int)

object AuthorRepository {
    private val authors = mutableListOf<Author>()

    fun save(author: Author) {
        delete(author.id)
        authors.add(author)
    }

    fun delete(id: String) {
        authors.removeIf { it.id == id }
    }

    fun getById(id: String) = authors.firstOrNull { it.id == id }
    fun getAll() = ImmutableList.copyOf(authors)
}

