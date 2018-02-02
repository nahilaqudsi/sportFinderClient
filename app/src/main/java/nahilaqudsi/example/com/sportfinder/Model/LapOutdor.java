package nahilaqudsi.example.com.sportfinder.Model;

/**
 * Created by Nahila Khunafa on 1/25/2018.
 */

public class LapOutdor {
    public String nama;
    public String alamat;
    public String telp;
    public String keterangan;
    public String imageURL;

    public LapOutdor(){}

    public LapOutdor(String nama, String alamat, String telp, String keterangan, String imageURL) {
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.keterangan = keterangan;
        this.imageURL = imageURL;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
