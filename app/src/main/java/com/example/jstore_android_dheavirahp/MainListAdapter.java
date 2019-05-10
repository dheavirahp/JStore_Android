package com.example.jstore_android_dheavirahp;

import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;

public class MainListAdapter extends BaseExpandableListAdapter {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ArrayList<Supplier> listDataHeader;
    HashMap<Supplier, ArrayList<Item>> listDataChild;

}
