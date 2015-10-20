/**
 * Ejemplo de Navigation Drawer personalizado y Fragment con SwipeTabs
 *
 * Elaborado por Felipe Lima afelipelc@gmail.com marzo.2015
 * Basado en el ejemplo http://androideity.com/2013/12/16/android-navigation-drawer-parte-1/ -Nav Drawer-
 * y en http://www.paulusworld.com/technical/android-navigationdrawer-sliding-tabs -Tabs-
 *
 * El trabajo realizado consistio en unificar una aplicacion con estas caracteristicas ya que regularmente encontramos ejemplos con una sola caracteristica
 *
 */
package com.pamela.zeballos.version1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by felipe on 4/03/15.
 */
public class PrincipalFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static PrincipalFragment newInstance(int sectionNumber) {
        PrincipalFragment fragment = new PrincipalFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PrincipalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}