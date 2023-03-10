package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.excepitions.DomainException;

public class Reservation {

  private Integer roomNumber;
  private Date checkin;
  private Date checkout;

  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  public Reservation() {}

  public Reservation(Integer roomNumber, Date checkin, Date checkout)
    throws DomainException {
    if (!checkout.after(checkin)) {
      throw new DomainException(
        "A data de check-out deve ser posterior à data de check-in"
      );
    }
    this.roomNumber = roomNumber;
    this.checkin = checkin;
    this.checkout = checkout;
  }

  public Integer getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
  }

  public Date getCheckin() {
    return checkin;
  }

  public void setCheckin(Date checkin) {
    this.checkin = checkin;
  }

  public Date getCheckout() {
    return checkout;
  }

  public void setCheckout(Date checkout) {
    this.checkout = checkout;
  }

  //Assim que vou calcular a duraçao em dias com base nas duas datas "checkout e checkin"
  public long duration() {
    long diff = checkout.getTime() - checkin.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }

  public void updateDates(Date checkin, Date checkOut) throws DomainException {
    Date now = new Date();
    if (checkin.before(now) || checkout.before(now)) {
      throw new DomainException(
        "Erro na reserva: As datas da reserva Para atualizar devem ser datas futuras!"
      );
    }
    if (!checkOut.after(checkin)) {
      throw new DomainException(
        "A data de check-out deve ser posterior à data de check-in"
      );
    }
    this.checkin = checkin;
    this.checkout = checkOut;
  }

  @Override
  public String toString() {
    return (
      "Quarto " +
      roomNumber +
      ", check-in: " +
      sdf.format(checkin) +
      ", check-out:" +
      ", " +
      duration() +
      " Noites"
    );
  }
}
