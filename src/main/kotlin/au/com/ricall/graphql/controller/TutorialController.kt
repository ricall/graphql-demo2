package au.com.ricall.graphql.controller

import au.com.ricall.graphql.store.AuthorRepository
import au.com.ricall.graphql.store.Tutorial
import au.com.ricall.graphql.store.TutorialRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class TutorialController {
    @QueryMapping
    fun tutorials() = TutorialRepository.getAll()

    @QueryMapping
    fun tutorialById(@Argument id: String) = TutorialRepository.getById(id)

    @MutationMapping
    fun saveTutorial(
        @Argument id: String?,
        @Argument title: String,
        @Argument description: String,
        @Argument authorId: String
    ): Tutorial {
        val tutorial = Tutorial(
            id = id ?: UUID.randomUUID().toString(),
            title = title,
            description = description,
            authorId = authorId,
        )
        TutorialRepository.save(tutorial)
        return tutorial
    }

    @MutationMapping
    fun deleteTutorial(@Argument id: String): Tutorial? {
        val tutorial = TutorialRepository.getById(id)
        TutorialRepository.delete(id)

        return tutorial
    }

    @SchemaMapping
    fun author(tutorial: Tutorial) = AuthorRepository.getById(tutorial.authorId)
}
