package com.mlkit.textrecognition.presentation.modules.main

import com.mlkit.textrecognition.presentation.base.BaseViewModel
import com.mlkit.textrecognition.presentation.utils.SchedulersFacade

import javax.inject.Inject

class MainViewModel @Inject
constructor(schedulersFacade: SchedulersFacade) : BaseViewModel(schedulersFacade)
