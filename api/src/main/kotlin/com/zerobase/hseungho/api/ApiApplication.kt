package com.zerobase.hseungho.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(basePackages = ["com.zerobase.hseungho.domain"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}