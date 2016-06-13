package hugomoran.com.pollingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;


public class MyDBManager {
 //----------Create instancies for each column----------------
    public static final String KEY_ROWID = "_id";
    public static final String KEY_AGE = "age";
    public static final String KEY_SEX = "sex";
    public static final String KEY_AREA = "area";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_MARITAL = "marital";
    public static final String KEY_CHILD = "children";
    public static final String KEY_WAGE = "wage_stat";
    public static final String KEY_VOTE = "voting";
    public static final String KEY_LEADER = "leader";
    public static final String KEY_PARTY = "party";
    public static final String KEY_CONCERN = "concern";
    public static final String KEY_CHOICE = "choice";

    //--------------------
    private static final String DATABASE_NAME = "Polling";
    private static final String DATABASE_TABLE = "Polling_Details";
    private static final int DATABASE_VERSION = 1;
//------------Create datebase with all required columns------------------
    private static final String DATABASE_CREATE = "create table Polling_Details " +
            "(_id integer primary key autoincrement, " +
            "age text not null, " + "sex text not null, " + "area text not null, " +
            "location text not null, " + "marital text not null, " + "children text not null, " +
            "wage_stat text not null, " + "voting text not null, " + "leader text not null, " +
            "party text not null, " + "concern text not null, " + "choice text not null);";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public MyDBManager(Context ctx) {
        //
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    //
    private static class DatabaseHelper extends SQLiteOpenHelper {

        //
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME,
                    null, DATABASE_VERSION);
        }


        @Override
        //
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
        }

        @Override

        //
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            // whatever is to be changed on dB structure

        }
    }   //


    //----db.open calls this method--------------------
    public MyDBManager open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //
    public void close() {
        DBHelper.close();
    }

    //-------inserts all the information at the end----------------------------
    public long insertPoll(String age, String sex, String area, String location, String marital, String child,
                           String wage, String vote, String leader, String party, String concern, String choice) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_AGE, age);
        initialValues.put(KEY_SEX, sex);
        initialValues.put(KEY_AREA, area);
        initialValues.put(KEY_LOCATION, location);
        initialValues.put(KEY_MARITAL, marital);
        initialValues.put(KEY_CHILD, child);
        initialValues.put(KEY_WAGE, wage);
        initialValues.put(KEY_VOTE, vote);
        initialValues.put(KEY_LEADER, leader);
        initialValues.put(KEY_PARTY, party);
        initialValues.put(KEY_CONCERN, concern);
        initialValues.put(KEY_CHOICE, choice);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //--------------when queried brings back all rows and columns---------------
    public Cursor getAllPolled() {
        return db.query(DATABASE_TABLE, new String[]{
                        KEY_ROWID,
                        KEY_AGE,
                        KEY_SEX,
                        KEY_AREA,
                        KEY_LOCATION,
                        KEY_MARITAL,
                        KEY_CHILD,
                        KEY_WAGE,
                        KEY_VOTE,
                        KEY_LEADER,
                        KEY_PARTY,
                        KEY_CONCERN,
                        KEY_CHOICE
                },
                null,
                null,
                null,
                null,
                null);
    }
//---------Queries the database for the spacivic gender wage and locatio--------------------
    public Cursor getStat(String gender, String wage, String location) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_SEX,
                                KEY_AREA,
                                KEY_LOCATION,
                                KEY_MARITAL,
                                KEY_CHILD,
                                KEY_WAGE,
                                KEY_VOTE,
                                KEY_LEADER,
                                KEY_PARTY,
                                KEY_CONCERN,
                                KEY_CHOICE

                        },
                        KEY_SEX + "=\"" + gender + "\"" + " AND " + KEY_WAGE + "=\"" + wage + "\"" + " AND " + KEY_LOCATION + "=\"" + location + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
