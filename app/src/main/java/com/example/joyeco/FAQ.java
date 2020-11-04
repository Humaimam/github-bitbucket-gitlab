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
 * Use the {@link FAQ#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FAQ extends Fragment {
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

    public FAQ() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FAQ.
     */
    // TODO: Rename and change types and number of parameters
    public static FAQ newInstance(String param1, String param2) {
        FAQ fragment = new FAQ();
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
        View view =  inflater.inflate(R.layout.fragment_f_a_q, container, false);
        JSONArray jsonArray  =new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title","How do I get started as a Joey?");
            jsonObject.put("subtitle","Getting started is easy! Just register online and verify your account by sharing a few necessary documents with us. After you receive a verification email, simply choose the best time to meet up for a quick orientation and pick up your Joey Care Package – then you’re ready to bounce.\n" +
                    "If you’d like to know more, please join us for an information session. Just register online and sign up for the most convenient session to learn more.\n" +
                    "Please note that all qualified applicants will be required to complete a criminal background check.");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject2.put("title","Where can I work as a Joey?");
            jsonObject2.put("subtitle","Joeys currently work within the Greater Toronto Area (GTA). Our scheduling system on the Joey app allows you to choose the zone you want to work in, on a first come first serve basis. The higher your overall rating as a Joey, the greater priority your schedule gets.");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject3 = new JSONObject();
        try {
            jsonObject3.put("title","How much will I earn?");
            jsonObject3.put("subtitle","You earn on your own terms. With each and every completed order, you earn money based on the order type and distance travelled. View your earnings through your Joey account at all times. On a scheduled shift, we guarantee a minimum of $12 per hour.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject4 = new JSONObject();
        try {
            jsonObject4.put("title","How do the shifts work?");
            jsonObject4.put("subtitle","Each day is broken down into multiple shifts, so you can choose the ones that work best for you. Each shift varies between 3-6 hours:\n" +
                    "Morning shift: 9am – 3pm, 10am – 2pm\n" +
                    "Afternoon shift: 11am – 5pm, 11am – 4pm, 11am – 3pm  \n" +
                    "Evening shift: 3pm – 10pm, 4pm – 10pm, 5pm – 10pm, 6pm- 10pm, 7pm – 10pm\n" +
                    "Each shift must correlate with your chosen zone. A “Free-Run” is also available if you’d rather not be restricted by zones or time shifts. Shifts can be scheduled at any time through the Joey app.");
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

        faq_adapter listViewAdapter = new faq_adapter(getActivity(),jsonArray);
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