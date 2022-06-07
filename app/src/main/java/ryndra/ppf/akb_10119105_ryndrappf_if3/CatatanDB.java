package ryndra.ppf.akb_10119105_ryndrappf_if3;
/**NIM : 10119105
 * Nama : Ryndra Putra Pratama Firdaus
 * Kelas: IF-3
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class CatatanDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "dbcatatan";
    private static final String DATABASE_TABLE = "tbl_catatan";

    private static final String KEY_ID = "id";
    private static final String KEY_JUDUL = "judul";
    private static final String KEY_KATEGORI = "kategori";
    private static final String KEY_CATATAN = "catatan";
    private static final String KEY_TANGGAL = "tanggal";

    public CatatanDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+ DATABASE_TABLE + "("+ KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                KEY_JUDUL + " TEXT,"+
                KEY_KATEGORI + " TEXT,"+
                KEY_CATATAN + " TEXT,"+
                KEY_TANGGAL + " TEXT"+")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i >= i1)
            return;

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE );
        onCreate(sqLiteDatabase);
    }

    public long addCatatan(Catatan catatan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_JUDUL, catatan.getJudul());
        values.put(KEY_KATEGORI, catatan.getKategori());
        values.put(KEY_CATATAN, catatan.getCatatan());
        values.put(KEY_TANGGAL, catatan.getTanggal());

        long id = db.insert(DATABASE_TABLE, null, values);

        return id;
    }

    public Catatan getCatatan(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] query = new String[]{KEY_ID, KEY_JUDUL, KEY_KATEGORI, KEY_CATATAN, KEY_TANGGAL};
        Cursor cursor = db.query(DATABASE_TABLE, query, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        return new Catatan(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                cursor.getString(4));

    }

    public List<Catatan> getNotes(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Catatan> catatanList = new ArrayList<>();

        String query = "SELECT * FROM " + DATABASE_TABLE + "ORDER BY" + KEY_ID + "DESC";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor. moveToFirst()){
            do{
                Catatan catatan = new Catatan();
                catatan.setId(cursor.getLong(0));
                catatan.setJudul(cursor.getString(1));
                catatan.setKategori(cursor.getString(2));
                catatan.setTanggal(cursor.getString(3));

                catatanList.add(catatan);

            }while (cursor.moveToNext());
        }
        return catatanList;
    }

    public int editCatatan(Catatan catatan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_JUDUL, catatan.getCatatan());
        values.put(KEY_KATEGORI, catatan.getKategori());
        values.put(KEY_CATATAN, catatan.getCatatan());
        values.put(KEY_TANGGAL, catatan.getTanggal());

        return db.update(DATABASE_TABLE, values, KEY_ID + "=?", new String[]{String.valueOf(catatan.getId())});
    }

    void deleteCatatan(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, KEY_ID+ "=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
