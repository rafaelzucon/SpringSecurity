package com.api.pcj18sb273.services;

import com.api.pcj18sb273.configs.security.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl serviceImpl;

    @Test
    public void loadUserByUsernameTest() throws UsernameNotFoundException {
        UserDetails usermodel = serviceImpl.loadUserByUsername("asdrubal");
        assertEquals("adrubal",usermodel.getUsername());
    }

}
