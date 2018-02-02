package nahilaqudsi.example.com.sportfinder.Model;

/**
 * Created by Nahila Khunafa on 1/23/2018.
 */

public class LapIndor {
    public String nama;
    public String alamat;
    public String telp;
    public String keterangan;
    public String imageURL;

    public LapIndor() {
    }

//    public LapIndor() {
//        super();
//    }

    public LapIndor(String nama, String alamat, String telp, String keterangan, String imageURL) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LapIndor other = (LapIndor) obj;
        if (nama != other.nama)
            return false;
        return true;
    }
}
