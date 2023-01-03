package my.bank.domain;

public enum AccountTypeParams {
    SAVING(1L, "Saving"),
    CHECKING(2L, "Checking");

    private Long id;
    private String description;

    AccountTypeParams(Long id, String description){}

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
