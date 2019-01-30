package com.mlkit.textrecognition.presentation.base;

import com.mlkit.textrecognition.presentation.utils.SchedulersFacade;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    protected final SchedulersFacade schedulersFacade;
    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseViewModel(SchedulersFacade schedulersFacade) {
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
