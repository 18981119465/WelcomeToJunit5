package com.bk.hotel.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bk.hotel.model.Room;
import com.bk.hotel.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	private RoomService roomService;

	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}

	@GetMapping("/search")
	public ResponseEntity<?> searchRooms(@RequestParam(name = "roomType", required = false) String roomType,
			@RequestParam(name = "roomFloor", required = false) String roomFloor) {
		if (roomType == null && roomFloor == null) {
			return ResponseEntity.badRequest().build();
		} else if (roomType != null && roomFloor != null) {
			return ResponseEntity.badRequest().build();
		} else {
			if (roomFloor != null) {
				return ResponseEntity.ok(roomService.findRoomsByFloor(roomFloor));
			} else {
				return ResponseEntity.ok(roomService.findRoomsByType(roomType));
			}
		}
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addNewRoom(@RequestBody Room room){
		return null;
	}
}
