package com.example.demo.controller

import com.example.demo.entity.Sensor
import com.example.demo.service.SensorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sensor")
class SensorController {
    @Autowired
    lateinit var sensorService: SensorService

    @GetMapping
    fun list(): List<Sensor> {
        return sensorService.list()
    }

    @PostMapping
    fun save(@RequestBody sensor: Sensor): Sensor {
        return sensorService.save(sensor)
    }

    @PutMapping
    fun update(@RequestBody sensor: Sensor): ResponseEntity<Sensor> {
        return ResponseEntity(sensorService.update(sensor), HttpStatus.OK)
    }

    @PatchMapping
    fun patch(@RequestBody sensor: Sensor): ResponseEntity<Sensor> {
        val updatedSensor = sensorService.updateName(sensor)
        return if (updatedSensor != null) {
            ResponseEntity(updatedSensor, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
