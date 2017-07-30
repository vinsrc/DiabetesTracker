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
import android.widget.Switch;

import com.project.uwm.mydiabitiestracker.DatabaseManager;
import com.project.uwm.mydiabitiestracker.R;
import com.project.uwm.mydiabitiestracker.adaptors.GlucoseAdapter;
import com.project.uwm.mydiabitiestracker.objects.GlucoseReadingObject;

import java.util.ArrayList;


public class GlucoseRecordsFragment extends Fragment {
    //private BottomSheetDialog bottomSheetDialog;
    private OnFragmentInteractionListener gmListener;
    ArrayList<GlucoseReadingObject> glucoseList = new ArrayList<>();
    DatabaseManager dbManager;
    private RecyclerView rvGlucose;
    private RecyclerView.Adapter gAdaptor;
    private RecyclerView.LayoutManager gLayoutManager;
    private Switch checkSwitch;

    private OnFragmentInteractionListener mListener;

    public GlucoseRecordsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_glucose_records, container, false);
        checkSwitch =(Switch) rootView.findViewById(R.id.gswitchSelectAllRecords) ;
        rvGlucose = (RecyclerView) rootView.findViewById(R.id.recycleViewGlucose);
        rvGlucose.setHasFixedSize(true);
      /*  final ItemClickSupport itemClick = ItemClickSupport.addTo(rvFood);
        itemClick.setOnItemClickListener(this);*/
        gLayoutManager = new LinearLayoutManager(getActivity());
        Context context =getActivity();
        dbManager = new DatabaseManager(context);
        rvGlucose.setLayoutManager(gLayoutManager);

        if(checkSwitch.isChecked()) {
            glucoseList = dbManager.selectAllGlucoseDetails();
            gAdaptor = new GlucoseAdapter(context, glucoseList);
            rvGlucose.setAdapter(gAdaptor);
            return rootView;
        }
        glucoseList = dbManager.selectAllGlucoseDetails();
        gAdaptor = new GlucoseAdapter(context, glucoseList);
        rvGlucose.setAdapter(gAdaptor);
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
