package com.dun.droid_app.io.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dun.droid_app.io.models.boredapi.BoredModel;
import com.dun.droid_app.io.repo.BoredRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class BoredViewModel extends ViewModel {
    private static final String TAG = "BoredViewModel";
    private BoredRepo boredRepo;

    private MutableLiveData<BoredModel> boredModel = new MutableLiveData<>();
    private MutableLiveData<Boolean> isError = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    @Inject
    public BoredViewModel(BoredRepo boredRepo){
        this.boredRepo = boredRepo;
    }

    private static void accept(Object result) {

    }

    public MutableLiveData<BoredModel> getBoredModel() {
        return boredModel;
    }
    public MutableLiveData<Boolean> getError() {
        return isError;
    }
    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }


    public void getBoredActivity() {
        boredRepo.getBoredActivity().enqueue(new Callback<BoredModel>() {
            @Override
            public void onResponse(Call<BoredModel> call, Response<BoredModel> response) {

                boredModel.setValue(response.body());
                isError.setValue(false);
                errorMessage.setValue("SUCCESS");
            }

            @Override
            public void onFailure(Call<BoredModel> call, Throwable t) {
                errorMessage.setValue(t.getMessage());
                Log.e("ms_error",t.getMessage());
                isError.setValue(true);

            }
        });

    }
}
