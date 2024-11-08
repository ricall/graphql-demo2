package au.com.ricall.graphql.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest
import org.springframework.graphql.test.tester.GraphQlTester

@GraphQlTest(TutorialController::class)
class TutorialControllerTests {

    @Autowired
    private lateinit var graphQlTester: GraphQlTester

    @Test
    fun `should get first tutorial`() {
        graphQlTester.documentName("tutorials")
            .variable("id", "d7e18b34-fb46-4859-bb18-bbd597176159")
            .execute()
            .path("tutorialById")
            .matchesJson("""
            {
                "id":"d7e18b34-fb46-4859-bb18-bbd597176159",
                "title":"Tutorial one",
                "description":"Description one",
                "author":{
                    "id":"f83c5943-8be5-4945-a7b8-db5c0d432deb",
                    "name":"author one",
                    "age":27
                }
            }
            """.trimIndent())
    }
}
