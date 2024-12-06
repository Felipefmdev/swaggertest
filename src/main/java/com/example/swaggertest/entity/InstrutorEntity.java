package com.example.swaggertest.entity;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity 
@Table(name = "instrutor") 
public class InstrutorEntity { 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "idinstrutor") 
	private Integer idinstrutor;
	
	@Column(name = "RG") 
	private Integer rg; 
	
	@Column(name = "nome") 
	private String nome; 
	
	@Column(name = "nascimento") 
	private Date nascimento; 
	
	@Column(name = "titulacao") 
	private Integer titulacao; 
	
	@OneToMany(mappedBy = "instrutor") 
	private List<TurmaEntity> turmas;

	public Integer getIdinstrutor() {
		return idinstrutor;
	}

	public void setIdinstrutor(Integer idinstrutor) {
		this.idinstrutor = idinstrutor;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(Integer titulacao) {
		this.titulacao = titulacao;
	}

	public List<TurmaEntity> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<TurmaEntity> turmas) {
		this.turmas = turmas;
	}

	
}
