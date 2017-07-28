package com.project.uwm.mydiabitiestracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Diabetes2";
    private static final int DATABASE_VERSION = 1;

    // Control Table
    private static final String CONTROL_TABLE = "ControlTable";
    private static final String CID = "id";
    private static final String CDATE = "date";
    private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS " + CONTROL_TABLE + " (" + CID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CDATE + " REAL) ";

    // Diet table creation
    private static final String DIET_TABLE = "DietTable";
    private static final String FID = "fid";
    private static final String TYPEOFFOOD = "TypeOfFood";
    private static final String AMOUNTOFFOOD = "AmuntOfFood";
    private static final String PROTEIN = "Protein";
    private static final String CALORIES = "Calories";
    private static final String FDATE = "fDate";
    private static final String FTIME = "fTime";
    private static final String dsqlCreate = "CREATE TABLE IF NOT EXISTS " + DIET_TABLE + " (" + FID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TYPEOFFOOD + " TEXT, " + AMOUNTOFFOOD + " INTEGER," + PROTEIN + " INTEGER," + CALORIES + " INTEGER," + FDATE + " REAL," + FTIME + " REAL)";

    //Glucose table creation
    private static final String GLUCOSE_TABLE = "GlucoseTable";
    private static final String GID = "gid";

    //Prescription table creation
    private static final String PRESCRIPTON_TABLE = "PrescriptionTable";
    private static final String PID = "pid";
    private static final String DRUG_NAME = "DrugName";
    private static final String DOSE = "Dose";
    private static final String TIME_TAKEN = "TimeTaken";
    private static final String DATE_TAKEN = "DateTaken";
    private static final String psqlCreate = "CREATE TABLE IF NOT EXISTS "
            + PRESCRIPTON_TABLE + "("
            + PID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DRUG_NAME + " TEXT,"
            + DOSE + " INTEGER,"
            + TIME_TAKEN + " REAL,"
            + DATE_TAKEN + " REAL)";

    // Exercise table creation:
    private static final String EXERCISE_TABLE = "ExerciseTable";
    private static final String EID = "eid";
    private static final String EXERCISE_TYPE = "exercise_type";
    private static final String DURATION = "duration";
    private static final String TIME = "time";
    private static final String DATE = "date";
    private static final String esqlCreate = "CREATE TABLE IF NOT EXISTS "
            + EXERCISE_TABLE + "("
            + EID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EXERCISE_TYPE + " TEXT,"
            + DURATION + " INTEGER,"
            + TIME + " REAL,"
            + DATE + " REAL)";

    //User table creation
    private static final String USER_TABLE = "UserTable";
    private static final String USERID = "uid";
    private static final String USERNAME = "UserName";
    private static final String PASSWORD = "Password";
    private static final String FIRSTNAME = "FirstName";
    private static final String LASTNAME = "LastName";
    private static final String EMAIL = "Email";
    private static final String usqlCreate = "CREATE TABLE IF NOT EXISTS " + USER_TABLE + "(" + USERID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USERNAME + " VARCHAR, " + PASSWORD + " VARCHAR, " + FIRSTNAME + " VARCHAR, " + LASTNAME + " VARCHAR, " + EMAIL + " VARCHAR)";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL(dsqlCreate);
        db.execSQL(usqlCreate);
        db.execSQL(psqlCreate);
        db.execSQL(esqlCreate);
    }

    //*****************************************************************************
    // RON: WE STILL NEED TO INCORPORATE VERSION DATA
    //*****************************************************************************
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop old tables if they exist:
        db.execSQL("drop table if exists " + CONTROL_TABLE);
        db.execSQL("drop table if exists " + DIET_TABLE);
        db.execSQL("drop table if exists" + USER_TABLE);
        db.execSQL("drop table if exists" + PRESCRIPTON_TABLE);
        db.execSQL("drop table if exists" + EXERCISE_TABLE);
        // Re-create tables
        onCreate(db);
    }


    public void insertFood(FoodConsumedObject food) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + CONTROL_TABLE + "(" + CID + "," + CDATE + ") values( null, julianday('" + food.getDate() + "'))";
        db.execSQL(sqlInsert);
        String fSqlInsert = "insert into " + DIET_TABLE;
        fSqlInsert += " (" + FID + ", " + TYPEOFFOOD + ", " + AMOUNTOFFOOD + ", " + PROTEIN + ", " + CALORIES + ", " + FDATE + ", " + FTIME + ")";
        fSqlInsert += " values(null,'" + food.getTypeOfFood() + "'," + food.getAmountOfFood() + "," + food.getProtien() + "," + food.getCalories() + ",julianday('" + food.getDate() + "'),julianday('" + food.getTime() + "'))";
        db.execSQL(fSqlInsert);
        //db.close();
    }

    public void insertGlucose(GlucoseReadingObject glucose) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + CONTROL_TABLE + "(" + CID + "," + CDATE + ") values( null, julianday('" + glucose.getGdate() + "'))";
        db.execSQL(sqlInsert);
        db.close();
    }

    public void insertPrescription(PrescriptionReadingObject script) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + CONTROL_TABLE + "(" + CID + "," + CDATE + ") values( null, julianday('" + script.getDate() + "'))";
        db.execSQL(sqlInsert);
        db.close();
    }

    public void insertExercise(ExerciseReadingObject script) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + CONTROL_TABLE + "(" + CID + "," + CDATE + ") values( null, julianday('" + script.getDate() + "'))";
        db.execSQL(sqlInsert);
        db.close();
    }

    public void insertUser(UserObject uo) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + USER_TABLE + " (" + USERID + "," + USERNAME + "," + PASSWORD + "," + FIRSTNAME + "," + LASTNAME + "," + EMAIL + ") values(";
        sqlInsert += "null,'" + uo.getUserName() + "','" + uo.getPassword() + "','" + uo.getFirstName() + "','" + uo.getLastName() + "','" + uo.getEmail() + "')";
        db.execSQL(sqlInsert);
        db.close();
    }

    //All select methods
    public int selectUser(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + USER_TABLE + " where " + USERNAME + "='" + name + "'";
        Cursor cursor = db.rawQuery(query, null);
        int value = cursor.getCount();
        cursor.close();
        return value;
    }

    public int selectEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + USER_TABLE + " where " + EMAIL + "='" + email + "'";
        Cursor cursor = db.rawQuery(query, null);
        int value = cursor.getCount();
        cursor.close();
        return value;
    }

    public int verifyLogin(String userName, String passWord) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(usqlCreate);
        String query = "Select * from " + USER_TABLE + " where " + USERNAME + "='" + userName + "' and " + PASSWORD + "='" + passWord + "' ";
        Cursor cursor = db.rawQuery(query, null);
        int value = cursor.getCount();
        cursor.close();
        return value;
    }

    //All delete table
    public void deleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlDelete = "delete from " + CONTROL_TABLE;
        sqlDelete += " where " + CID + " = " + id;
        db.execSQL(sqlDelete);
        db.close();
    }

    public ArrayList<FoodConsumedObject> selectFood( ) {
        SQLiteDatabase db = this.getWritableDatabase();
        int fvalue =0 ;
        String date =" ";
        String time =" ";
        String fSqlSelect = "select *  from " + DIET_TABLE + "";
        Cursor cursor = db.rawQuery(fSqlSelect, null);
        ArrayList<FoodConsumedObject> ArrayFood = new ArrayList<FoodConsumedObject>();

        while (cursor.moveToNext()) {
            FoodConsumedObject fco = new FoodConsumedObject(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                    Integer.parseInt(cursor.getString(4)), cursor.getString(5), cursor.getString(6));
            fvalue = fco.getFood_id();
            String fSqlDate = "select date("+FDATE+"),time("+FTIME+") from " + DIET_TABLE + " where " +FID + "=" +fvalue;
            Cursor cursor1 = db.rawQuery(fSqlDate,null);
            if(cursor1.moveToNext())
                date = cursor1.getString(0);
                time = cursor1.getString(1);
            fco.setDate(date);
            fco.setTime(time);
            ArrayFood.add(fco);
        }
        db.close();
        return ArrayFood;
    }
}
