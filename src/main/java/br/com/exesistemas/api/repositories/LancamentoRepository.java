package br.com.exesistemas.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exesistemas.api.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}