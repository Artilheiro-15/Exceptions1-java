import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    //Nesse cod eu dei uma melhorada aki no programa principal
    //pq deleguei a logica de validaçao para a class Reservation

    //Vale resaltar ainda que ainda temos um poblema, ainda tem validaçoa
    //que esta sendo feita aki no programa principal que e na hora de estanciar o projeto
    //essa ainda nao vai ter como tirar do programa principal pq ela deveria ser uma validaçao
    //no costrutor e o construtor nao tem como eu colocar ele para retornar um string

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println("=======================");
    System.out.print("Numero do quarto: ");
    int number = sc.nextInt();
    System.out.print("Data de check-in: ");
    Date checkin = sdf.parse(sc.next());
    System.out.print("Data de check-out: ");
    Date checkout = sdf.parse(sc.next());
    System.out.println("=======================");

    if (!checkout.after(checkin)) {
      System.out.println("=======================");
      System.out.println(
        "Erro na reserva: a data de check-out deve ser posterior à data de check-in "
      );
      System.out.println("=======================");
    } else {
      System.out.println("=======================");
      Reservation reservation = new Reservation(number, checkin, checkout);
      System.out.println("reservation: " + reservation);
      System.out.println("=======================");

      System.out.println("Insira os dados para atualizar a reserva:");
      System.out.print("Data de check-in: ");
      checkin = sdf.parse(sc.next());
      System.out.print("Data de check-out: ");
      checkout = sdf.parse(sc.next());
      System.out.println("=======================");

      //Esse metodo e responsavel para atualizar as datas
      String error = reservation.updateDates(checkin, checkout);
      if (error != null) {
        System.out.println("Erro na reserva: " + error);
      } else {
        System.out.println("reservation: " + reservation);
      }
    }
    sc.close();
  }
}
