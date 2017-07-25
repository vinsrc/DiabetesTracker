package com.project.uwm.mydiabitiestracker;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;


public class DatabaseManager extends SQLiteOpenHelper {

    // Diabetes DB
    private static final String DATABASE_NAME = "Diabetes2";
    private static final int DATABASE_VERSION = 1;

    // Control Table
    private static final String CONTROL_TABLE = "ControlTable";
    private static final String CID = "id";
    private static final String CDATE = "date";
    private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS "+CONTROL_TABLE+" ("+CID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CDATE+" REAL) ";

    // Diet table creation
    private static final String DIET_TABLE = "DietTable";
    private static final String FID = "fid";
    private static final String TYPEOFFOOD = "TypeOfFood";
    private static final String AMOUNTOFFOOD = "AmuntOfFood";
    private static final String PROTIEN ="Protein";
    private static final String CALORIES ="Calories";
    private static final String FDATE = "fDate";
    private static final String FTIME ="fTime";
    private static final String dsqlCreate = "CREATE TABLE IF NOT EXISTS "+DIET_TABLE+" ("+FID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+TYPEOFFOOD+" TEXT, "+AMOUNTOFFOOD+ " INTEGER," + PROTIEN+ " INTEGER,"+CALORIES +" INTEGER,"+FDATE+ " REAL,"+FTIME+" REAL)";

    //Glucose table creation
    private static final String GLUCOSE_TABLE = "GlucoseTable";
    private static final String GID ="gid";

    //User table creation
    private static final String USER_TABLE = "UserTable";
    private static final String USERID ="uid";
    private static final String USERNAME ="UserName";
    private static final String PASSWORD ="Password";
    private static final String FIRSTNAME ="FirstName";
    private static final String LASTNAME ="LastName";
    private static final String EMAIL ="Email";
    private static final String usqlCreate ="CREATE TABLE IF NOT EXISTS "+USER_TABLE+"(" + USERID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+USERNAME+"  VARCHAR, "+PASSWORD+" VARCHAR, "+FIRSTNAME+" VARCHAR, "+LASTNAME+" VARCHAR, "+EMAIL+" VARCHAR)";

    public DatabaseManager( Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    public void onCreate( SQLiteDatabase db ) {
        db.execSQL(sqlCreate);
        db.execSQL(dsqlCreate);
        db.execSQL(usqlCreate);
    }
    public void onUpgrade( SQLiteDatabase db,
                           int oldVersion, int newVersion ) {
        // Drop old table if it exists
        db.execSQL( "drop table if exists " + CONTROL_TABLE);
        db.execSQL("drop table if exists " + DIET_TABLE);
        db.execSQL("drop table if exists" + USER_TABLE);
        // Re-create tables
        onCreate( db );
    }

    public void inserFood(FoodConsumedObject food ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + CONTROL_TABLE +" (" + CID + "," + CDATE +") values( null, julianday('"+food.getDate()+"'))";
        db.execSQL(sqlInsert);
        String fSqlInsert = "insert into " + DIET_TABLE;
        fSqlInsert += " (" + FID +", "+ TYPEOFFOOD+ ", "+ AMOUNTOFFOOD+ ", "+PROTIEN+", "+CALORIES+", "+FDATE+", "+FTIME+")";
        fSqlInsert += " values(null,'"+food.getTypeOfFood()+"',"+food.getAmountOfFood()+","+food.getProtien()+ ","+ food.getCalories()+ ",julianday('"+food.getDate()+"'),julianday('"+food.getTime()+"'))";
        db.execSQL(fSqlInsert);
        db.close();
    }
    public void insertGlucose( GlucoseReadingObject glucose ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + CONTROL_TABLE +" (" + CID + "," + CDATE +") values( null, julianday('"+glucose.getGdate()+"'))";
        db.execSQL(sqlInsert);
        db.close();
    }

    public void insertUser(UserObject uo){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert ="insert into "+USER_TABLE +" ("+USERID+","+USERNAME+","+PASSWORD+","+FIRSTNAME+","+LASTNAME+","+EMAIL+") values(";
        sqlInsert +="null,'"+ uo.getUserName()+"','"+uo.getPassword()+"','"+uo.getFirstName()+"','"+uo.getLastName()+"','"+uo.getEmail()+"')";
        db.execSQL(sqlInsert);
        db.close();
    }
    //All select methods
    public int selectUser(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+USER_TABLE+" where "+USERNAME+"='"+name+"'";
        Cursor cursor = db.rawQuery(query, null);
        int value = cursor.getCount();
        cursor.close();
        return value;
    }
    public int  selectEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+USER_TABLE+" where "+EMAIL+"='"+email+"'";
        Cursor cursor = db.rawQuery(query, null);
        int value = cursor.getCount();
        cursor.close();
        return value;
    }
    public int verifyLogin(String userName,String passWord){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(usqlCreate);
        String query = "Select * from "+USER_TABLE+" where "+USERNAME+"='"+userName+"' and "+PASSWORD+"='"+passWord+"' ";
        Cursor cursor = db.rawQuery(query, null);
        int value = cursor.getCount();
        cursor.close();
        return value;
    }

    //All delete table
    public void deleteById(int id ) {
        SQLiteDatabase db    = this.getWritableDatabase( );
        String sqlDelete = "delete from " + CONTROL_TABLE;
        sqlDelete += " where " + CID + " = " + id;
        db.execSQL( sqlDelete );
        db.close( );
    }

}