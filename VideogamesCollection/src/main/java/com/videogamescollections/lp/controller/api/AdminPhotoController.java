package com.videogamescollections.lp.controller.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.videogamescollections.lp.model.Photo;
import com.videogamescollections.lp.service.InterfacciaPhotoService;

@RestController
public class AdminPhotoController {

	@Autowired
	@Qualifier("mainPhotoService")
	private InterfacciaPhotoService photoService;

	public AdminPhotoController() {

	}

	@GetMapping("/admin/api/photos")
	public Iterable<Photo> getAll() {
		return photoService.getAll();
	}

	@GetMapping("/admin/api/photos/{id}")
	public Photo getById(@PathVariable int id) {

		Optional<Photo> photo = photoService.getById(id);

		if (!photo.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}

		return photo.get();
	}

	@PostMapping(value = "/admin/api/photos")
	public Photo create(@Valid @RequestBody Photo photo) {

		return photoService.create(photo);
	}

	@PutMapping(value = "/admin/api/photos/{id}")
	public Photo update(@PathVariable int id, @Valid @RequestBody Photo photo) {

		Optional<Photo> updatedPhoto = photoService.update(id, photo);

		if (!updatedPhoto.isPresent()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}

		return updatedPhoto.get();
	}

	@DeleteMapping(value = "/admin/api/photos/{id}")
	public void delete(@PathVariable int id) {
		Boolean isDeleted = photoService.delete(id);
		if (Boolean.FALSE.equals(isDeleted)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
	}
}
