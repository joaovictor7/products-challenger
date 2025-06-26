package com.productschallenge.core.data.workmanager

interface WorkManager {
    fun enqueuePeriodicWork(workManagerRequest: WorkManagerRequest.PeriodicWorkManagerRequest)

    fun enqueueOneTimeWork(workManagerRequest: WorkManagerRequest.OneTimeWorkManagerRequest)
}