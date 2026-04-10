import java.time.LocalDate;

public class Reservation {

    enum ReservationStatus{
        PENDING, CONFIRMED, CANCELLED, COMPLETED
    }

private String roomRefrence;
private String guestRefrence;
private LocalDate checkInDate;
private LocalDate checkOutDate;
  private ReservationStatus reservationStatus;

    public Reservation( String LocalDate,  LocalDate checkOutDate,  String guestRefrence,  String roomRefrence) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestRefrence = guestRefrence;
        this.roomRefrence = roomRefrence;
    }

    public Reservation() {
    }

    public ReservationStatus getReservationStatus() {
        return this.reservationStatus;
    }

    public void setReservationStatus(final ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDate getCheckInDate() {
        return this.checkInDate;
    }

    public void setCheckInDate( LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return this.checkOutDate;
    }

    public void setCheckOutDate( LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getGuestRefrence() {
        return this.guestRefrence;
    }

    public void setGuestRefrence( String guestRefrence) {
        this.guestRefrence = guestRefrence;
    }

    public String getRoomRefrence() {
        return this.roomRefrence;
    }

    public void setRoomRefrence( String roomRefrence) {
        this.roomRefrence = roomRefrence;

    }
}
