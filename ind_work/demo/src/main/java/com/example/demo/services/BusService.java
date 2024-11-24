package com.example.demo.services;

import com.example.demo.models.entities.Bus;
import com.example.demo.repositories.BusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BusService {

    private BusRepository busRepository;

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Optional<Bus> getBusById(Long id) {
        return busRepository.findById(id);
    }

    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Optional<Bus> updateBus(Long id, Bus busDetails) {
        return busRepository.findById(id).map(existingBus -> {
            existingBus.setRegistrationNumber(busDetails.getRegistrationNumber());
            existingBus.setModel(busDetails.getModel());
            existingBus.setCapacity(busDetails.getCapacity());
            existingBus.setStatus(busDetails.getStatus());
            return busRepository.save(existingBus);
        });
    }

    public boolean deleteBus(Long id) {
        if (busRepository.existsById(id)) {
            busRepository.deleteById(id);
            return true;
        }
        return false;
    }
}