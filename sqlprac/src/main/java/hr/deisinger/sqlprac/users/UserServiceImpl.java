package hr.deisinger.sqlprac.users;

import hr.deisinger.sqlprac.authority.Authority;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserDTO toUserDTO(User user){
        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findFirstByUsername(username).map(this::toUserDTO);
    }
}

interface UserService{
    Optional<UserDTO> findByUsername(String username);
}