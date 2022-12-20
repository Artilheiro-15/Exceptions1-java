import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
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

      Date now = new Date();

      if (checkin.before(now) || checkout.before(now)) {
        System.out.println(
          "Erro na reserva: As datas da reserva Para atualizar devem ser datas futuras!"
        );
      } else if (!checkout.after(checkin)) {
        System.out.println(
          "Erro na reserva: a data de check-out deve ser posterior à data de check-in "
        );
      } else {
        //Esse metodo e responsavel para atualizar as datas
        reservation.updateDates(checkin, checkout);
        System.out.println("reservation: " + reservation);
      }
    }
    sc.close();
  }
}
