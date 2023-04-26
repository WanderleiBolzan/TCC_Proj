package com.uspEsalq.mba.ahp.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.uspEsalq.mba.ahp.entities.Ativos;
import com.uspEsalq.mba.ahp.entities.Carteira;
import com.uspEsalq.mba.ahp.entities.CarteiraItem;
import com.uspEsalq.mba.ahp.entities.Empresas;
import com.uspEsalq.mba.ahp.entities.User;
import com.uspEsalq.mba.ahp.entities.enums.CarteiraStatus;
import com.uspEsalq.mba.ahp.repositories.AtivosRepository;
import com.uspEsalq.mba.ahp.repositories.CarteiraItemRepository;
import com.uspEsalq.mba.ahp.repositories.CarteirasRepository;
import com.uspEsalq.mba.ahp.repositories.EmpresasRepository;
import com.uspEsalq.mba.ahp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AtivosRepository ativosRepository;
	
	@Autowired
	private CarteirasRepository carteirasRepository;
	
	
	@Autowired
	private CarteiraItemRepository carteiraItemRepository;
	
	@Autowired
	private EmpresasRepository empresasRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Empresas cat1 = new Empresas(1L,1L,"Petrobras");
		Empresas cat2 = new Empresas(2L,2L,"Vale do Rio Doce");
		Empresas cat3 = new Empresas(3L,3L,"Embraer SA");
		
		Ativos p1 = new Ativos(1L,"PTR3",1L,1L,95.50);
		Ativos p2 = new Ativos(2L,"VLR4",2L,2L,25.50);
		Ativos p3 = new Ativos(3L,"EMB3",3L,3L,112.80);
		
		empresasRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		ativosRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		p1.getEmpresas().add(cat2);
		p2.getEmpresas().add(cat1);
		p2.getEmpresas().add(cat3);
		p3.getEmpresas().add(cat3);
		
		ativosRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "MODERADO","123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777","CONSERVADOR","123456");
		
		Carteira o1 = new Carteira(1L, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T19:53:07Z"), CarteiraStatus.MODERADO, u1);
		Carteira o2 = new Carteira(2L, Instant.parse("2019-07-21T03:42:10Z"), Instant.parse("2019-06-20T19:53:07Z"), CarteiraStatus.CONSERVADOR, u2);
		Carteira o3 = new Carteira(3L, Instant.parse("2019-07-22T15:21:22Z"), Instant.parse("2019-06-20T19:53:07Z"), CarteiraStatus.AGRESSIVO, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		carteirasRepository.saveAll(Arrays.asList(o1, o2, o3));
		CarteiraItem oi1 = new CarteiraItem(); 
		CarteiraItem oi2 = new CarteiraItem();
		CarteiraItem oi3 = new CarteiraItem();
		CarteiraItem oi4 = new CarteiraItem();
		
		//carteiraItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));	
		

		carteirasRepository.save(o1);
	}
}
