package technocite.be.takemymoney.model;

import java.util.Objects;

public class OweMoney {
    private String id;
    private String useroweId;
    private String userBorrowId;
    private Double price;


    public OweMoney(String id, String userOwe, String userBorrowId, Double price) {
        this.id = id;
        this.useroweId = userOwe;
        this.userBorrowId = userBorrowId;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getUseroweId() {
        return useroweId;
    }

    public String getUserBorrowId() {
        return userBorrowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OweMoney)) return false;
        OweMoney oweMoney = (OweMoney) o;
        return id.equals(oweMoney.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
