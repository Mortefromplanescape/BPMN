package com.mortefromplanescape.bpmn.camunda_kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CamundaKotlinApplication

fun main(args: Array<String>) {
	runApplication<CamundaKotlinApplication>(*args)
}
