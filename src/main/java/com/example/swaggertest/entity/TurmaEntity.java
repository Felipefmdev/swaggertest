package com.example.swaggertest.entity;

import java.sql.Time;
import java.util.Date;
import jakarta.persistence.*;

@Entity 
@Table(name = "turma") 
public class TurmaEntity { 
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "idturma") 
	private Integer idturma;
	
	@Column(name = "horario") 
	private Time horario;
	
	@Column(name = "duracao") 
	private Integer duracao;
	
	@Column(name = "datainicio")
	private Date datainicio; 
	
	@Column(name = "dataFim")
	private Date dataFim; 
	
	@ManyToOne 
	@JoinColumn(name = "idinstrutor") 
	private InstrutorEntity instrutor;

	public Integer getIdturma() {
		return idturma;
	}

	public void setIdturma(Integer idturma) {
		this.idturma = idturma;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public InstrutorEntity getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(InstrutorEntity instrutor) {
		this.instrutor = instrutor;
	}

	
	
}