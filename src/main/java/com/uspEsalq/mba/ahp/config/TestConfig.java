package com.uspEsalq.mba.ahp.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.uspEsalq.mba.ahp.entities.Acoes;
import com.uspEsalq.mba.ahp.entities.Ativos;
import com.uspEsalq.mba.ahp.entities.Carteira;
import com.uspEsalq.mba.ahp.entities.DashBoard;
import com.uspEsalq.mba.ahp.entities.Ahp; 
import com.uspEsalq.mba.ahp.repositories.AcoesRepository;
import com.uspEsalq.mba.ahp.repositories.AhpRepository;
import com.uspEsalq.mba.ahp.repositories.AtivoRepository;
import com.uspEsalq.mba.ahp.repositories.CarteirasRepository;
import com.uspEsalq.mba.ahp.repositories.DashBoardRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {
	
	
	@Autowired
	AtivoRepository ativoRepository;

	@Autowired
	AcoesRepository acoesRepository;
	
	@Autowired
	AhpRepository ahpRepository;
	
	@Autowired
	CarteirasRepository carteiraRepository ;
	
	@Autowired
	DashBoardRepository dashBoardRepository;
		
	private String Path = "C:\\Wanderlei\\estudos\\UspEsalq\\Acadêmico\\Data Sciency\\17-AHP\\Elaboração do Projeto do TCC\\TCC\\Projeto R\\bovespa.csv";	
	private static List<Ativos> list = new ArrayList<Ativos>();
	
	// Ler a relação de Ações
	
	private String Path_Rel = "C:\\Wanderlei\\estudos\\UspEsalq\\Acadêmico\\Data Sciency\\17-AHP\\Elaboração do Projeto do TCC\\TCC\\Projeto R\\Acoes pesquisadas para estudo.txt";	
	private ArrayList<Acoes> rel = new ArrayList<Acoes>();
	

	private String Path_Ahp = "C:\\Wanderlei\\estudos\\UspEsalq\\Acadêmico\\Data Sciency\\17-AHP\\Elaboração do Projeto do TCC\\TCC\\Projeto R\\ahp.csv";	
	private ArrayList<Ahp> aHp = new ArrayList<Ahp>();
	
	
	private String Path_carteira = "C:\\Wanderlei\\estudos\\UspEsalq\\Acadêmico\\Data Sciency\\17-AHP\\Elaboração do Projeto do TCC\\TCC\\Projeto R\\carteira.csv";	
	private static List<Carteira> cart = new ArrayList<Carteira>();
	
	
	private String Path_dashboard = "C:\\Wanderlei\\estudos\\UspEsalq\\Acadêmico\\Data Sciency\\17-AHP\\Elaboração do Projeto do TCC\\TCC\\Projeto R\\dashboard.csv";	
	private static List<DashBoard> dash = new ArrayList<DashBoard>();

	
	
	public TestConfig() {	
	}
	public void run(String... args) throws Exception {
	
		importar();  // Importa Serie de cotaçãoes de ativos
		importar_carteira(); // Importar carteiras de investimentos
//		importar_dashBoard(); // Importa Estatísticas atuais da Serie temporal em uso
//		relacao_Acoes() ; //Importa as ações pesquisadas

	} 
	
	private void importar() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(Path))) {
			
			String line = br.readLine();
			line = br.readLine();
			Long id = 0L;
			
			while (line != null) {

				String[] coluna = line.split(",");
				String atv = coluna[1].substring(1,coluna[1].length()-1);
				String atv2 = atv.substring(0,atv.length());
				atv = atv2.trim();
				Long Id_Segmento = 0L;
				Long Id_Empresa = 0L;
				
				String data = coluna[2];
				
				DateTimeFormatter DATE_FORMAT =
					    new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd").toFormatter();

				LocalDate Data = LocalDate.parse(data,DATE_FORMAT );			
				Double  Abertura = Double.parseDouble(coluna[3]);
				Double  Maxima = Double.parseDouble(coluna[4]);
				Double  Minima = Double.parseDouble(coluna[5]);
				Double  Fechamento = Double.parseDouble(coluna[6]);
				Double  Volume = Double.parseDouble(coluna[7]);
				Double  Preco_ajustado = Double.parseDouble(coluna[8]);
				Double  Maxima_Anterior = Double.parseDouble(coluna[9]);
				Double  Minima_Anterior = Double.parseDouble(coluna[10]);
				Double  Compra = 0.0 ;
				Double  Venda = 0.0 ;
				Double  Resultados = Double.parseDouble(coluna[13]); ;			

				Ativos ativo = new Ativos(id,atv, Id_Segmento, Id_Empresa, Data, Abertura, Maxima, Minima,Fechamento,Volume,Preco_ajustado,
										  Maxima_Anterior,Minima_Anterior,Compra,Venda,Resultados);
				
				list.add(ativo);
				
				line = br.readLine();
			}	
			
			for (Ativos p : list) {
				ativoRepository.saveAll(Arrays.asList(p));
			}

		    Path path = Paths.get(Path);  
            // delete File
		    br.close();
		    if (Files.exists(path)) {
		    	Files.delete(path);
		    }
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private void importar_carteira() {
		
		// Importação da entidade carteira
		
		try (BufferedReader br = new BufferedReader(new FileReader(Path_carteira))) {
			
			String line = br.readLine();
			line = br.readLine();
			Long id = 0L;
			
			while (line != null) {

				System.out.println(line);				
				
				String[] coluna = line.split(",");
				String ticket = coluna[1].substring(1,coluna[1].length()-1);
				String ticket2 = ticket.substring(0,ticket.length());
				ticket = ticket2.trim();
				Double  valor = Double.parseDouble(coluna[2]);
				Integer qtd_acoes = Integer.parseInt(coluna[3]);
				Double  valor_Venda = Double.parseDouble(coluna[4]);
				Double  total_inv = Double.parseDouble(coluna[5]);
				Double  rentabilidade = Double.parseDouble(coluna[6]);
				Double  risco = Double.parseDouble(coluna[7]);
				Double  volatilidade = Double.parseDouble(coluna[8]);
				Double  liquidez = Double.parseDouble(coluna[9]);
				
				Carteira carteira = new Carteira(id, ticket, valor, qtd_acoes, valor_Venda, total_inv,rentabilidade,risco,volatilidade,liquidez);
				
				cart.add(carteira);
				
				line = br.readLine();
			}	
			
			for (Carteira c : cart) {
				carteiraRepository.saveAll(Arrays.asList(c));
			}

		    Path path = Paths.get(Path_carteira);  
            // delete File
		    br.close();
		    if (Files.exists(path)) {
		    	Files.delete(path);
		    }
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	
	private void importar_dashBoard() {
		
		// Importação da entidade carteira
		
		try (BufferedReader br = new BufferedReader(new FileReader(Path_dashboard))) {
			
			String line = br.readLine();
			line = br.readLine();
			Long id = 0L;
			
			while (line != null) {

				System.out.println(line);				
				
				String[] coluna = line.split(",");
				
				String DataMenorCotacao = coluna[2];			
				String DataMaiorCotacao = coluna[3];
				String Ticket_Min  = coluna[4];
				String Ticket_Max  = coluna[5];
				Double price_openMin = Double.parseDouble(coluna[6]) ;
				Double price_openMed = Double.parseDouble(coluna[7]) ; 
				Double price_openMax = Double.parseDouble(coluna[8]) ;
				Double price_highMin = Double.parseDouble(coluna[9]) ;
				Double price_highMed = Double.parseDouble(coluna[10]) ;
				Double price_highMax = Double.parseDouble(coluna[11]) ;
				Double price_lowMin  = Double.parseDouble(coluna[12]) ;
				Double price_lowMed  = Double.parseDouble(coluna[13]) ;
				Double price_lowMax  = Double.parseDouble(coluna[14]) ;
				Double price_closeMin = Double.parseDouble(coluna[15]) ;
				Double price_closeMed = Double.parseDouble(coluna[16]) ;
				Double price_closeMax = Double.parseDouble(coluna[17]) ;
				Double price_VolumeMin = Double.parseDouble(coluna[18]) ;
				Double price_VolumeMed = Double.parseDouble(coluna[19]) ;
				Double price_VolumeMax = Double.parseDouble(coluna[20]) ;
				Double price_adjustedMin = Double.parseDouble(coluna[21]) ;
				Double price_adjustedMed = Double.parseDouble(coluna[22]) ;
				
				DashBoard dashBoard = new DashBoard(
						id,
						DataMenorCotacao, 
						DataMaiorCotacao, 
						Ticket_Min, 
						Ticket_Max, 
						price_openMin,
						price_openMed,
						price_openMax,
						price_highMin,
						price_highMed,
						price_highMax,
						price_lowMin,
						price_lowMed,
						price_lowMax,
						price_closeMin,
						price_closeMed,
						price_closeMax,
						price_VolumeMin,
						price_VolumeMed,
						price_VolumeMax,
						price_adjustedMin,
						price_adjustedMed,0.00);
				
				dash.add(dashBoard);
				
				line = br.readLine();
			}	
			
			for (Carteira c : cart) {
				carteiraRepository.saveAll(Arrays.asList(c));
			}

		    Path path = Paths.get(Path_carteira);  
            // delete File
		    br.close();
		    if (Files.exists(path)) {
		    	Files.delete(path);
		    }
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	
	private void relacao_Acoes() {

		try (BufferedReader br = new BufferedReader(new FileReader(Path_Rel))) {
			
			String line = br.readLine();
			line = br.readLine();
			Long id = 0L;
			
			while (line != null) {


				String acao = line;
				Long Id_Segmento = 0L;
				Long Id_Empresa = 0L;

				Acoes acoes = new Acoes(id, acao, Id_Empresa, Id_Segmento);
				
				rel.add(acoes);
				
				line = br.readLine();
			}	
			
			for (Acoes a : rel) {
				acoesRepository.saveAll(Arrays.asList(a));
			}
			
			Path path = Paths.get(Path);  
            // delete File
		    br.close();
		    if (Files.exists(path)) {
		    	Files.delete(path);
		    }
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private void importar_Ahp() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(Path_Ahp))) {
			
			String line = br.readLine();
			line = br.readLine();
			Long id = 0L;
			
			while (line != null) {
				
				String[] coluna = line.split(",");
				String atv = coluna[1].substring(1,coluna[1].length()-1);
				String atv2 = atv.substring(0,atv.length());
				
				atv = atv2.trim();
				
				Long Id_Segmento = 0L;
				Long Id_Empresa = 0L;
				
				String data = coluna[2];
				
				DateTimeFormatter DATE_FORMAT =
					    new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd").toFormatter();

				LocalDate Data = LocalDate.parse(data,DATE_FORMAT );			
				Double  Abertura = Double.parseDouble(coluna[3]);
				Double  Maxima = Double.parseDouble(coluna[4]);
				Double  Minima = Double.parseDouble(coluna[5]);
				Double  Fechamento = Double.parseDouble(coluna[6]);
				LocalDate  DataCompra = LocalDate.parse(coluna[7]);
				Double  Cotacao = Double.parseDouble(coluna[8]);
				Integer qtdAcoes = Integer.parseInt(coluna[9]);
				Double  TotInvest= Double.parseDouble(coluna[10]);	
				Double  CotacaoAtual = 0.00;
				Double  ValorAtual = 0.00;	
				Double  Rentabilidade = Double.parseDouble(coluna[13]); 
				Double  Risco = Double.parseDouble(coluna[14]);
				Double  Liquidez = Double.parseDouble(coluna[15]);
				Double  Volatilidade = Double.parseDouble(coluna[16]);
				
				Ahp ahp = new Ahp(id, atv, Data, Id_Segmento, Id_Empresa, Abertura, Maxima, Minima, Fechamento,
				             	  DataCompra, Cotacao, qtdAcoes, TotInvest, CotacaoAtual,
						          ValorAtual, Rentabilidade, Risco, Liquidez, Volatilidade);
				
				aHp.add(ahp);
				
				line = br.readLine();
			}	
			
			for (Ahp ap : aHp) {
				ahpRepository.saveAll(Arrays.asList(ap));
			}

		    Path path = Paths.get(Path_Ahp);  
            // delete File
		    br.close();
		    if (Files.exists(path)) {
		    	Files.delete(path);
		    }
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
