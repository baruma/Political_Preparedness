package com.example.android.politicalpreparedness

import android.app.Application
import com.example.android.politicalpreparedness.database.ElectionDatabase
import com.example.android.politicalpreparedness.database.ElectionsRepository
import com.example.android.politicalpreparedness.election.ElectionsViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

class PPApp: Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@PPApp)
            modules(mainModule)
        }
    }

    val mainModule = module {
        viewModel { ElectionsViewModel(get()) }
        single { ElectionsRepository(get()) }
        single { ElectionDatabase.getInstance(this@PPApp) }
//        single { AlarmScheduler(applicationContext, get()) }
    }
}