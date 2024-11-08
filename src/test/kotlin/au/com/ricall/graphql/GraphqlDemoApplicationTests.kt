package au.com.ricall.graphql

import au.com.ricall.graphql.controller.AuthorController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GraphqlDemoApplicationTests(@Autowired private val controller: AuthorController) {

	@Test
	fun contextLoads() {
		assert(controller.authors().size == 4)
	}

}
