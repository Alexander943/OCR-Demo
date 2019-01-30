package com.mlkit.textrecognition.presentation.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {

    protected final String TAG = BaseFragment.class.getSimpleName();

    protected abstract int getFragmentLayout();

    protected abstract boolean isLaunchLoading();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
        setHasOptionsMenu(true);
    }

    public void setActionBarTitle(String title) {
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setTitle(title);
    }

    protected void setDisplayHomeAsUpEnabled(@NonNull Boolean displayHomeAsUpEnabled) {
        final Activity activity = getActivity();
        if (!(activity instanceof BaseActivity)) return;
        ((BaseActivity) activity).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
    }

    protected FragmentManager getNavigationFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    protected void hideSoftKeyboard(@Nullable View view) {
        if (view == null) return;
        final InputMethodManager imm = (InputMethodManager)
                view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void injectViews(final View view) {
        ButterKnife.bind(this, view);
    }

    protected void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int resId) {
        Toast.makeText(getContext(), resId, Toast.LENGTH_SHORT).show();
    }
}
