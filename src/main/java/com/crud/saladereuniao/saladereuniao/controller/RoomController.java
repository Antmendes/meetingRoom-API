package com.crud.saladereuniao.saladereuniao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.saladereuniao.saladereuniao.exception.ResourceNotFoundException;
import com.crud.saladereuniao.saladereuniao.model.Room;
import com.crud.saladereuniao.saladereuniao.repository.RoomRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;






// @CrossOrigin permite que o front acesse

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@Api(tags = "Room Controller")
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping("/rooms")
	@ApiOperation("Find all rooms")
	public List<Room> getAllRooms(){
		return roomRepository.findAll();
	}
	
	@GetMapping("/rooms/{id}")
	@ApiOperation("Find one room")
	public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId)
		throws ResourceNotFoundException{
			Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found:: "+ roomId));
			return ResponseEntity.ok().body(room);
		}
	
	
	@PostMapping("/rooms")
	@ApiOperation("create room")
	public Room createRoom(@Valid @RequestBody Room room) {
		return roomRepository.save(room);
	}
	
	@PutMapping("/rooms/{id}")
	@ApiOperation("Update room")
	public ResponseEntity<Room> updateRoom(@PathVariable(value ="id") long roomId,
			@Valid @RequestBody Room roomDetails) throws ResourceNotFoundException{
		Room room = roomRepository.findById(roomId)
				.orElseThrow(()-> new ResourceNotFoundException("Room not found for this id:: "+roomId));
		room.setName(roomDetails.getName());
		room.setDate(roomDetails.getDate());
		room.setStartMeeting(roomDetails.getStartMeeting());
		room.setEndMeeting(roomDetails.getEndMeeting());
		final Room updateRoom = roomRepository.save(room);
		return ResponseEntity.ok(updateRoom);
	}
	
	
	@DeleteMapping("/rooms/{id}")
	@ApiOperation("Delete room")
	public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") long roomId)
	throws ResourceNotFoundException{
		Room room = roomRepository.findById(roomId)
				.orElseThrow(()-> new ResourceNotFoundException("Room not found for this id:: "+roomId));
		
		roomRepository.delete(room);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
