package uz.iraimjanov.lazycolumn.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.iraimjanov.lazycolumn.data.repository.MyRepository
import uz.iraimjanov.lazycolumn.model.ContactRequest
import uz.iraimjanov.lazycolumn.model.ContactResponse
import uz.iraimjanov.lazycolumn.model.MyResponse
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {

    fun getAllContact() {
        viewModelScope.launch {
            getResponse = repository.getAllContact()
        }
    }

    fun addContact(
        contactRequest: ContactRequest,
    ) {
        viewModelScope.launch {
            audMyResponse.value = repository.addContact(contactRequest)
        }
    }

    fun updateContact(
        contactResponse: ContactResponse,
    ) {
        viewModelScope.launch {
            audMyResponse.value = repository.updateContacts(contactResponse)
        }
    }

    fun deleteContact(id: Int) {
        viewModelScope.launch {
            audMyResponse.value = repository.deleteContacts(id)
        }
    }

    var getResponse: List<ContactResponse> by mutableStateOf(listOf())
    var audMyResponse = MutableLiveData<MyResponse>()
}