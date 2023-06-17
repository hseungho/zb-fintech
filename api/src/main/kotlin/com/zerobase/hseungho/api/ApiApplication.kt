package com.zerobase.hseungho.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EntityScan(basePackages = ["com.zerobase.hseungho.domain"])
@ComponentScan(basePackages = [ "com.zerobase.hseungho" ])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}