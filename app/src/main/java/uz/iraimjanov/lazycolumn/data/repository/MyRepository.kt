package uz.iraimjanov.lazycolumn.data.repository

import uz.iraimjanov.lazycolumn.model.ContactRequest
import uz.iraimjanov.lazycolumn.model.ContactResponse
import uz.iraimjanov.lazycolumn.model.MyResponse

interface MyRepository {
    suspend fun getAllContact(): List<ContactResponse>
    suspend fun addContact(contactRequest: ContactRequest): MyResponse
    suspend fun updateContacts(contactResponse: ContactResponse): MyResponse
    suspend fun deleteContacts(id: Int): MyResponse
}