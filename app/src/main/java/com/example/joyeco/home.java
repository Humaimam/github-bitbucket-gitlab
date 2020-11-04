package com.example.joyeco;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {
    AnimatedExpandableListView listView;
    private static int[] imgs = { R.drawable.ic_schedule_icon,R.drawable.ic_jobs_icon,R.drawable.ic_earnings_icon,
            R.drawable.ic_location_icon ,R.drawable.ic_schedule_icon,R.drawable.ic_jobs_icon,R.drawable.ic_earnings_icon,
            R.drawable.ic_location_icon ,R.drawable.ic_schedule_icon,R.drawable.ic_jobs_icon,R.drawable.ic_earnings_icon,
            R.drawable.ic_location_icon , };
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        // listView  = (AnimatedExpandableListView)findViewById(R.id.list_item);
        JSONArray jsonArray  =new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title","Schedule your own shifts!");
            jsonObject.put("subtitle","JoeyCo lets you schedule 6 hour shifts in any available zone shifts for based on your availability. Or you can just go on a Free-run. With Free-runs you can just login to your JoeyTab and start hopping.");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject2.put("title","The Joey App");
            jsonObject2.put("subtitle","The Joey App provides optimized route navigation. A complete mobile office to manage your JoeyCo Joey Account. Stay connected at all times.");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject3 = new JSONObject();
        try {
            jsonObject3.put("title","On location. On demand!");
            jsonObject3.put("subtitle","Your JoeyTab informs you of jobs based on your location whenever you need. Each job notification will provide detailed instructions for successful fulfilment. Just follow the steps and we‘ll handle the rest.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject4 = new JSONObject();
        try {
            jsonObject4.put("title","Earnings are based on dynamic pricing.");
            jsonObject4.put("subtitle","Each order depends on the type of vehicle and the amount of labour required. Each order is worth a commission. Once you successfully complete the order, your earnings are deposited instantly into your JoeyCo Account. Track you activity log on your JoeyTab.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject2);
        jsonArray.put(jsonObject3);
        jsonArray.put(jsonObject4);
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject2);
        jsonArray.put(jsonObject3);
        jsonArray.put(jsonObject4);
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject2);
        jsonArray.put(jsonObject3);
        jsonArray.put(jsonObject4);

        listViewAdapter listViewAdapter = new listViewAdapter(getActivity(),jsonArray,imgs);
        listView = (AnimatedExpandableListView)view.findViewById(R.id.contactMirrorList);
        listView.setAdapter(listViewAdapter);
        if(listView!=null)
            listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                int previousGroup=-1;
                @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                    if (listView.isGroupExpanded(groupPosition)) {
                        listView.collapseGroupWithAnimation(groupPosition);
                        previousGroup=-1;
                    } else {
                        listView.expandGroupWithAnimation(groupPosition);
                        if(previousGroup!=-1){
                            listView.collapseGroupWithAnimation(previousGroup);
                        }
                        previousGroup=groupPosition;
                    }

                    return true;
                }
            });

        return view;
    }
}