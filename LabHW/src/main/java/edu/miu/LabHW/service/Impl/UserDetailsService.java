package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepo userRepo;

    public UserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByEmail(username);
        var userDetails = new edu.miu.LabHW.service.Impl.UserDetails(user);
        return userDetails;
    }

}
