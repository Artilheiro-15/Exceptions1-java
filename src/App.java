import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.excepitions.DomainException;

public class App {

  //repare o grau de organizaçao o meu trcho de codigo inteiro nao tem um if else se quer ele e linear
  //eu foço tudo como se nao tivesse dado tudo certo se por acaso der alguma ecesao em algum lugar
  //a execuçao vai ser automaticamente cortada  e vai cai nos bloc catch fica muito mais simples assim!
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      System.out.println("=======================");
      System.out.print("Numero do quarto: ");
      int number = sc.nextInt();
      System.out.print("Data de check-in: ");
      Date checkin = sdf.parse(sc.next());
      System.out.print("Data de check-out: ");
      Date checkout = sdf.parse(sc.next());

      Reservation reservation = new Reservation(number, checkin, checkout);
      System.out.println("reservation: " + reservation);
      System.out.println("=======================");

      System.out.println("Insira os dados para atualizar a reserva:");
      System.out.print("Data de check-in: ");
      checkin = sdf.parse(sc.next());
      System.out.print("Data de check-out: ");
      checkout = sdf.parse(sc.next());
      System.out.println("=======================");

      reservation.updateDates(checkin, checkout);
      System.out.println("reservation: " + reservation);
    } catch (ParseException e) {
      System.out.println("formato de data inválido!");
    } catch (DomainException e) {
      System.out.println("erro na reserva: " + e.getMessage());
    } catch (RuntimeException e) {
      System.out.println("Erro inesperado");
    }

    sc.close();
  }
}
