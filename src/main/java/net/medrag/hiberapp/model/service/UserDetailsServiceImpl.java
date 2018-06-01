//package net.medrag.hiberapp.model.service;
//
//import net.medrag.hiberapp.model.dao.UserDao;
//import net.medrag.hiberapp.model.domain.Role;
//import net.medrag.hiberapp.model.domain.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private UserDao userDao;
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.getUserByName(username);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        Role role = user.getAdmin() ? Role.ROLE_ADMIN : Role.ROLE_USER;
//        grantedAuthorities.add(new SimpleGrantedAuthority(role.toString()));
//        return new org.springframework.security.core.userdetails.User
//                (user.getUsername(), user.getPassword(), grantedAuthorities);
//    }
//}
