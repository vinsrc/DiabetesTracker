package com.project.uwm.mydiabitiestracker.recordfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.uwm.mydiabitiestracker.DatabaseManager;
import com.project.uwm.mydiabitiestracker.R;
import com.project.uwm.mydiabitiestracker.adaptors.FoodAdapter;
import com.project.uwm.mydiabitiestracker.objects.FoodConsumedObject;

import java.util.ArrayList;


public class FoodRecordsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    ArrayList<FoodConsumedObject> foodList = new ArrayList<>();
    DatabaseManager dbManager;
    private RecyclerView rvFood;
    private RecyclerView.Adapter fAdaptor;
    private RecyclerView.LayoutManager fLayoutManager;


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
        rvFood = (RecyclerView) rootView.findViewById(R.id.rvFoods);
        rvFood.setHasFixedSize(true);
        fLayoutManager = new LinearLayoutManager(getActivity());
        Context context =getActivity();
        dbManager  = new DatabaseManager(context);
        rvFood.setLayoutManager(fLayoutManager);
        foodList = dbManager.selectAllFoodDetails();
        fAdaptor = new FoodAdapter(context, foodList);
        rvFood.setAdapter(fAdaptor);
        return rootView;
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
