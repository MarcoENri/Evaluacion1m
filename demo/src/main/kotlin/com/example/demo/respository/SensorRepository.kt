package com.example.demo.repository

import com.example.demo.entity.Sensor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SensorRepository : JpaRepository<Sensor, Long> {
    fun findById(id: Long?): Sensor?
}
