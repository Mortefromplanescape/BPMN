package com.mortefromplanescape.bpmn.camunda_kotlin

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
@EnableProcessApplication
@SpringBootApplication
class CamundaKotlinApplication

fun main(args: Array<String>) {
	runApplication<CamundaKotlinApplication>(*args)
}
