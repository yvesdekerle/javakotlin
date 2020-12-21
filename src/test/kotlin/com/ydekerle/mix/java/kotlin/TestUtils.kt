package com.ydekerle.mix.java.kotlin

import com.ydekerle.javakotlin.Launch
import java.time.OffsetDateTime

fun buildLaunch(id: String?, name: String?, success: Boolean?, date: OffsetDateTime?): Launch {
    val launch = Launch()
    launch.id = id
    launch.name = name
    launch.success = success
    launch.dateUtc = date
    return launch
}
