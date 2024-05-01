package com.example.demo.service

import com.example.demo.entity.Sensor
import com.example.demo.repository.SensorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SensorService {

    @Autowired
    lateinit var sensorRepository: SensorRepository

    fun list(): List<Sensor> {
        return sensorRepository.findAll()
    }

    fun save(sensor: Sensor): Sensor {
        return sensorRepository.save(sensor)
    }

    fun update(sensor: Sensor): Sensor {
        try {
            sensorRepository.findById(sensor.id)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sensor no encontrado con ID: ${sensor.id}")
            return sensorRepository.save(sensor)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar el sensor", ex)
        }
    }

    fun updateName(sensor: Sensor): Sensor? {
        try {
            val existingSensor = sensorRepository.findById(sensor.id)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sensor no encontrado con ID: ${sensor.id}")

            existingSensor.apply {
                sensorName = sensor.sensorName
            }

            return sensorRepository.save(existingSensor)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar el nombre del sensor", ex)
        }
    }
}


