package technocite.be.takemymoney.api.dto;

public class OweDto {

    private String id;
    private String useroweId;
    private String userBorrowId;
    private Double price;

    public OweDto(String id, String useroweId, String userBorrowId, Double price) {
        this.id = id;
        this.useroweId = useroweId;
        this.userBorrowId = userBorrowId;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }
}
