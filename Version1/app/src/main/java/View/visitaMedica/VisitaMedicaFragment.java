package View.visitaMedica;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pamela.zeballos.version1.MainActivity;
import com.pamela.zeballos.version1.R;

import java.util.Locale;

import View.usuario.DatosFisicosFragment;
import View.usuario.DatosPersonalesFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitaMedicaFragment extends Fragment {
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    private static final String ARG_SECTION_NUMBER = "section_number";


    public static VisitaMedicaFragment newInstance(int sectionNumber) {
        VisitaMedicaFragment fragment = new VisitaMedicaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    public VisitaMedicaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_visita_medica, container, false);
        mSectionsPagerAdapter = new SectionsPagerAdapter(
                getChildFragmentManager());

        mViewPager = (ViewPager) v.findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            /*Fragment fragment = new DummySectionFragment();
            Bundle args = new Bundle();
            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
            fragment.setArguments(args);*/
            //return fragment;

            //replaced with our fragments one by tab
            switch (position){
                case 0:
                    return  new MotivoConsultaFragment();
                case 1:
                    return  new ExamenesComplementariosFragment();
                case 2:
                    return  new DiagnosticoConsultaFragment();
                case 3:
                    return  new TratamientosFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            //get title from array strings as Title tab
            return getResources().getStringArray(R.array.tabs_visita_medica)[position].toUpperCase(l);

            //original
            /*
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;*/
        }
    }
}
