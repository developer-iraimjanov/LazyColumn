package uz.iraimjanov.lazycolumn.data.repository

import uz.iraimjanov.lazycolumn.data.remote.MyApi
import uz.iraimjanov.lazycolumn.model.ContactRequest
import uz.iraimjanov.lazycolumn.model.ContactResponse
import uz.iraimjanov.lazycolumn.model.MyResponse
import javax.inject.Inject

class MyRepositoryImp @Inject constructor(private val api: MyApi) : MyRepository {

    override suspend fun getAllContact(): List<ContactResponse> = api.getAllContact().body()!!

    override suspend fun addContact(contactRequest: ContactRequest): MyResponse =
        api.addContact(contactRequest).body()!!

    override suspend fun updateContacts(contactResponse: ContactResponse): MyResponse =
        api.updateContact(contactResponse).body()!!

    override suspend fun deleteContacts(id: Int): MyResponse = api.deleteContact(id).body()!!

}