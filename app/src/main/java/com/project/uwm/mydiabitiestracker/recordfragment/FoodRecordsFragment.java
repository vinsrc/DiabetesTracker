package com.project.uwm.mydiabitiestracker.RecordFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import com.project.uwm.mydiabitiestracker.Adapters.FoodAdapter;
import com.project.uwm.mydiabitiestracker.DatabaseManager;
import com.project.uwm.mydiabitiestracker.Objects.FoodConsumedObject;
import com.project.uwm.mydiabitiestracker.Objects.UserPreference;
import com.project.uwm.mydiabitiestracker.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;


public class FoodRecordsFragment extends Fragment  {
    private BottomSheetDialog bottomSheetDialog;
    private OnFragmentInteractionListener mListener;

    ArrayList<FoodConsumedObject> foodList = new ArrayList<>();
    DatabaseManager dbManager;
    private RecyclerView rvFood;
    private RecyclerView.Adapter fAdaptor;
    private RecyclerView.LayoutManager fLayoutManager;
    private Switch checkSwitch;
    private CheckBox weekChkBox;
    private CheckBox dayChkBox;
    String userName;
    UserPreference pref;
    public EditText editTextFromDate,editTextToDate,editTextFromTime,editTextToTime;
    private int day;
    private int month;
    private int year, hour,minute;


    public FoodRecordsFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        editTextFromDate =(EditText) getActivity().findViewById(R.id.editTextFromDate);
        editTextToDate =(EditText) getActivity().findViewById(R.id.editTextToDate);
        editTextFromTime =(EditText) getActivity().findViewById(R.id.editTextFromTime);
        editTextToTime =(EditText)getActivity().findViewById(R.id.editTextToTime);

        View rootView = inflater.inflate(R.layout.fragment_food_records, container, false);
        rvFood = (RecyclerView) rootView.findViewById(R.id.rvFoods);
        rvFood.setHasFixedSize(true);
        checkSwitch =(Switch) getActivity().findViewById(R.id.switchSelectAllRecords);
        weekChkBox =(CheckBox) getActivity().findViewById(R.id.cbWeek);
        dayChkBox =(CheckBox) getActivity().findViewById(R.id.cbDay);


        fLayoutManager = new LinearLayoutManager(getActivity());
        Context context =getActivity();
        dbManager = new DatabaseManager(context);
        userName = pref.getUserName();
        final DatePickerDialog.OnDateSetListener from_dateListener,to_dateListener;
        final TimePickerDialog.OnTimeSetListener from_timeListener,to_timeListener;
        from_timeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hr, int min) {
                hour = hr;
                minute = min ;
                updateDisplayFromTime();
            }
        };
        to_timeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hr, int min) {
                hour = hr;
                minute = min ;
                updateDisplayToTime();
            }
        };
        from_dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yr, int mnth, int monthday) {
                year =yr;
                month = mnth;
                day = monthday;
                updateFromDisplay();
            }
        };
        to_dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yr, int mnth, int monthday) {
                year =yr;
                month = mnth;
                day = monthday;
                updateToDisplay();
            }
        };

        editTextFromDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calender = Calendar.getInstance(TimeZone.getDefault());
                DatePickerDialog dialog = new DatePickerDialog(getActivity(),from_dateListener,calender.get(calender.YEAR),calender.get(Calendar.MONTH),calender.get(Calendar.DAY_OF_MONTH));
                dialog.show();
                                  }
                              });
        editTextToDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calender = Calendar.getInstance(TimeZone.getDefault());
                DatePickerDialog dialog = new DatePickerDialog(getActivity(),to_dateListener,calender.get(calender.YEAR),calender.get(Calendar.MONTH),calender.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
        editTextToTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calender = Calendar.getInstance(TimeZone.getDefault());
                TimePickerDialog dialog = new TimePickerDialog(getActivity(),to_timeListener,calender.get(calender.HOUR),calender.get(Calendar.MINUTE),true);
                dialog.show();
            }
        });
        editTextFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calender = Calendar.getInstance(TimeZone.getDefault());
                TimePickerDialog dialog = new TimePickerDialog(getActivity(),from_timeListener,calender.get(calender.HOUR),calender.get(Calendar.MINUTE),true);
                dialog.show();
            }
        });
        rvFood.setLayoutManager(fLayoutManager);
        checkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton button,boolean isChecked){
                if(isChecked){
                    dayChkBox.setChecked(false);
                    weekChkBox.setChecked(false);
                    foodList = dbManager.selectAllFoodDetails(userName);
                    fAdaptor = new FoodAdapter(getActivity(), foodList);
                    rvFood.setAdapter(fAdaptor);
                }
            }
        });
        weekChkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isEnabled()) {
                    checkSwitch.setChecked(false);
                    dayChkBox.setChecked(false);
                    foodList = dbManager.selectWeekFoodDetails(userName);
                    fAdaptor = new FoodAdapter(getActivity(), foodList);
                    rvFood.setAdapter(fAdaptor);
                }
            }
        });
        dayChkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(view.isEnabled()) {
                checkSwitch.setChecked(false);
                weekChkBox.setChecked(false);
                foodList = dbManager.selectOneDayFoodDetails(userName);
                fAdaptor = new FoodAdapter(getActivity(), foodList);
                rvFood.setAdapter(fAdaptor);
            }
            }
        });
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void updateFromDisplay(){
        editTextFromDate.setText(new StringBuilder().append(year).append("-").append(month).append("-").append(day));
    }
    private void updateToDisplay(){
        editTextToDate.setText(new StringBuilder().append(year).append("-").append(month).append("-").append(day));
    }
    private void updateDisplayToTime(){
        editTextToTime.setText(new StringBuilder().append(hour).append(":").append(minute));
    }

    private void updateDisplayFromTime(){
        editTextFromTime.setText(new StringBuilder().append(hour).append(":").append(minute));
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
