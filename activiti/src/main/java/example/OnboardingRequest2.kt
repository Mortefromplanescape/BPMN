package main.java.example

import org.activiti.engine.ProcessEngine

import org.activiti.engine.ProcessEngineConfiguration

import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration

object OnboardingRequest2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val cfg = StandaloneProcessEngineConfiguration()
            .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000")
            .setJdbcUsername("sa")
            .setJdbcPassword("")
            .setJdbcDriver("org.h2.Driver")
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
        val processEngine = cfg.buildProcessEngine()
        val pName = processEngine.name
        val ver = ProcessEngine.VERSION
        println("ProcessEngine [$pName] Version: [$ver]")
    }
}