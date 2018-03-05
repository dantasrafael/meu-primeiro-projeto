package br.com.exesistemas.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exesistemas.api.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findByCpf(String cpf);
	
}