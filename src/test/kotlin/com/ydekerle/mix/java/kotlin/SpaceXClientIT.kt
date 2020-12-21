package com.ydekerle.mix.java.kotlin

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.ydekerle.javakotlin.SpaceXApplication
import com.ydekerle.javakotlin.SpaceXClient
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.OffsetDateTime

@SpringBootTest(classes = [SpaceXApplication::class])
@TestInstance(PER_CLASS)
internal class SpaceXClientIT {

    private val wireMockServer = WireMockServer(
        wireMockConfig()
            .bindAddress("localhost")
            .port(9000)
    )

    @BeforeAll
    private fun start() = wireMockServer.start()

    @AfterAll
    private fun stop() = wireMockServer.stop()

    @Autowired
    private lateinit var client: SpaceXClient

    @Test
    internal fun `It should successful call spaceX`() {
        // Given

        // When
        val actual = client.launches()

        // Then
        actual `should be equal to` listOf(
            buildLaunch(
                id = "5eb87cd9ffd86e000604b32a",
                name = "FalconSat",
                date = OffsetDateTime.parse("2006-03-24T22:30:00.000Z"),
                success = false
            )
        )
    }

}
