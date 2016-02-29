package views.usuario;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.HomeFragment;
import com.pamela.zeballos.version1.R;

import butterknife.Bind;
import butterknife.OnClick;
import utils.FragmentCustomAdapter;
import butterknife.ButterKnife;
import utils.NumberFragment;
import utils.TypeFaceFont;

/**
 * Created by Pamela on 12/29/15.
 */
public class DatosFisicoFragment extends Fragment{
    FragmentCustomAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Bind(R.id.btn_anadir)
    Button btnAnadir;

    public DatosFisicoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datos_fisicos, container, false);
        ButterKnife.bind(this, view);
        TypeFaceFont.setFontawesome(getActivity(), btnAnadir);
        return view;
    }

    @OnClick(R.id.btn_anadir)
    public void onAnadir(){
    showFragmentTwo();
    }

    public void showFragmentTwo(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.VISIBLE);
    }


}




