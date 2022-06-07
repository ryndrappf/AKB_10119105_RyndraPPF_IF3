package ryndra.ppf.akb_10119105_ryndrappf_if3;

/**NIM : 10119105
 * Nama : Ryndra Putra Pratama Firdaus
 * Kelas: IF-3
 */
public class Catatan {
    private long id;
    private String judul;
    private String kategori;
    private String catatan;
    private String tanggal;

    public Catatan() {
    }

    public Catatan(String judul, String kategori, String catatan, String tanggal) {
        this.judul = judul;
        this.kategori = kategori;
        this.catatan = catatan;
        this.tanggal = tanggal;
    }

    public Catatan(long id, String judul, String kategori, String catatan, String tanggal) {
        this.id = id;
        this.judul = judul;
        this.kategori = kategori;
        this.catatan = catatan;
        this.tanggal = tanggal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}


