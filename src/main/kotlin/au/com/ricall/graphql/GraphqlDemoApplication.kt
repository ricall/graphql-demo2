package au.com.ricall.graphql

import au.com.ricall.graphql.store.Author
import au.com.ricall.graphql.store.AuthorRepository
import au.com.ricall.graphql.store.Tutorial
import au.com.ricall.graphql.store.TutorialRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphqlDemoApplication: CommandLineRunner {
	private val logger = LoggerFactory.getLogger(GraphqlDemoApplication::class.java)

	override fun run(vararg args: String?) {
		val authors = listOf(
			Author(id = "f83c5943-8be5-4945-a7b8-db5c0d432deb", name = "author one", age = 27),
			Author(id = "b7512e5d-725c-4d52-80f5-39e82e0a39d6", name = "author two", age = 21),
			Author(id = "d7d213ac-03ad-4e3c-8445-13de52874407", name = "author three", age = 29),
			Author(id = "ed723eca-07bd-4e56-9553-3d7b40594df6", name = "author four", age = 28),
		)
		authors.forEach(AuthorRepository::save)

		val tutorials = listOf(
			Tutorial(
				id = "d7e18b34-fb46-4859-bb18-bbd597176159",
				title = "Tutorial one",
				description = "Description one",
				authorId = authors[0].id
			),
			Tutorial(
				id = "cc9a662e-d914-4025-8a4c-ac8fde31be25",
				title = "Tutorial two",
				description = "Description two",
				authorId = authors[1].id
			),
			Tutorial(
				id = "d1ccb6cc-ba05-4f3e-af48-33b016891612",
				title = "Tutorial three",
				description = "Description three",
				authorId = authors[2].id
			),
			Tutorial(
				id = "23941c13-ba27-45b8-82ca-707c1d844efe",
				title = "Tutorial four",
				description = "Description four",
				authorId = authors[3].id
			),
		)
		tutorials.forEach(TutorialRepository::save)

		logger.info("GraphqlDemoApplication started")
	}
}

fun main(args: Array<String>) {
	runApplication<GraphqlDemoApplication>(*args)
}

