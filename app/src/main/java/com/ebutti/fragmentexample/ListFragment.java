package com.ebutti.fragmentexample;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends android.support.v4.app.ListFragment {

    ItemSelected activity;

    public interface ItemSelected {
        void itemSelected(int index);
    }

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] data = getResources().getStringArray(R.array.pieces);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));


        //Phone is in landscape mode
        if (this.getActivity().findViewById(R.id.layout_landscape) != null) {
            // To show the detail of first Item
            activity.itemSelected(0);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        activity.itemSelected(position);
    }
}
