package com.getaf.tfar.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getaf.tfar.converter.UserConverter;
import com.getaf.tfar.domain.dto.UserDto;
import com.getaf.tfar.domain.entity.Departement;
import com.getaf.tfar.domain.entity.Organisme;
import com.getaf.tfar.domain.entity.User;
import com.getaf.tfar.exception.ResourceNotFoundException;
import com.getaf.tfar.repository.DepartementRepository;
import com.getaf.tfar.repository.OrganismeRepository;
import com.getaf.tfar.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;


	@Autowired
	private UserConverter userConverter;

	@Autowired
	private DepartementRepository depRepository;

	@Autowired
	private OrganismeRepository orgRepository;

	public List<User> listAll() {
		return userRepository.findAll();	
	}
	public User save(UserDto userDto) throws ResourceNotFoundException {
		Long codeOrg = userDto.getCodeOrganisme();
		List<Organisme> organismes = orgRepository.findAll();
		Organisme x = organismes.stream().filter(h -> h.getCode().equals(codeOrg)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The organisme is not found.");
		}

		Long codeDep = userDto.getCodeDepartement();
		List<Departement> departements = depRepository.findAll();
		Departement y = departements.stream().filter(h -> h.getCode().equals(codeDep)).findAny().orElse(null);
		if (y == null) {
			throw new ResourceNotFoundException("The departement is not found.");
		}

		User user = userConverter.dtoToEntity(userDto);
		userRepository.save(user);
		return user;
	}

	public User get(long id) {
		return userRepository.findById(id).get();
	}

	public void delete(long id) {
		userRepository.deleteById(id);
	}

	/*public User update(User user) throws ValidationException {
		Long codeOrg = user.getOrganisme().getCode();
		List<Organisme> organismes = orgRepository.findAll();
		Organisme x = organismes.stream().filter(h -> h.getCode().equals(codeOrg)).findAny().orElse(null);
		if (x == null) {
			throw new ValidationException("The organisme is not found.");
		}
		Long codedep = user.getDepartement().getCode();
		List<Departement> departements = depRepository.findAll();
		Departement y = departements.stream().filter(h -> h.getCode().equals(codedep)).findAny().orElse(null);
		if (y == null) {
			throw new ValidationException("The departement is not found.");
		}
		userRepository.save(user);
		return user;
	}*/


}