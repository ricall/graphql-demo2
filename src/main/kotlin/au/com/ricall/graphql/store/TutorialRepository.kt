package au.com.ricall.graphql.store

import graphql.com.google.common.collect.ImmutableList

data class Tutorial(val id: String, val title: String, val description: String, val authorId: String)

object TutorialRepository {
    private val tutorials = mutableListOf<Tutorial>()

    fun save(tutorial: Tutorial) {
        delete(tutorial.id)
        tutorials.add(tutorial)
    }

    fun delete(id: String) = tutorials.removeIf { it.id == id }

    fun getById(id: String) = tutorials.firstOrNull { it.id == id }

    fun getAll(): List<Tutorial> = ImmutableList.copyOf(tutorials)
}
