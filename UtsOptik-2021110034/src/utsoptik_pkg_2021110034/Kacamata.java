
package utsoptik_pkg_2021110034;

public class Kacamata {
    private int productID;
    private String frame;
    private String lensa;
    private int stok;
    private int harga;

    public Kacamata(int productID, String frame, String lensa, int stok, int harga) {
        this.productID = productID;
        this.frame = frame;
        this.lensa = lensa;
        this.stok = stok;
        this.harga = harga;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getLensa() {
        return lensa;
    }

    public void setLensa(String lensa) {
        this.lensa = lensa;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    
}