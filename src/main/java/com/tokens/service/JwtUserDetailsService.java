package com.tokens.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tokens.dao.UserDao;
import com.tokens.model.DAOUser;
import com.tokens.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	//El metodo loadUserByUsername ubica los registros del usuario en la base de datos en lugar de tomar los valores harcodeados 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/*Se comenta logica para solo guardar valores harcodeados, solo para efectos de ejemplificar y/o verificar que si esta guardando 
		* los datos en la base de datos
		
		if ("javainuse".equals(username)) {
			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}*/
		
		DAOUser user =  userDao.findByusername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado en la base de datos "+username);
		} 
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
				
	}
	
	//Metodo que salva los datos en una base de datos.
		public DAOUser save(UserDTO user) {
			DAOUser newUser = new DAOUser();
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			return userDao.save(newUser);
		}
	
}
