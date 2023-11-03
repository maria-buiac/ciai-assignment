package com.ciai.assignment

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class AssignmentApplicationTests(
) {

	@Autowired
	lateinit var mockMvc: MockMvc

	@Test
	@Sql(value = ["insert-apartment-data.sql"], executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	fun `hey hey`() {
		mockMvc.get("/apartments")
			.andExpect { status { isOk() } }
			.andExpect { content { string("blabla") } }
	}

}
