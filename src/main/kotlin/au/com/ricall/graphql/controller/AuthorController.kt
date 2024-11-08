package au.com.ricall.graphql.controller

import au.com.ricall.graphql.store.Author
import au.com.ricall.graphql.store.AuthorRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class AuthorController {
    @QueryMapping
    fun authors() = AuthorRepository.getAll()

    @QueryMapping
    fun authorById(@Argument id: String) = AuthorRepository.getById(id)

    @MutationMapping
    fun saveAuthor(@Argument id: String?, @Argument name: String, @Argument age: Int): Author {
        val author = Author(
            id = id ?: UUID.randomUUID().toString(),
            name = name,
            age = age
        )

        AuthorRepository.save(author)
        return author
    }

    @MutationMapping
    fun deleteAuthor(@Argument id: String): Author? {
        val author = AuthorRepository.getById(id)
        AuthorRepository.delete(id)

        return author
    }
}
