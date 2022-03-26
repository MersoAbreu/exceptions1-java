package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Project {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o numero do quarto");
		int numero = sc.nextInt();
		System.out.println("Digite a data de entrada");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.println("Digite a data de saida");
		Date dataSaida = sdf.parse(sc.next());

		if (!dataSaida.after(dataEntrada)) {
			System.out.println("Erro data de saida tem que ser após a data de entrada");
		} else {
			Reservation reservation = new Reservation(numero, dataEntrada, dataSaida);
			System.out.println("Reserva:" + reservation);
			System.out.println("Entre com os dados para atualizar a reserva");
			System.out.println("Digite a data de entrada");
			dataEntrada = sdf.parse(sc.next());
			System.out.println("Digite a data de saida");
			dataSaida = sdf.parse(sc.next());

			Date dataAgora = new Date();

			if (dataEntrada.before(dataAgora) || dataSaida.before(dataAgora)) {
				System.out.println("Erro na reserva, as datas de reserva necessita ser datas futuras!");
			} else if (!dataSaida.after(dataEntrada)) {
				System.out.println("Erro data de saida tem que ser após a data de entrada");
			}else {

				reservation.updateDates(dataEntrada, dataSaida);

				System.out.println("Reserva atualizada:" + reservation);
			}
			

		}

		sc.close();
	}
}
