/**
 * @author DubinosTeck
 * Emmanuel Asinyo
 * Brahim Kanouche
 */

package com.dubinosTech.shoppinglistManager.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dubinosTech.shoppinglistManager.R;

public class InvalidFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_invalid, container, false);
    }
}
