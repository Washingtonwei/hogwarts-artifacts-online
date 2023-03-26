package edu.tcu.cs.hogwartsartifactsonline.hogwartsuser;

import edu.tcu.cs.hogwartsartifactsonline.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<HogwartsUser> findAll() {
        return this.userRepository.findAll();
    }

    public HogwartsUser findById(Integer userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException("user", userId));
    }

    public HogwartsUser save(HogwartsUser newHogwartsUser) {
        // We NEED to encode plain text password before saving to the DB! TODO
        newHogwartsUser.setPassword(this.passwordEncoder.encode(newHogwartsUser.getPassword()));
        return this.userRepository.save(newHogwartsUser);
    }

    /**
     * We are not using this update to change user password.
     *
     * @param userId
     * @param update
     * @return
     */
    public HogwartsUser update(Integer userId, HogwartsUser update) {
        HogwartsUser oldHogwartsUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException("user", userId));
        oldHogwartsUser.setUsername(update.getUsername());
        oldHogwartsUser.setEnabled(update.isEnabled());
        oldHogwartsUser.setRoles(update.getRoles());
        return this.userRepository.save(oldHogwartsUser);
    }

    public void delete(Integer userId) {
        this.userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException("user", userId));
        this.userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username) // First, we need to find this user from database.
                .map(hogwartsUser -> new MyUserPrincipal(hogwartsUser)) // If found, wrap the returned user instance in a MyUserPrincipal instance.
                .orElseThrow(() -> new UsernameNotFoundException("username " + username + " is not found.")); // Otherwise, throw an exception.
    }

}
