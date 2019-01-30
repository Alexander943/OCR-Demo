package com.mlkit.textrecognition.presentation.modules.main;

import com.mlkit.textrecognition.presentation.base.BaseViewModel;
import com.mlkit.textrecognition.presentation.utils.SchedulersFacade;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(SchedulersFacade schedulersFacade) {
        super(schedulersFacade);
    }
}
