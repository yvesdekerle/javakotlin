package com.ydekerle.mix.java.kotlin

import com.ydekerle.javakotlin.SpaceXClient
import com.ydekerle.javakotlin.SpaceXService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.OffsetDateTime

@ExtendWith(MockKExtension::class)
internal class SpaceXServiceTest {

    @MockK
    private lateinit var client: SpaceXClient

    @InjectMockKs
    private lateinit var spaceXService: SpaceXService

    private companion object {
        val launch1 = buildLaunch("5fd386aa7faea57d297c86c1", "Transporter-1", null, OffsetDateTime.parse("2021-01-14T00:00:00.000Z"))
        val launch2 = buildLaunch("5fb95b3f3a88ae63c954603c","Starlink-15 (v1.0)", true, OffsetDateTime.parse("2020-11-25T02:13:00.000Z"))
        val launch3 = buildLaunch("5f8399fb818d8b59f5740d43","NROL-108", true, OffsetDateTime.parse("2020-12-19T14:00:00.000Z"))
        val launch4 = buildLaunch("5eb87cdaffd86e000604b32b","DemoSat", false, OffsetDateTime.parse("2007-03-21T01:10:00.000Z"))
        val launch5 = buildLaunch("5eb87cd9ffd86e000604b32a","FalconSat", false, OffsetDateTime.parse("2006-03-24T22:30:00.000Z"))
        val launchNull = buildLaunch(null,null, null, null)

    }

    @Test
    internal fun `It should retrieve empty launch`() {
        // Given
        val filter = null

        every { client.launches() } returns emptyList()

        // When
        val expected = spaceXService.launches(filter)

        // Then
        expected `should be equal to` emptyList()
    }

    @Test
    internal fun `It should retrieve all launches`() {
        // Given
        val launches = listOf(launch1, launch2)
        val filter = null

        every { client.launches() } returns launches

        // When
        val expected = spaceXService.launches(filter)

        // Then
        expected `should be equal to` listOf(launch1, launch2)
    }

    @Test
    internal fun `It should retrieve all launches not null`() {
        // Given
        val launches = listOf(launch1, launch2, null)
        val filter = null

        every { client.launches() } returns launches

        // When
        val expected = spaceXService.launches(filter)

        // Then
        expected `should be equal to` listOf(launch1, launch2)
    }

    @Test
    internal fun `It should retrieve empty launch when no filter match`() {
        // Given
        val launches = listOf(launch1, launch2, launch3, launch4, launch5)
        val filter = "notmatched"

        every { client.launches() } returns launches

        // When
        val expected = spaceXService.launches(filter)

        // Then
        expected `should be equal to` emptyList()
    }

    @Test
    internal fun `It should retrieve all launches matched with filter`() {
        // Given
        val launches = listOf(launch1, launch2, launch3, launch4, launch5)
        val filter = "Sat"

        every { client.launches() } returns launches

        // When
        val expected = spaceXService.launches(filter)

        // Then
        expected `should be equal to` listOf(launch4, launch5)
    }

    @Test
    internal fun `It should retrieve all launches matched with filter and name not null`() {
        // Given
        val launches = listOf(launch1, launch2, launch3, launch4, launch5, launchNull)
        val filter = "Sat"

        every { client.launches() } returns launches

        // When
        val expected = spaceXService.launches(filter)

        // Then
        expected `should be equal to` listOf(launch4, launch5)
    }

}
