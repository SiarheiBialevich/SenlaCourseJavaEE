package ru.senla.bialevich.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "registration")
public class Registration extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8456647581162743717L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "fk_guest_id")
    private Integer guestId;

    @Column(name = "fk_room_id")
    private Integer roomId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "final_date")
    private Date finalDate;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(id, that.id);
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
        sb.append('}');
        return sb.toString();
    }
}
