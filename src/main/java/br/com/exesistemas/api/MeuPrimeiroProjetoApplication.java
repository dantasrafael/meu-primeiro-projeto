package br.com.exesistemas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.exesistemas.api.entities.Empresa;
import br.com.exesistemas.api.repositories.EmpresaRepository;
import br.com.exesistemas.api.services.ExemploService;
import br.com.exesistemas.api.utils.SenhaUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ExemploService exemploService;	
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("### Quantidade de registros por página = " + this.qtdPorPagina);
			
			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded = " + senhaEncoded);
			
			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded 2 = " + senhaEncoded);
			
			System.out.println("Senha valida = " + SenhaUtils.senhaValida("123456", senhaEncoded));
			
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Empresa de TI");
			empresa.setCnpj("01.123.432/0001-00");
			
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = this.empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Empresa empresaDb = this.empresaRepository.findOne(1L);
			System.out.println("Empresa por Id = " + empresaDb);
						
			empresaDb.setRazaoSocial("TI Corp");
			this.empresaRepository.save(empresaDb);
			
			Empresa empresaCnpj = this.empresaRepository.findByCnpj("01.123.432/0001-00");
			System.out.println("Empresa por Cnpj = " + empresaCnpj);
			
			this.empresaRepository.delete(1L);
			empresas = this.empresaRepository.findAll();
			System.out.println("Empresas = " + empresas.size());
			
			this.exemploService.testarServico();
		};
	}
}
