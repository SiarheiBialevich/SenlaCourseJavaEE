package ru.senla.bialevich.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Registration extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8456647581162743717L;

    private Integer id;
    private Integer guestId;
    private Integer roomId;
    private Date startDate;
    private Date finalDate;
    private Room room;
    private Guest guest;

    public Registration(Integer guestId, Integer roomId, Date startDate, Date finalDate) {
        this.guestId = guestId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.finalDate = finalDate;
    }

    public Registration() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(guestId, that.guestId) &&
                Objects.equals(roomId, that.roomId) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(finalDate, that.finalDate) &&
                Objects.equals(room, that.room) &&
                Objects.equals(guest, that.guest);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Registration{");
        sb.append("id=").append(id);
        sb.append(", guestId=").append(guestId);
        sb.append(", roomId=").append(roomId);
        sb.append(", startDate=").append(startDate);
        sb.append(", finalDate=").append(finalDate);
        sb.append(", room=").append(room);
        sb.append(", guest=").append(guest);
        sb.append('}');
        return sb.toString();
    }
}
