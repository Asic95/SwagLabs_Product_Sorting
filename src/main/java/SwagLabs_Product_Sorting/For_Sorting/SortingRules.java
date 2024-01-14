package SwagLabs_Product_Sorting.For_Sorting;

public enum SortingRules {
    NAME_A_TO_Z("az"),
    NAME_Z_TO_A("za"),
    PRICE_LOW_TO_HIGH("lohi"),
    PRICE_HIGH_TO_LOW("hilo");

    private String value;
    SortingRules(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
