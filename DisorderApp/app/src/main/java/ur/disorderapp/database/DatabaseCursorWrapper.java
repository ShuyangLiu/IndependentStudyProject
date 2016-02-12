package ur.disorderapp.database;


import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;

import ur.disorderapp.EnumValues.Feeling;
import ur.disorderapp.EnumValues.Location;
import ur.disorderapp.EnumValues.Situation;
import ur.disorderapp.EnumValues.TimePeriod;
import ur.disorderapp.model.Goal;
import ur.disorderapp.EnumValues.GoalStatus;
import ur.disorderapp.model.SelfAssessmentData;

public class DatabaseCursorWrapper extends CursorWrapper
{
    public DatabaseCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public Goal getGoal()
    {
        int progress = getInt(getColumnIndex(Schema.GoalTable.Cols.PROGRESS));
        GoalStatus status = GoalStatus.valueOf(
                getString(
                        getColumnIndex(
                                Schema.GoalTable.Cols.STATUS)));

        String name = getString(getColumnIndex(Schema.GoalTable.Cols.NAME));

        return new Goal(progress, status, name);
    }

    public SelfAssessmentData getSelfAssessmentData()
    {
        String food = getString(getColumnIndex(Schema.HabitTable.Cols.FOOD));

        int amount = getInt(getColumnIndex(Schema.HabitTable.Cols.AMOUNT));

        TimePeriod time = TimePeriod.valueOf(
                getString(
                        getColumnIndex(
                                Schema.HabitTable.Cols.TIME)));

        Location location = Location.valueOf(
                getString(
                        getColumnIndex(
                                Schema.HabitTable.Cols.LOCATION)));

        Situation situation = Situation.valueOf(
                getString(
                        getColumnIndex(
                                Schema.HabitTable.Cols.SITUATION)));

        Feeling feeling = Feeling.valueOf(
                getString(
                    getColumnIndex(
                            Schema.HabitTable.Cols.FEELING)));

        Date date = new Date(getLong(getColumnIndex(Schema.HabitTable.Cols.DATE)));

        return new SelfAssessmentData(food,amount,time,location,situation,feeling,date);
    }







}
