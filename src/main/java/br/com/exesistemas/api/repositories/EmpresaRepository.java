package br.com.exesistemas.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exesistemas.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Empresa findByCnpj(String cnpj);
	
}