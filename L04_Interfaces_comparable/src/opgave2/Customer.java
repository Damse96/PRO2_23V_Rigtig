package opgave2;

public class Customer implements Comparable<Customer> {
    private String fornavn;
    private String efternavn;

    private int alder;

    public Customer(String fornavn, String efternavn, int alder) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    @Override
    public int compareTo(Customer o) {
        int result = 0;
        if (this.efternavn.compareTo(o.getEfternavn()) == 0) {
            if (this.fornavn.compareTo(o.getFornavn()) == 0) {
                return ((Integer) this.alder).compareTo(o.getAlder());
            } else {
                return this.fornavn.compareTo(o.getFornavn());
            }
        } else {
            return this.efternavn.compareTo(o.getEfternavn());
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fornavn='" + fornavn + '\'' +
                ", efternavn='" + efternavn + '\'' +
                ", alder=" + alder +
                '}';
    }
}
