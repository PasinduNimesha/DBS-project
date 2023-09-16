package com.Jupiter.hrm.service;
import com.Jupiter.hrm.entity.User;
import com.Jupiter.hrm.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    private ModelMapper modelMapper;

    public User createUser(User user){return userRepository.save(user);}

    public List<User> getAllUsers(){return  userRepository.findAll();}

    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(updatedUser.getUsername());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
            return true;
        }
        else{
            return false;
        }
    }

    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null){
            return null;
        }
        else{
            return user;
        }
    }
}
