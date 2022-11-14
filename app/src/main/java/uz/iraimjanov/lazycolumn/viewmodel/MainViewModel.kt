package uz.iraimjanov.lazycolumn.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uz.iraimjanov.lazycolumn.data.repository.MyRepository
import uz.iraimjanov.lazycolumn.model.ContactRequest
import uz.iraimjanov.lazycolumn.model.ContactResponse
import uz.iraimjanov.lazycolumn.model.MyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {

    fun getAllContact() {
        viewModelScope.launch {
            _getResponse.clear()
            _getResponse.addAll(repository.getAllContact())
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

    private val _getResponse = mutableStateListOf<ContactResponse>()
    var getResponse: List<ContactResponse> = _getResponse
    private var audMyResponse = MutableLiveData<MyResponse>()
}