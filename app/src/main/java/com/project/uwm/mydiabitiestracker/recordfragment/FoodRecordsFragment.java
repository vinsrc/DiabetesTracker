package com.project.uwm.mydiabitiestracker.recordfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.project.uwm.mydiabitiestracker.DatabaseManager;
import com.project.uwm.mydiabitiestracker.EditRecords.ActivityUpdateFood;
import com.project.uwm.mydiabitiestracker.ItemClickSupport;
import com.project.uwm.mydiabitiestracker.R;
import com.project.uwm.mydiabitiestracker.adaptors.FoodAdapter;
import com.project.uwm.mydiabitiestracker.objects.FoodConsumedObject;

import java.util.ArrayList;
import java.util.List;


public class FoodRecordsFragment extends Fragment { //implements ItemClickSupport.OnItemClickListener {
    private BottomSheetDialog bottomSheetDialog;
    private OnFragmentInteractionListener mListener;
    ArrayList<FoodConsumedObject> foodList = new ArrayList<>();
    DatabaseManager dbManager;
    private RecyclerView rvFood;
    private RecyclerView.Adapter fAdaptor;
    private RecyclerView.LayoutManager fLayoutManager;
    private Switch checkSwitch;


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

        View rootView = inflater.inflate(R.layout.fragment_food_records, container, false);
        checkSwitch =(Switch) rootView.findViewById(R.id.switchSelectAllRecords) ;
        rvFood = (RecyclerView) rootView.findViewById(R.id.rvFoods);
        rvFood.setHasFixedSize(true);

        fLayoutManager = new LinearLayoutManager(getActivity());
        Context context =getActivity();
        dbManager = new DatabaseManager(context);
        rvFood.setLayoutManager(fLayoutManager);


        if(checkSwitch.isChecked()) {
            foodList = dbManager.selectAllFoodDetails();
            fAdaptor = new FoodAdapter(context, foodList);
            rvFood.setAdapter(fAdaptor);
            return rootView;
        }else{
            foodList = dbManager.selectAllFoodDetails();
            fAdaptor = new FoodAdapter(context, foodList);
            rvFood.setAdapter(fAdaptor);
            return rootView;
        }
    }
     private void showUpdateDialog(final View itemView){

     }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } /*else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

  /*  @Override
    public void onItemClicked(RecyclerView recyclerView, int position, View v) {

    }
*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
