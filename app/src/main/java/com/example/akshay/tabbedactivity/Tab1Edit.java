package com.example.akshay.tabbedactivity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class Tab1Edit extends Fragment {
    public interface OnFragmentInteractionListener{
        public void onFragmentInteraction(Uri uri);
    }
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1edit, container, false);

        return rootView;
    }

}
