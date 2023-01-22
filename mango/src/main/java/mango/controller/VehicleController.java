package mango.controller;

import mango.dto.LocationDTO;
import mango.dto.VehicleDTO;
import mango.mapper.LocationDTOMapper;
import mango.model.Location;
import mango.model.Vehicle;
import mango.service.VehicleService;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService service;

    @PreAuthorize("hasAuthority(\"ROLE_DRIVER\")")
    @PutMapping("/{id}/location")
    public ResponseEntity updateLocation(@RequestBody LocationDTO locationDTO, @PathVariable Integer id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Vehicle vehicle = service.findOne(id);
        if (vehicle == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle does not exist!");
        }

        LocationDTOMapper mapper = new LocationDTOMapper(new ModelMapper());
        Location location = mapper.fromDTOtoLocation(locationDTO);
        service.insertNewLocation(location);
        vehicle.setCurrentLocation(location);

        service.save(vehicle);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Coordinates successfully updated");
    }
}
