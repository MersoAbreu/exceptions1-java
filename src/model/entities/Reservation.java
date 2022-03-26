package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer numeroQuarto;
	
	private Date entrada;
	
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer numeroQuarto, Date entrada, Date saida) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}


	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long diferenca = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date dataEntrada, Date dataSaida) {
		this.entrada = dataEntrada;
		this.saida = dataSaida;
		this.duracao();
		
	}
	
	@Override
	public String toString() {
		return "Quarto"
				+numeroQuarto
				+", Data entrada: "
				+sdf.format(entrada)
				+", Data de saída:  "
				+sdf.format(saida)
				+", duração de estadia: "
				+duracao()
				+" noites";
	}
}