//------------------Queries spacific wage and location---------------------
    public Cursor getWageLoc(String wage, String location) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_SEX,
                                KEY_AREA,
                                KEY_LOCATION,
                                KEY_MARITAL,
                                KEY_CHILD,
                                KEY_WAGE,
                                KEY_VOTE,
                                KEY_LEADER,
                                KEY_PARTY,
                                KEY_CONCERN,
                                KEY_CHOICE

                        },
                        KEY_WAGE + "=\"" + wage + "\"" + " AND " + KEY_LOCATION + "=\"" + location + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
//---------------Queries spacific gender and location------------------------------
    public Cursor getGenderLoc(String gender, String location) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_SEX,
                                KEY_AREA,
                                KEY_LOCATION,
                                KEY_MARITAL,
                                KEY_CHILD,
                                KEY_WAGE,
                                KEY_VOTE,
                                KEY_LEADER,
                                KEY_PARTY,
                                KEY_CONCERN,
                                KEY_CHOICE

                        },
                        KEY_SEX + "=\"" + gender + "\"" + " AND " + KEY_LOCATION + "=\"" + location + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
//-----------------Queries spacific gender and wage-----------------------------
    public Cursor getGenderPay(String gender, String wage) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_SEX,
                                KEY_AREA,
                                KEY_LOCATION,
                                KEY_MARITAL,
                                KEY_CHILD,
                                KEY_WAGE,
                                KEY_VOTE,
                                KEY_LEADER,
                                KEY_PARTY,
                                KEY_CONCERN,
                                KEY_CHOICE

                        },
                        KEY_SEX + "=\"" + gender + "\"" + " AND " + KEY_WAGE + "=\"" + wage + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
//----------------Queries spacific gender only------------------------------
    public Cursor getGender(String gender) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_SEX,
                                KEY_AREA,
                                KEY_LOCATION,
                                KEY_MARITAL,
                                KEY_CHILD,
                                KEY_WAGE,
                                KEY_VOTE,
                                KEY_LEADER,
                                KEY_PARTY,
                                KEY_CONCERN,
                                KEY_CHOICE

                        },
                        KEY_SEX + "=\"" + gender + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
//---------------Query spacific wage only------------------------
    public Cursor getWage(String wage) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_SEX,
                                KEY_AREA,
                                KEY_LOCATION,
                                KEY_MARITAL,
                                KEY_CHILD,
                                KEY_WAGE,
                                KEY_VOTE,
                                KEY_LEADER,
                                KEY_PARTY,
                                KEY_CONCERN,
                                KEY_CHOICE

                        },
                        KEY_WAGE + "=\"" + wage + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
//-----------------Query Spacific location only--------------------------
    public Cursor getLocation(String location) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_SEX,
                                KEY_AREA,
                                KEY_LOCATION,
                                KEY_MARITAL,
                                KEY_CHILD,
                                KEY_WAGE,
                                KEY_VOTE,
                                KEY_LEADER,
                                KEY_PARTY,
                                KEY_CONCERN,
                                KEY_CHOICE

                        },
                        KEY_LOCATION + "=\"" + location + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
//-----------Counts all leaders to return a count to add to precentages------------
    public Cursor getTotalVote(String leader) {
        return db.query(DATABASE_TABLE, new String[]{

                },
                KEY_LEADER + "=\"" + leader + "\"",
                null,
                null,
                null,
                null);
    }
    //-----------Counts all parties to return a count to add to precentages------------
    public Cursor getPartyVotes(String party) {
        return db.query(DATABASE_TABLE, new String[]{
                        KEY_CHOICE
                },
                KEY_PARTY + "=\"" + party + "\"",
                null,
                null,
                null,
                null);
    }
    //-----------Counts all Candidates to return a count to add to precentages------------
    public Cursor getCandidateVotes(String choice) {
        return db.query(DATABASE_TABLE, new String[]{
                        KEY_CHOICE
                },
                KEY_CHOICE + "=\"" + choice + "\"",
                null,
                null,
                null,
                null);
    }

}